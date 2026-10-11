package com.bookathon.backend.entity.impl;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "knjiga") 
public class Knjiga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long KnjigaID;

    private String naziv;
    
    private int stanje;
    @Column(name = "autor", nullable = false)
    private String autor;
    @Column(name = "godinaIzdanja")
    private LocalDate godinaIzdanja;
    @Column(name = "cena", nullable = false)
    private Double cena;
    
    private String slika;
    @ManyToOne
    @JoinColumn(name = "izdavackaKucaFK")
    private IzdavackaKuca izdavackaKuca;
    private String opis;
    @Column(name="rezervisano_stanje")
    private Integer rezervisanoStanje=0;
    public Knjiga() {}

    public Knjiga(String naslov, String autor, Double cena,int stanje,String opis,String slika) {
        this.naziv = naslov;
        this.autor = autor;
        this.cena = cena;
        this.stanje=stanje;
        this.opis=opis;
        this.slika=slika;
    }

    public Long getId() { return KnjigaID; }
    public void setId(Long id) { this.KnjigaID = id; }

    public LocalDate getGodinaIzdanja() {
        return godinaIzdanja;
    }

    public void setGodinaIzdanja(LocalDate godinaIzdanja) {
        this.godinaIzdanja = godinaIzdanja;
    }

    public String getNaslov() { return naziv; }
    public void setNaslov(String naslov) { this.naziv = naslov; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public Double getCena() { return cena; }
    public void setCena(Double cena) { this.cena = cena; }

    public IzdavackaKuca getIzdavackaKuca() {  return izdavackaKuca;
    }

    public void setIzdavackaKuca(IzdavackaKuca izdavackaKuca) {this.izdavackaKuca = izdavackaKuca;
    }

    public int getStanje() {
        return stanje;
    }

    public void setStanje(int stanje) {
        this.stanje = stanje;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public int getRezervisanoStanje() {
        return rezervisanoStanje;
    }

    public void setRezervisanoStanje(int rezervisanoStanje) {
        this.rezervisanoStanje = rezervisanoStanje;
    }
    
}