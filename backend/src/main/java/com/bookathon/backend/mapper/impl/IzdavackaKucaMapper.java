/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.mapper.impl;

import com.bookathon.backend.dto.impl.IzdavackaKucaDTO;
import com.bookathon.backend.entity.impl.IzdavackaKuca;

/**
 *
 * @author user
 */
public class IzdavackaKucaMapper {
    public IzdavackaKucaDTO toDto(IzdavackaKuca i){
        IzdavackaKucaDTO dto=new IzdavackaKucaDTO();
        dto.setAdresa(i.getAdresa());
        dto.setIzdavackaKucaID(i.getIzdavackaKucaID());
        dto.setNaziv(i.getNaziv());
        
    return dto;
    }
    public IzdavackaKuca toEntity(IzdavackaKucaDTO i){
        IzdavackaKuca dto=new IzdavackaKuca();
        dto.setAdresa(i.getAdresa());
        dto.setIzdavackaKucaID(i.getIzdavackaKucaID());
        dto.setNaziv(i.getNaziv());
        
     return dto;
    }
    
}
