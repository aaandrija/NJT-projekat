/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.mapper.impl;

import com.bookathon.backend.dto.impl.StavkaOtpremniceDTO;
import com.bookathon.backend.entity.impl.Knjiga;
import com.bookathon.backend.entity.impl.Otpremnica;
import com.bookathon.backend.entity.impl.StavkaOtpremnice;

/**
 *
 * @author user
 */
public class StavkaOtpremniceMapper {
     public StavkaOtpremniceDTO toDto(StavkaOtpremnice i){
        StavkaOtpremniceDTO dto=new StavkaOtpremniceDTO();
        dto.setIznos(i.getIznos());
        dto.setJedinicnaCena(i.getCenaPoJedinici());
        dto.setKolicina(i.getKolicina());
        dto.setRedniBroj(i.getRb());
        if(i.getKNjiga()!=null){
        dto.setKnjigaID(i.getKNjiga().getId());
        if(i.getOtpremnica()!=null){
        dto.setOtpremnicaID(i.getOtpremnica().getOtpremnicaID());
        }
        }
        
    return dto;
    }
    public StavkaOtpremnice toEntity(StavkaOtpremniceDTO i){
        StavkaOtpremnice dto=new StavkaOtpremnice();
        dto.setIZnos(i.getIznos());
        dto.setCenaPoJedinici(i.getJedinicnaCena());
        dto.setKolicina(i.getKolicina());
        dto.setRb(i.getRedniBroj());
        if(i.getKnjigaID()!=null){
            Knjiga k=new Knjiga();
            k.setId(i.getKnjigaID());
        dto.setKnjiga(k);
        if(i.getOtpremnicaID()!=null){
            Otpremnica p=new Otpremnica();
            p.setOtpremnicaID(i.getOtpremnicaID());
        dto.setOtpremnica(p);
        }
        }
//      
     return dto;
    }
}
