/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.entity.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name = "izdavackakuca") 
public class IzdavackaKuca {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IzdavackaKucaID;
     private String naziv;
     private String adresa;

    public Long getIzdavackaKucaID() {
        return IzdavackaKucaID;
    }

    public void setIzdavackaKucaID(Long IzdavackaKucaID) {
        this.IzdavackaKucaID = IzdavackaKucaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
     
}
