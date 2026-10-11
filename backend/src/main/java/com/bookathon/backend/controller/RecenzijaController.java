/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.controller;

import com.bookathon.backend.dto.impl.KnjigaDTO;
import com.bookathon.backend.dto.impl.RecenzijaDTO;
import com.bookathon.backend.entity.impl.Knjiga;
import com.bookathon.backend.entity.impl.Recenzija;
import com.bookathon.backend.entity.impl.User;
import com.bookathon.backend.mapper.impl.KnjigaMapper;
import com.bookathon.backend.mapper.impl.RecenzijaMapper;
import com.bookathon.backend.service.KnjigaService;
import com.bookathon.backend.service.RecenzijaService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/api/recenzije")
@CrossOrigin(origins = "http://localhost:5173")
public class RecenzijaController {
     @Autowired
    private RecenzijaService recService;
    private RecenzijaMapper mapper = new RecenzijaMapper();
    
    @PostMapping("/prikazi")
    public List<RecenzijaDTO> getAll(@RequestBody Map<String, String> request) { 
      String id=request.get("id");
        System.out.println("NA backnedu primljen "+id);
        
        
        Long id_int=Long.parseLong(id);
        Knjiga k=new Knjiga();
        k.setId(id_int);
        
        
        return recService.getByKnjiga(k).stream().map(mapper::toDto).collect(Collectors.toList());
    }
       
     @PostMapping("/dodaj")
    public ResponseEntity<?> add(@RequestBody Map<String, String> request) { 
      String KnjigaId=request.get("knjigaID");
      String UserId=request.get("userID");
      String ocenaString=request.get("ocena");
      String poruka=request.get("poruka");
      
      Long kfk=Long.parseLong(KnjigaId);
      Long ufk=Long.parseLong(UserId);
      double ocena=Double.parseDouble(ocenaString);
      Knjiga knjiga=new Knjiga();
      knjiga.setId(kfk);
      User user=new User();
      user.setUserID(ufk);
         Recenzija recenzija=new Recenzija();
         recenzija.setKnjiga(knjiga);
         recenzija.setUser(user);
         recenzija.setOcena(ocena);
         recenzija.setPoruka(poruka);
         
         try{
         recService.save(recenzija);
           Map<String, String> response = new HashMap<>();
    response.put("poruka", "Uspešno ste dodali recenziju!");
    return ResponseEntity.ok(response);
         
         }
         catch(Exception e){
          Map<String, String> error = new HashMap<>();
        error.put("error", "Ne moze da se doda recenzija!");
        return ResponseEntity.status(400).body(error);
         }
      
    }
       
   
}
