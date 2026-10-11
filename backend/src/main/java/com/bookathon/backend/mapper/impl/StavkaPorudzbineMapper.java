/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.mapper.impl;
import com.bookathon.backend.dto.impl.StavkaPorudzbineDTO;
import com.bookathon.backend.entity.impl.Knjiga;
import com.bookathon.backend.entity.impl.Porudzbina;
import com.bookathon.backend.entity.impl.StavkaPorudzbine;

/**
 *
 * @author user
 */
public class StavkaPorudzbineMapper {
    public StavkaPorudzbineDTO toDto(StavkaPorudzbine i){
        StavkaPorudzbineDTO dto=new StavkaPorudzbineDTO();
        dto.setIznos(i.getIznos());
        dto.setJedinicnaCena(i.getCenaPoJedinici());
        dto.setKolicina(i.getKolicina());
        dto.setRedniBroj(i.getRb());
        if(i.getKNjiga()!=null){
        dto.setKnjigaID(i.getKNjiga().getId());
        if(i.getPorudzbina()!=null){
        dto.setPorudzbinaID(i.getPorudzbina().getPorudzbinaID());
        }
        dto.setNazivKnjige(i.getKNjiga().getNaslov());
        }
        
    return dto;
    }
    public StavkaPorudzbine toEntity(StavkaPorudzbineDTO i){
        StavkaPorudzbine dto=new StavkaPorudzbine();
        dto.setIZnos(i.getIznos());
        dto.setCenaPoJedinici(i.getJedinicnaCena());
        dto.setKolicina(i.getKolicina());
        dto.setRb(i.getRedniBroj());
        if(i.getKnjigaID()!=null){
            Knjiga k=new Knjiga();
            k.setId(i.getKnjigaID());
        dto.setKnjiga(k);
        if(i.getPorudzbinaID()!=null){
            Porudzbina p=new Porudzbina();
            p.setPorudzbinaID(i.getPorudzbinaID());
        dto.setPorudzbina(p);
        }
        }
//      
     return dto;
    }
}
