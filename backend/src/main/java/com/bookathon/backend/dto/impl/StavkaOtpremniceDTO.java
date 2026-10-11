/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.dto.impl;

/**
 *
 * @author user
 */
public class StavkaOtpremniceDTO {
    private Long redniBroj;

    private Integer kolicina;

    private Double jedinicnaCena;
    private Double iznos;

    private Long otpremnicaID;

    private Long knjigaID;

    public StavkaOtpremniceDTO() {}

    public StavkaOtpremniceDTO(Long redniBroj, Integer kolicina, Double jedinicnaCena, Double iznos, Long otpremnicaID, Long knjigaID) {
        this.redniBroj = redniBroj;
        this.kolicina = kolicina;
        this.jedinicnaCena = jedinicnaCena;
        this.iznos = iznos;
        this.otpremnicaID = otpremnicaID;
        this.knjigaID = knjigaID;
    }

    public Long getRedniBroj() { return redniBroj; }
    public void setRedniBroj(Long redniBroj) { this.redniBroj = redniBroj; }

    public Integer getKolicina() { return kolicina; }
    public void setKolicina(Integer kolicina) { this.kolicina = kolicina; }

    public Double getJedinicnaCena() { return jedinicnaCena; }
    public void setJedinicnaCena(Double jedinicnaCena) { this.jedinicnaCena = jedinicnaCena; }

    public Double getIznos() { return iznos; }
    public void setIznos(Double iznos) { this.iznos = iznos; }

    public Long getOtpremnicaID() { return otpremnicaID; }
    public void setOtpremnicaID(Long otpremnicaID) { this.otpremnicaID = otpremnicaID; }

    public Long getKnjigaID() { return knjigaID; }
    public void setKnjigaID(Long knjigaID) { this.knjigaID = knjigaID; }
}
