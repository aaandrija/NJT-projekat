/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.dto.impl;

/**
 *
 * @author user
 */
public class RecenzijaDTO {
    private Long recenzijaId;

    
    private Double ocena;

   
    private String poruka;

    private Long userID;

    private Long knjigaID;

    public String korisnik;
    public RecenzijaDTO() {}

    public RecenzijaDTO(Long recenzijaId, Double ocena, String poruka, Long userID, Long knjigaID,String korsinik) {
        this.recenzijaId = recenzijaId;
        this.ocena = ocena;
        this.poruka = poruka;
        this.userID = userID;
        this.knjigaID = knjigaID;
        this.korisnik=korsinik;
    }

    public String getKorsinik() {
        return korisnik;
    }

    public void setKorsinik(String korsinik) {
        this.korisnik = korsinik;
    }

    public Long getRecenzijaId() { return recenzijaId; }
    public void setRecenzijaId(Long recenzijaId) { this.recenzijaId = recenzijaId; }

    public Double getOcena() { return ocena; }
    public void setOcena(Double ocena) { this.ocena = ocena; }

    public String getPoruka() { return poruka; }
    public void setPoruka(String poruka) { this.poruka = poruka; }

    public Long getUserID() { return userID; }
    public void setUserID(Long userID) { this.userID = userID; }

    public Long getKnjigaID() { return knjigaID; }
    public void setKnjigaID(Long knjigaID) { this.knjigaID = knjigaID; }
}
