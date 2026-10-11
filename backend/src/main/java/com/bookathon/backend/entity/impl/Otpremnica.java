package com.bookathon.backend.entity.impl;


import com.bookathon.backend.entity.enums.StatusOtpremnice;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "otpremnica")
public class Otpremnica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long otpremnicaID;

    private String brojOtpremnice;
    private LocalDate datum;

    @Enumerated(EnumType.STRING)
    private StatusOtpremnice statusOtpremnice;

   
   
    private Double iznos;
  

    @ManyToOne
    @JoinColumn(name = "porudzbinaFK")
    private Porudzbina porudzbina;

    @OneToMany(mappedBy = "otpremnica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StavkaOtpremnice> stavke = new ArrayList<>();

    public Long getOtpremnicaID() { return otpremnicaID; }
    public void setOtpremnicaID(Long otpremnicaID) { this.otpremnicaID = otpremnicaID; }
    public String getBrojOtpremnice() { return brojOtpremnice; }
    public void setBrojOtpremnice(String brojOtpremnice) { this.brojOtpremnice = brojOtpremnice; }
    
    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public StatusOtpremnice getStatusOtpremnice() {
        return statusOtpremnice;
    }

    public void setStatusOtpremnice(StatusOtpremnice statusOtpremnice) {
        this.statusOtpremnice = statusOtpremnice;
    }
   
   
    public Double getIznos() { return iznos; }
    public void setIznos(Double iznos) { this.iznos = iznos; }
   
    public Porudzbina getPorudzbina() { return porudzbina; }
    public void setPorudzbina(Porudzbina porudzbina) { this.porudzbina = porudzbina; }
    public List<StavkaOtpremnice> getStavke() { return stavke; }
    public void setStavke(List<StavkaOtpremnice> stavke) { this.stavke = stavke; }
}