/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.dto.impl;

import com.bookathon.backend.entity.enums.StatusPorudzbine;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author user
 */
public class PorudzbinaDTO {
    private Long porudzbinaID;
    private LocalDate datum;
    private StatusPorudzbine statusPorudzbine;
    private Double ukupanIznos;
    private Long userID; 
    private List<StavkaPorudzbineDTO> stavke;
    private List<OtpremnicaDTO> otpremnice;
    private String KupacUsername;
    public PorudzbinaDTO() {}

    public String getKupacUsername() {
        return KupacUsername;
    }

    public void setKupacUsername(String KupacUsername) {
        this.KupacUsername = KupacUsername;
    }

    public Long getPorudzbinaID() { return porudzbinaID; }
    public void setPorudzbinaID(Long porudzbinaID) { this.porudzbinaID = porudzbinaID; }

    public LocalDate getDatum() { return datum; }
    public void setDatum(LocalDate datum) { this.datum = datum; }

    public StatusPorudzbine getStatusPorudzbine() { return statusPorudzbine; }
    public void setStatusPorudzbine(StatusPorudzbine statusPorudzbine) { this.statusPorudzbine = statusPorudzbine; }

    public Double getUkupanIznos() { return ukupanIznos; }
    public void setUkupanIznos(Double ukupanIznos) { this.ukupanIznos = ukupanIznos; }

    public Long getUserID() { return userID; }
    public void setUserID(Long userID) { this.userID = userID; }

    public List<StavkaPorudzbineDTO> getStavke() { return stavke; }
    public void setStavke(List<StavkaPorudzbineDTO> stavke) { this.stavke = stavke; }

    public List<OtpremnicaDTO> getOtpremnice() { return otpremnice; }
    public void setOtpremnice(List<OtpremnicaDTO> otpremnice) { this.otpremnice = otpremnice; }
    
}
