/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.mapper.impl;

import com.bookathon.backend.dto.impl.PorudzbinaDTO;
import com.bookathon.backend.entity.impl.Porudzbina;
import com.bookathon.backend.entity.impl.User;
import java.util.stream.Collectors;

/**
 *
 * @author user
 */
public class PorudzbinaMapper {
     private StavkaPorudzbineMapper spm=new StavkaPorudzbineMapper();

     public PorudzbinaDTO toDto(Porudzbina i){
        PorudzbinaDTO dto=new PorudzbinaDTO();

        dto.setDatum(i.getDatumPorudzbine());
        dto.setPorudzbinaID(i.getPorudzbinaID());
        dto.setStatusPorudzbine(i.getStatusPorudzbine());
        
        
        
        
        dto.setUkupanIznos(i.getUkupanIznos());
        if (i.getKorisnik() != null) {
            dto.setUserID(i.getKorisnik().getUserID());
        }
        if (i.getStavke()!=null) {
            dto.setStavke(i.getStavke().stream().map(spm::toDto).collect(Collectors.toList()));
        }
        dto.setKupacUsername(i.getKorisnik().getUsername());
    return dto;
    }
    public Porudzbina toEntity(PorudzbinaDTO i){
        Porudzbina dto=new Porudzbina();
        
         dto.setDatumPorudzbine(i.getDatum());
        dto.setPorudzbinaID(i.getPorudzbinaID());
        dto.setStatusPorudzbine(dto.getStatusPorudzbine());
        dto.setUkupanIznos(i.getUkupanIznos());
        if (i.getUserID()!= null) {
            User u=new User();
            u.setUserID(i.getUserID());
                    
            dto.setKorisnik(u);
        }
        if (i.getStavke()!=null) {
            dto.setStavke(i.getStavke().stream().map(spm::toEntity).collect(Collectors.toList()));
        }

     return dto;
    }
    
}
