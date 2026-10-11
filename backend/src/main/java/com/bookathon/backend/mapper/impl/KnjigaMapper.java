/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.mapper.impl;

import com.bookathon.backend.dto.impl.KnjigaDTO;
import com.bookathon.backend.entity.impl.IzdavackaKuca;
import com.bookathon.backend.entity.impl.Knjiga;

/**
 *
 * @author user
 */
public class KnjigaMapper {
    public KnjigaDTO toDto(Knjiga i){
        KnjigaDTO dto=new KnjigaDTO();
        dto.setAutor(i.getAutor());
        dto.setCena(i.getCena());
        dto.setIzdavackaKucaID(i.getIzdavackaKuca().getIzdavackaKucaID());
        dto.setKnjigaID(i.getId());
        dto.setNaziv(i.getNaslov());
        dto.setOpis(i.getOpis());
        dto.setStanje(i.getStanje());
        dto.setSlika(i.getSlika());
        dto.setDatum(i.getGodinaIzdanja());
    return dto;
    }
    public Knjiga toEntity(KnjigaDTO i){
        Knjiga dto=new Knjiga();
       dto.setAutor(i.getAutor());
        dto.setCena(i.getCena());
        
        dto.setId(i.getKnjigaID());
        dto.setNaslov(i.getNaziv());
        dto.setOpis(i.getOpis());
        dto.setStanje(i.getStanje());
        if (i.getIzdavackaKucaID() != null) {
            IzdavackaKuca p = new IzdavackaKuca();
            p.setIzdavackaKucaID(i.getIzdavackaKucaID());
            dto.setIzdavackaKuca(p);
        }
         dto.setSlika(i.getSlika());
         dto.setGodinaIzdanja(i.getDatum());
     return dto;
    }
}
