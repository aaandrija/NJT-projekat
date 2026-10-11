/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.service;

import com.bookathon.backend.entity.enums.StatusOtpremnice;
import com.bookathon.backend.entity.enums.StatusPorudzbine;
import com.bookathon.backend.entity.impl.Knjiga;
import com.bookathon.backend.entity.impl.Otpremnica;
import com.bookathon.backend.entity.impl.Porudzbina;
import com.bookathon.backend.entity.impl.StavkaOtpremnice;
import com.bookathon.backend.repository.KnjigaRepository;
import com.bookathon.backend.repository.OtpremnicaRepository;
import com.bookathon.backend.repository.PorudzbinaRepository;
import jakarta.transaction.Transactional;
import java.io.ObjectInputFilter.Status;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class OtpremnicaService {
  @Autowired
    private OtpremnicaRepository otpremnicaRepository;
    @Autowired
    private KnjigaRepository knjigaRepository;
    @Autowired
    private PorudzbinaRepository porudzbinaRepository;
    @Autowired
    private EmailService emailService;

    public List<Otpremnica> getAll() { return otpremnicaRepository.findAll(); }
    public Otpremnica getById(Long id) { return otpremnicaRepository.findById(id).orElse(null); }

    public static class StavkaZahtev {
        public Long knjigaId;
        public Integer kolicina;
    }

    @Transactional
    public Otpremnica generisiOtpremnicu(Long porudzbinaId, List<StavkaZahtev> zahtevi) {
        Porudzbina porudzbina = porudzbinaRepository.findById(porudzbinaId)
            .orElseThrow(() -> new RuntimeException("Porudzbina ne postoji"));

        Otpremnica otpremnica = new Otpremnica();
        otpremnica.setPorudzbina(porudzbina);
        otpremnica.setBrojOtpremnice(generisiBroj());
        otpremnica.setDatum(LocalDate.now());
        otpremnica.setStatusOtpremnice(StatusOtpremnice.IZDATA);

        double ukupnoIznos = 0;

        for (StavkaZahtev zahtev : zahtevi) {
            Knjiga knjiga = knjigaRepository.findById(zahtev.knjigaId)
                .orElseThrow(() -> new RuntimeException("Knjiga ne postoji"));

            if (knjiga.getRezervisanoStanje()< zahtev.kolicina) {
                throw new RuntimeException("Pogresno ste uneli za " + knjiga.getNaslov());
            }

            double iznosStavke = knjiga.getCena() * zahtev.kolicina;

            StavkaOtpremnice stavka = new StavkaOtpremnice();
            stavka.setKnjiga(knjiga);
            stavka.setKolicina(zahtev.kolicina);
            stavka.setCenaPoJedinici(knjiga.getCena());
            stavka.setIZnos(iznosStavke);
            stavka.setOtpremnica(otpremnica);
            otpremnica.getStavke().add(stavka);

            knjiga.setStanje(knjiga.getStanje() - zahtev.kolicina);
            knjiga.setRezervisanoStanje(knjiga.getRezervisanoStanje()-zahtev.kolicina);
            knjigaRepository.save(knjiga);

            ukupnoIznos += iznosStavke;
        }

        otpremnica.setIznos(ukupnoIznos);
        Otpremnica sacuvana = otpremnicaRepository.save(otpremnica);

        azurirajStatusPorudzbine(porudzbina);

        try {
            if (porudzbina.getKorisnik() != null && porudzbina.getKorisnik().getEmail() != null) {
                emailService.posaljiObavestenjeOOtpremnici(porudzbina.getKorisnik().getEmail(), sacuvana.getBrojOtpremnice(),zahtevi);
            }
        } catch (Exception e) {
            System.err.println("Greska pri slanju obavestenja: " + e.getMessage());
        }

        return sacuvana;
    }

    @Transactional
    public Otpremnica storniraj(Long otpremnicaId) {
        Otpremnica otpremnica = otpremnicaRepository.findById(otpremnicaId)
            .orElseThrow(() -> new RuntimeException("Otpremnica ne postoji"));

        if (otpremnica.getStatusOtpremnice() == StatusOtpremnice.STORNIRANA) {
            throw new RuntimeException("Otpremnica je vec stornirana.");
        }

        for (StavkaOtpremnice s : otpremnica.getStavke()) {
            Knjiga knjiga = s.getKNjiga();
            knjiga.setStanje(knjiga.getStanje() + s.getKolicina());
            knjiga.setRezervisanoStanje(knjiga.getRezervisanoStanje()+s.getKolicina());
            knjigaRepository.save(knjiga);
        }

        otpremnica.setStatusOtpremnice(StatusOtpremnice.STORNIRANA);
        Otpremnica sacuvana = otpremnicaRepository.save(otpremnica);

        azurirajStatusPorudzbine(otpremnica.getPorudzbina());

        try {
            if (otpremnica.getPorudzbina().getKorisnik()!= null) {
                emailService.posaljiObavestenjeOOtkazivanju(
                    otpremnica.getPorudzbina().getKorisnik().getEmail(),
                    otpremnica.getBrojOtpremnice()
                );
            }
        } catch (Exception e) {
            System.err.println("Greska pri slanju obavestenja: " + e.getMessage());
        }

        return sacuvana;
    }

    private void azurirajStatusPorudzbine(Porudzbina porudzbina) {
        double narucenoUkupno = porudzbina.getStavke().stream()
            .mapToDouble(s -> s.getKolicina())
            .sum();

        double isporucenoUkupno = porudzbina.getOtpremnice().stream()
            .filter(o -> o.getStatusOtpremnice() == StatusOtpremnice.IZDATA)
            .flatMap(o -> o.getStavke().stream())
            .mapToDouble(s -> s.getKolicina())
            .sum();

        if (isporucenoUkupno >= narucenoUkupno && narucenoUkupno > 0) {
            porudzbina.setStatusPorudzbine(StatusPorudzbine.ISPORUCENA);
        } else if (isporucenoUkupno > 0) {
            porudzbina.setStatusPorudzbine(StatusPorudzbine.PARCIJALNO_ISPORUCENA);
        } else {
            porudzbina.setStatusPorudzbine(StatusPorudzbine.KREIRANA);
        }
        porudzbinaRepository.save(porudzbina);
    }

    private String generisiBroj() {
        long broj = otpremnicaRepository.count() + 1;
        return String.format("OTPREMNICA-%d-%03d", LocalDate.now().getYear(), broj);
    }

    public void delete(Long id) { otpremnicaRepository.deleteById(id); }
}
