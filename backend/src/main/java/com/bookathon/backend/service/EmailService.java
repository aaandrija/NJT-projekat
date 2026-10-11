/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.service;

import com.bookathon.backend.entity.impl.EmailZadatak;
import com.bookathon.backend.entity.impl.Knjiga;
import com.bookathon.backend.entity.impl.Porudzbina;
import com.bookathon.backend.entity.impl.StavkaPorudzbine;
import com.bookathon.backend.repository.EmailZadatakRepository;
import com.bookathon.backend.repository.KnjigaRepository;
import com.bookathon.backend.repository.PorudzbinaRepository;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class EmailService {

       @Autowired
    private EmailZadatakRepository emailZadatakRepository;
       
       @Autowired
    private KnjigaRepository knjigaRepository;
       @Autowired
       private PorudzbinaRepository porudzbinaRepository;
    public void posaljiVerifikacioniEmail(String email, String token) {
        String link = "http://localhost:5173/verifikuj?token=" + token;

        EmailZadatak zadatak = new EmailZadatak();
        zadatak.setPrimalac(email);
        zadatak.setNaslov("Bookathon - Potvrda email adrese");
        zadatak.setSadrzaj(
            "Dobrodošli na Bookathon!\n\n" +
            "Kliknite na sledeći link da potvrdite svoju email adresu i dovršite registraciju:\n\n" +
            link + "\n\n" +
            "Ako niste vi zatražili registraciju, ignorišite ovaj mejl."
        );
        emailZadatakRepository.save(zadatak);
    }
    
    

    public void posaljiPotvrduPorudzbine(String email, Long porudzbinaId, Double ukupanIznos) {
        EmailZadatak zadatak = new EmailZadatak();
        Porudzbina po=porudzbinaRepository.getById(porudzbinaId);

        String pomocni="";
        for(StavkaPorudzbine s:po.getStavke()){
             Knjiga k=knjigaRepository.getById(s.getKNjiga().getId());
        pomocni+=k.getNaslov()+" --- "+"naruceno "+s.getKolicina()+"\n";
        }
        zadatak.setPrimalac(email);
        zadatak.setNaslov("Potvrda porudžbine #" + porudzbinaId);
        zadatak.setSadrzaj(
            "Poštovani,\n\n" +
            "Vaša porudžbina #" + porudzbinaId + " je uspešno kreirana\n\n" +
            "Ukupan iznos: " + ukupanIznos + " RSD\n\n" +
                    "Pregled Porudzbine: \n"+
                    pomocni+
            "Bićete obavešteni kada Vaša porudžbina bude poslata\n\n" );
        emailZadatakRepository.save(zadatak);
    }

    public void posaljiObavestenjeOOtkazivanju(String email, String brojOtpremnice) {
        EmailZadatak zadatak = new EmailZadatak();
        zadatak.setPrimalac(email);
        zadatak.setNaslov("Ispravka otpremnice " + brojOtpremnice);
        zadatak.setSadrzaj(
            "Poštovani,\n\n" +
            "Obaveštavamo vas da je otpremnica " + brojOtpremnice + " koju ste ranije dobili " +
            "imala grešku u sebi i otkazana je. Uskoro ćete dobiti ispravnu otpremnicu sa tačnim podacima.\n\n" +
            "Izvinjavamo Vam se na neprijatnosti"
        );
        emailZadatakRepository.save(zadatak);
    }

    void posaljiObavestenjeOOtpremnici(String email, String brojOtpremnice,List<OtpremnicaService.StavkaZahtev> zahtevi) {
        EmailZadatak zadatak = new EmailZadatak();
        String pomocni="";
        for(OtpremnicaService.StavkaZahtev z:zahtevi){
            Knjiga k=knjigaRepository.getById(z.knjigaId);
            pomocni+=k.getNaslov()+" ----"+" poslato "+z.kolicina+" komada\n";
        }
        zadatak.setPrimalac(email);
        zadatak.setNaslov("Otpremnica " + brojOtpremnice);
        zadatak.setSadrzaj(
            "Poštovani,\n\n" +
            "Obaveštavamo vas da je otpremnica " + brojOtpremnice + " kreirana \n" 
                +"Pregled poslatih knjiga: \n"+
                    pomocni
            
        );
        emailZadatakRepository.save(zadatak);
    }
}