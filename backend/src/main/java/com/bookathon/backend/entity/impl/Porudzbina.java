package com.bookathon.backend.entity.impl;


import com.bookathon.backend.entity.enums.StatusPorudzbine;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "porudzbina")
public class Porudzbina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long porudzbinaID;

    private LocalDate datum;

    @Enumerated(EnumType.STRING)
    private StatusPorudzbine statusPorudzbine;

   

    
    private Double ukupanIznos;

    @ManyToOne
    @JoinColumn(name = "userFK")
    private User user;

    @OneToMany(mappedBy = "porudzbina", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StavkaPorudzbine> stavke = new ArrayList<>();

    @OneToMany(mappedBy = "porudzbina", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Otpremnica> otpremnice = new ArrayList<>();

    public Long getPorudzbinaID() { return porudzbinaID; }
    public void setPorudzbinaID(Long porudzbinaID) { this.porudzbinaID = porudzbinaID; }
    public LocalDate getDatumPorudzbine() { return datum; }
    public void setDatumPorudzbine(LocalDate datumPorudzbine) { this.datum = datumPorudzbine; }
    public StatusPorudzbine getStatusPorudzbine() { return statusPorudzbine; }
    public void setStatusPorudzbine(StatusPorudzbine statusPorudzbine) { this.statusPorudzbine = statusPorudzbine; }
   public Double getUkupanIznos() { return ukupanIznos; }
    public void setUkupanIznos(Double ukupanIznos) { this.ukupanIznos = ukupanIznos; }
    public User getKorisnik() { return user; }
    public void setKorisnik(User korisnik) { this.user = korisnik; }
    public List<StavkaPorudzbine> getStavke() { return stavke; }
    public void setStavke(List<StavkaPorudzbine> stavke) { this.stavke = stavke; }
    public List<Otpremnica> getOtpremnice() { return otpremnice; }
    public void setOtpremnice(List<Otpremnica> otpremnice) { this.otpremnice = otpremnice; }
}
