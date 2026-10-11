/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.dto.impl;

/**
 *
 * @author user
 */
public class StavkaPorudzbineDTO {
    private Long redniBroj;

    
    private Integer kolicina;

    private Double jedinicnaCena;
    private Double iznos;

    private Long porudzbinaID;

    
    private Long knjigaID;
   
    private String nazivKnjige;
    
    public StavkaPorudzbineDTO() {}

    public StavkaPorudzbineDTO(Long redniBroj, Integer kolicina, Double jedinicnaCena, Double iznos, Long porudzbinaID, Long knjigaID) {
        this.redniBroj = redniBroj;
        this.kolicina = kolicina;
        this.jedinicnaCena = jedinicnaCena;
        this.iznos = iznos;
        this.porudzbinaID = porudzbinaID;
        this.knjigaID = knjigaID;
    }

  
    public Long getRedniBroj() { return redniBroj; }
    public void setRedniBroj(Long redniBroj) { this.redniBroj = redniBroj; }

    public Integer getKolicina() { return kolicina; }
    public void setKolicina(Integer kolicina) { this.kolicina = kolicina; }

    public Double getJedinicnaCena() { return jedinicnaCena; }
    public void setJedinicnaCena(Double jedinicnaCena) { this.jedinicnaCena = jedinicnaCena; }

    public Double getIznos() { return iznos; }
    public void setIznos(Double iznos) { this.iznos = iznos; }

    public Long getPorudzbinaID() { return porudzbinaID; }
    public void setPorudzbinaID(Long porudzbinaID) { this.porudzbinaID = porudzbinaID; }

    public Long getKnjigaID() { return knjigaID; }
    public void setKnjigaID(Long knjigaID) { this.knjigaID = knjigaID; }

    public String getNazivKnjige() {
        return nazivKnjige;
    }

    public void setNazivKnjige(String nazivKnjige) {
        this.nazivKnjige = nazivKnjige;
    }
    
    
}
