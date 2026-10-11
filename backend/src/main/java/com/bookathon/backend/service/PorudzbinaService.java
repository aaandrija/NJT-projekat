/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.service;

import com.bookathon.backend.entity.enums.StatusPorudzbine;
import com.bookathon.backend.entity.impl.Porudzbina;
import com.bookathon.backend.entity.impl.StavkaPorudzbine;
import com.bookathon.backend.repository.PorudzbinaRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookathon.backend.entity.impl.Knjiga;
import jakarta.transaction.Transactional;
/**
 *
 * @author user
 */
@Service
public class PorudzbinaService {
    @Autowired
    private PorudzbinaRepository porudzbinaRepository;

    @Autowired
    private EmailService emailService;
    @Autowired
    private KnjigaService knjigaService;
    
    public List<Porudzbina> getAll() { return porudzbinaRepository.findAll(); }
    public Porudzbina getById(Long id) { return porudzbinaRepository.findById(id).orElse(null); }
    public List<Porudzbina> getByUser(Long korisnikId) { return porudzbinaRepository.findByUser_UserID(korisnikId); }
    public void delete(Long id) { porudzbinaRepository.deleteById(id); }
    
    @Transactional
    public Porudzbina saveWithStavke(Porudzbina porudzbina, List<StavkaPorudzbine> stavke) {
        double ukupno = 0;
        for (StavkaPorudzbine s : stavke) {
            Knjiga k=nadjiKnjigu(s.getKNjiga());
            if(k.getStanje()-k.getRezervisanoStanje()<s.getKolicina()){
            throw new RuntimeException("Nema dovoljno knjiga na stanju za: " + k.getNaslov());
            }
            k.setRezervisanoStanje(k.getRezervisanoStanje()+s.getKolicina());
            sacuvajKnjigu(k);
            s.setPorudzbina(porudzbina);
            ukupno += s.getCenaPoJedinici() * s.getKolicina();
        }
        porudzbina.setStavke(stavke);
        porudzbina.setUkupanIznos(ukupno);
        porudzbina.setDatumPorudzbine(LocalDate.now());
        porudzbina.setStatusPorudzbine(StatusPorudzbine.KREIRANA);
        Porudzbina sacuvana = porudzbinaRepository.save(porudzbina);

        if (sacuvana.getKorisnik() != null && sacuvana.getKorisnik().getEmail() != null) {
            try {
                emailService.posaljiPotvrduPorudzbine(sacuvana.getKorisnik().getEmail(), sacuvana.getPorudzbinaID(), sacuvana.getUkupanIznos());
            } catch (Exception e) {
                System.err.println("Greska pri slanju potvrde: " + e.getMessage());
            }
        }

        return sacuvana;
    }

    public Porudzbina save(Porudzbina p) { return porudzbinaRepository.save(p); }

    public Porudzbina otkazi(Long id) {
        Porudzbina p = getById(id);
        for(StavkaPorudzbine s:p.getStavke()){
        Knjiga k=nadjiKnjigu(s.getKNjiga());
        k.setRezervisanoStanje(k.getRezervisanoStanje()-s.getKolicina());
        sacuvajKnjigu(k);
        }
        if (p != null) {
            p.setStatusPorudzbine(StatusPorudzbine.OTKAZANA);
            return porudzbinaRepository.save(p);
        }
        return null;
    }

    private Knjiga nadjiKnjigu(Knjiga kNjiga) {
        return knjigaService.getById(kNjiga.getId());
    }

    private void sacuvajKnjigu(Knjiga k) {
        knjigaService.save(k);
    }
}
