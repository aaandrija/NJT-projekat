/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.controller;

import com.bookathon.backend.dto.impl.OtpremnicaDTO;
import com.bookathon.backend.entity.impl.Otpremnica;
import com.bookathon.backend.mapper.impl.OtpremnicaMapper;
import com.bookathon.backend.service.OtpremnicaService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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
@RequestMapping("/api/otpremnice")
@CrossOrigin(origins = "*")
public class OtpremnicaController {
    @Autowired
    private OtpremnicaService otpremnicaService;
    private OtpremnicaMapper mapper = new OtpremnicaMapper();

    @GetMapping
    public List<OtpremnicaDTO> getAll() {
        return otpremnicaService.getAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public OtpremnicaDTO getById(@PathVariable Long id) {
        return mapper.toDto(otpremnicaService.getById(id));
    }

    @PostMapping("/generisi")
    public ResponseEntity<?> generisi(@RequestBody OtpremnicaDTO zahtev) {
        List<OtpremnicaService.StavkaZahtev> stavke = zahtev.getStavke().stream().map(s -> {
            OtpremnicaService.StavkaZahtev sz = new OtpremnicaService.StavkaZahtev();
            System.out.println("ID knjige je: " + s.getKnjigaID());
            sz.knjigaId = s.getKnjigaID();
            sz.kolicina = s.getKolicina();
            return sz;
        }).collect(Collectors.toList());
        System.out.println("Id porudzbine je"+zahtev.getPorudzbinaID());
        Otpremnica otpremnica = otpremnicaService.generisiOtpremnicu(zahtev.getPorudzbinaID(), stavke);
        return ResponseEntity.ok(mapper.toDto(otpremnica));
    }
        @PutMapping("/{id}/storniraj")
public ResponseEntity<?> storniraj(@PathVariable Long id) {
    try {
        Otpremnica otpremnica = otpremnicaService.storniraj(id);
        return ResponseEntity.ok(mapper.toDto(otpremnica));
    } catch (RuntimeException e) {
        Map<String, String> error = new HashMap<>();
        error.put("greska", e.getMessage());
        return ResponseEntity.status(400).body(error);
    }
}
   
    
}
