/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.controller;

import com.bookathon.backend.dto.impl.PorudzbinaDTO;
import com.bookathon.backend.entity.impl.Porudzbina;
import com.bookathon.backend.entity.impl.StavkaPorudzbine;
import com.bookathon.backend.entity.impl.User;
import com.bookathon.backend.mapper.impl.PorudzbinaMapper;
import com.bookathon.backend.mapper.impl.StavkaPorudzbineMapper;
import com.bookathon.backend.service.PorudzbinaService;
import com.bookathon.backend.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/api/porudzbine")
@CrossOrigin(origins = "*")
public class PorudzbinaController {
    @Autowired
    private UserService userService;
    @Autowired
    private PorudzbinaService porudzbinaService;
    private PorudzbinaMapper mapper=new PorudzbinaMapper();
    private StavkaPorudzbineMapper stavkeMapper=new StavkaPorudzbineMapper();
    @GetMapping
    public ResponseEntity<List<PorudzbinaDTO>> getAll() {
        List<Porudzbina> porudzbine = porudzbinaService.getAll();
    
    List<PorudzbinaDTO> dtos = porudzbine.stream()
            .map(mapper::toDto) 
            .collect(Collectors.toList());
    return ResponseEntity.ok(dtos);
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<Porudzbina> getById(@PathVariable Long id) {
        Porudzbina porudzbina = porudzbinaService.getById(id);
        if (porudzbina == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(porudzbina);
    }

    @PutMapping("/{id}/otkazi")
    public ResponseEntity<?> otkazi(@PathVariable Long id) {
        try {
            Porudzbina otkazana = porudzbinaService.otkazi(id);
            return ResponseEntity.ok(otkazana);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping
public ResponseEntity<?> create(@RequestBody PorudzbinaDTO dto) {
    try{
    Porudzbina porudzbina = mapper.toEntity(dto);
        User user=userService.getById(dto.getUserID());
        porudzbina.setKorisnik(user);
        List<StavkaPorudzbine> stavke = dto.getStavke().stream()
            .map(stavkeMapper::toEntity)
            .collect(Collectors.toList());
        
        Porudzbina sacuvana = porudzbinaService.saveWithStavke(porudzbina, stavke);
        return ResponseEntity.ok(mapper.toDto(sacuvana));}
    catch(RuntimeException e){
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}

    @GetMapping("/korisnik/{korisnikID}")
    public ResponseEntity<List<PorudzbinaDTO>> getByKorisnik(@PathVariable Long korisnikID){
        List<Porudzbina> porudzbine = porudzbinaService.getByUser(korisnikID);
        for(Porudzbina p:porudzbine){
            System.out.println(p.getPorudzbinaID());
        }
          List<PorudzbinaDTO> dtos = porudzbine.stream()
            .map(mapper::toDto) 
            .collect(Collectors.toList());
    return ResponseEntity.ok(dtos);      
    
    }
}
