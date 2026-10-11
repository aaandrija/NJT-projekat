package com.bookathon.backend.entity.impl;

import com.bookathon.backend.entity.enums.Uloga;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserID;

    private String username;
    private String password;
    private String email;
    private String ime;
    private String prezime;
    private String adresa;
    @Enumerated(EnumType.STRING)
    private Uloga uloga;

    private Boolean emailPotvrdjen = false;
  private String verifikacioniToken;
//    private String resetLozinkeToken;

    public Long getUserID() { return UserID; }
    public void setUserID(Long UserID) { this.UserID = UserID; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
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
    public Boolean getEmailPotvrdjen() { return emailPotvrdjen; }
    public void setEmailPotvrdjen(Boolean emailPotvrdjen) { this.emailPotvrdjen = emailPotvrdjen; }
    public String getVerifikacioniToken() { return verifikacioniToken; }
    public void setVerifikacioniToken(String verifikacioniToken) { this.verifikacioniToken = verifikacioniToken; }
//    public String getResetLozinkeToken() { return resetLozinkeToken; }
//    public void setResetLozinkeToken(String resetLozinkeToken) { this.resetLozinkeToken = resetLozinkeToken; }
}