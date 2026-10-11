/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.dto.impl;

import com.bookathon.backend.entity.enums.StatusOtpremnice;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author user
 */
public class OtpremnicaDTO {
        private Long otpremnicaID;
    private String brojOtpremnice;
    private LocalDate datum;
    private StatusOtpremnice statusOtpremnice;
    private Double iznos;
    private Long porudzbinaID; 
    private List<StavkaOtpremniceDTO> stavke;

    public OtpremnicaDTO() {}

    
    public Long getOtpremnicaID() { return otpremnicaID; }
    public void setOtpremnicaID(Long otpremnicaID) { this.otpremnicaID = otpremnicaID; }

    public String getBrojOtpremnice() { return brojOtpremnice; }
    public void setBrojOtpremnice(String brojOtpremnice) { this.brojOtpremnice = brojOtpremnice; }

    public LocalDate getDatum() { return datum; }
    public void setDatum(LocalDate datum) { this.datum = datum; }

    public StatusOtpremnice getStatusOtpremnice() { return statusOtpremnice; }
    public void setStatusOtpremnice(StatusOtpremnice statusOtpremnice) { this.statusOtpremnice = statusOtpremnice; }

    public Double getIznos() { return iznos; }
    public void setIznos(Double iznos) { this.iznos = iznos; }

    public Long getPorudzbinaID() { return porudzbinaID; }
    public void setPorudzbinaID(Long porudzbinaID) { this.porudzbinaID = porudzbinaID; }

    public List<StavkaOtpremniceDTO> getStavke() { return stavke; }
    public void setStavke(List<StavkaOtpremniceDTO> stavke) { this.stavke = stavke; }
    
}
