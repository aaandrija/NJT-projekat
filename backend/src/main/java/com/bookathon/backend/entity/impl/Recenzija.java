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
@Table(name = "recenzija")
public class Recenzija {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recenzijaId;
    
   
    @ManyToOne
    @JoinColumn(name = "userFK")
    private User user;
   
    @ManyToOne
    @JoinColumn(name = "knjigaFK")
    private Knjiga knjiga;
    
    private double ocena;
    private String poruka;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public Long getRecenzijaId() {
        return recenzijaId;
    }

    public void setRecenzijaId(Long recenzijaId) {
        this.recenzijaId = recenzijaId;
    }
    
    
}
