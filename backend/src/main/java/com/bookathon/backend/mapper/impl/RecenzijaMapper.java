/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.mapper.impl;

import com.bookathon.backend.dto.impl.RecenzijaDTO;
import com.bookathon.backend.entity.impl.Knjiga;
import com.bookathon.backend.entity.impl.Recenzija;
import com.bookathon.backend.entity.impl.User;

/**
 *
 * @author user
 */
public class RecenzijaMapper {
     public RecenzijaDTO toDto(Recenzija i){
        RecenzijaDTO dto=new RecenzijaDTO();
       dto.setRecenzijaId(i.getRecenzijaId());
       dto.setOcena(i.getOcena());
       dto.setPoruka(i.getPoruka());
       dto.setKnjigaID(i.getKnjiga().getId());
       dto.setUserID(i.getUser().getUserID());
        dto.setKorsinik(i.getUser().getIme()+" "+i.getUser().getPrezime());
        
    return dto;
    }
    public Recenzija toEntity(RecenzijaDTO i){
        Recenzija dto=new Recenzija();
          dto.setRecenzijaId(i.getRecenzijaId());
       dto.setOcena(i.getOcena());
       dto.setPoruka(i.getPoruka());
        if(i.getKnjigaID()!=null){
            Knjiga k=new Knjiga();
            k.setId(i.getKnjigaID());
        dto.setKnjiga(k);
        }
         if(i.getUserID()!=null){
             User k=new User();
            k.setUserID(i.getUserID());
        dto.setUser(k);
        }
        

     return dto;
    }
}
