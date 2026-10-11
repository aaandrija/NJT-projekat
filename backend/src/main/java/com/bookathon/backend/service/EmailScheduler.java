package com.bookathon.backend.service;

import com.bookathon.backend.entity.impl.EmailZadatak;
import com.bookathon.backend.repository.EmailZadatakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;

@Component
public class EmailScheduler {

    @Autowired
    private EmailZadatakRepository emailZadatakRepository;
    @Autowired
    private JavaMailSender mailSender;

    @Scheduled(fixedRate = 10000)
    public void posaljiCekajuceMejlove() {
        List<EmailZadatak> cekaju = emailZadatakRepository.findByPoslatFalse();

        for (EmailZadatak zadatak : cekaju) {
            try {
                MimeMessage poruka = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(poruka);

                helper.setTo(zadatak.getPrimalac());
                helper.setSubject(zadatak.getNaslov());
                helper.setText(zadatak.getSadrzaj());
                helper.setFrom("spicy.pepper2304@gmail.com");
               

                mailSender.send(poruka);

                zadatak.setPoslat(true);
                zadatak.setPoslatoU(LocalDateTime.now());
                emailZadatakRepository.save(zadatak);

                System.out.println("Mejl uspesno poslat: " + zadatak.getPrimalac() + " - " + zadatak.getNaslov());
            } catch (Exception e) {
                System.err.println("Greska pri slanju mejla za zadatak #" + zadatak.getId() + ": " + e.getMessage());
            }
        }
    }
}