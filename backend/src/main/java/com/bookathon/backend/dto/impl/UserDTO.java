/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.dto.impl;

import com.bookathon.backend.entity.enums.Uloga;

/**
 *
 * @author user
 */
public class UserDTO {
   private Long userID;
   
    private String username;
    private String email;
    private String ime;
    private String prezime;
    private String adresa;
    private Uloga uloga;
     private String password;
    public UserDTO() {}

    public UserDTO(Long userID, String username, String email, String ime, String prezime, String adresa, Uloga uloga,String password) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.uloga = uloga;
        this.password=password;
    }

    public Long getUserID() { return userID; }
    public void setUserID(Long userID) { this.userID = userID; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getIme() { return ime; }
    public void setIme(String ime) { this.ime = ime; }

    public String getPrezime() { return prezime; }
    public void setPrezime(String prezime) { this.prezime = prezime; }

    public String getAdresa() { return adresa; }
    public void setAdresa(String adresa) { this.adresa = adresa; }

    public Uloga getUloga() { return uloga; }
    public void setUloga(Uloga uloga) { this.uloga = uloga; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
