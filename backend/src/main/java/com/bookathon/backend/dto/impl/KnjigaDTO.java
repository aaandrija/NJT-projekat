/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.dto.impl;

import java.time.LocalDate;

/**
 *
 * @author user
 */
public class KnjigaDTO {
    private Long knjigaID;
    private String naziv;
    private String autor;
    private Double cena;
    private Long izdavackaKucaID;
    private String opis;
    private int stanje;
      private String slika;
      private LocalDate datum;

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
    public KnjigaDTO() {}

    public KnjigaDTO(Long knjigaID, String naziv, String autor, Double cena, Long izdavackaKucaID,String opis,int stanje,String slika) {
        this.knjigaID = knjigaID;
        this.naziv = naziv;
        this.autor = autor;
        this.cena = cena;
        this.izdavackaKucaID = izdavackaKucaID;
        this.opis=opis;
        this.stanje=stanje;
        this.slika=slika;
    }

    public Long getKnjigaID() { return knjigaID; }
    public void setKnjigaID(Long knjigaID) { this.knjigaID = knjigaID; }

    public String getNaziv() { return naziv; }
    public void setNaziv(String naziv) { this.naziv = naziv; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public Double getCena() { return cena; }
    public void setCena(Double cena) { this.cena = cena; }

    public Long getIzdavackaKucaID() { return izdavackaKucaID; }
    public void setIzdavackaKucaID(Long izdavackaKucaID) { this.izdavackaKucaID = izdavackaKucaID; }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getStanje() {
        return stanje;
    }

    public void setStanje(int stanje) {
        this.stanje = stanje;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

   
}
