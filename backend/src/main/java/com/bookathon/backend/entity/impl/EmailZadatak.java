
    package com.bookathon.backend.entity.impl;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "email_zadatak")
public class EmailZadatak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String primalac;
    private String naslov;

    @Column(columnDefinition = "TEXT")
    private String sadrzaj;



    private Boolean poslat = false;
    private LocalDateTime kreirano = LocalDateTime.now();
    private LocalDateTime poslatoU;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPrimalac() { return primalac; }
    public void setPrimalac(String primalac) { this.primalac = primalac; }
    public String getNaslov() { return naslov; }
    public void setNaslov(String naslov) { this.naslov = naslov; }
    public String getSadrzaj() { return sadrzaj; }
    public void setSadrzaj(String sadrzaj) { this.sadrzaj = sadrzaj; }

    public Boolean getPoslat() { return poslat; }
    public void setPoslat(Boolean poslat) { this.poslat = poslat; }
    public LocalDateTime getKreirano() { return kreirano; }
    public void setKreirano(LocalDateTime kreirano) { this.kreirano = kreirano; }
    public LocalDateTime getPoslatoU() { return poslatoU; }
    public void setPoslatoU(LocalDateTime poslatoU) { this.poslatoU = poslatoU; }
}

