/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.dto.impl;

/**
 *
 * @author user
 */
public class IzdavackaKucaDTO {
    private Long izdavackaKucaID;
    private String naziv;
    private String adresa;

    public IzdavackaKucaDTO() {}

    public IzdavackaKucaDTO(Long izdavackaKucaID, String naziv, String adresa) {
        this.izdavackaKucaID = izdavackaKucaID;
        this.naziv = naziv;
        this.adresa = adresa;
    }

    
    public Long getIzdavackaKucaID() { return izdavackaKucaID; }
    public void setIzdavackaKucaID(Long izdavackaKucaID) { this.izdavackaKucaID = izdavackaKucaID; }

    public String getNaziv() { return naziv; }
    public void setNaziv(String naziv) { this.naziv = naziv; }

    public String getAdresa() { return adresa; }
    public void setAdresa(String adresa) { this.adresa = adresa; }
}
