/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.mapper.impl;

import com.bookathon.backend.dto.impl.OtpremnicaDTO;
import com.bookathon.backend.entity.impl.Otpremnica;
import com.bookathon.backend.entity.impl.Porudzbina;
import java.util.stream.Collectors;

/**
 *
 * @author user
 */
public class OtpremnicaMapper {
     private StavkaOtpremniceMapper spm=new StavkaOtpremniceMapper();

     public OtpremnicaDTO toDto(Otpremnica i){
        OtpremnicaDTO dto=new OtpremnicaDTO();
       
        dto.setDatum(i.getDatum());
        dto.setBrojOtpremnice(i.getBrojOtpremnice());
        dto.setIznos(i.getIznos());
        dto.setOtpremnicaID(i.getOtpremnicaID());
        dto.setStatusOtpremnice(i.getStatusOtpremnice());
        if(i.getPorudzbina()!=null){
        dto.setPorudzbinaID(i.getPorudzbina().getPorudzbinaID());
        }
         if (i.getStavke()!=null) {
            dto.setStavke(i.getStavke().stream().map(spm::toDto).collect(Collectors.toList()));
        }
        
        
    return dto;
    }
    public Otpremnica toEntity(OtpremnicaDTO i){
        Otpremnica dto=new Otpremnica();
          dto.setDatum(i.getDatum());
        dto.setBrojOtpremnice(i.getBrojOtpremnice());
        dto.setIznos(i.getIznos());
        dto.setOtpremnicaID(i.getOtpremnicaID());
        dto.setStatusOtpremnice(i.getStatusOtpremnice());
        if(i.getPorudzbinaID()!=null){
            Porudzbina p=new Porudzbina();
            p.setPorudzbinaID(i.getPorudzbinaID());
        dto.setPorudzbina(p);
        }
         if (i.getStavke()!=null) {
            dto.setStavke(i.getStavke().stream().map(spm::toEntity).collect(Collectors.toList()));
        }
        

     return dto;
    }
}
