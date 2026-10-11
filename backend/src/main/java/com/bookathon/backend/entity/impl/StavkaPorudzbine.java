/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.entity.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name = "stavkaporudzbine")
public class StavkaPorudzbine {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long redniBroj;

    private Integer kolicina;
    private Double jedinicnaCena;
    private Double iznos;
    @ManyToOne
    @JoinColumn(name = "porudzbinaFK")
    private Porudzbina porudzbina;

    @ManyToOne
    @JoinColumn(name = "KnjigaFK")
    private Knjiga knjiga;

    public Long getRb() { return redniBroj; }
    public void setRb(Long rb) { this.redniBroj = rb; }
    public Integer getKolicina() { return kolicina; }
    public void setKolicina(Integer kolicina) { this.kolicina = kolicina; }
    public Double getCenaPoJedinici() { return jedinicnaCena; }
    public void setCenaPoJedinici(Double cenaPoJedinici) { this.jedinicnaCena = cenaPoJedinici; }
     public Double getIznos() { return iznos; }
    public void setIZnos(Double iznos) { this.iznos = iznos; }
    
    public Porudzbina getPorudzbina() { return porudzbina; }
    public void setPorudzbina(Porudzbina porudzbina) { this.porudzbina = porudzbina; }
    public Knjiga getKNjiga() { return knjiga; }
    public void setKnjiga(Knjiga knjiga) { this.knjiga = knjiga; }
    
}
