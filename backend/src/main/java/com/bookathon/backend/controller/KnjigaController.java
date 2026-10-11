/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.controller;

import com.bookathon.backend.dto.impl.KnjigaDTO;
import com.bookathon.backend.mapper.impl.KnjigaMapper;
import com.bookathon.backend.service.KnjigaService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("api/knjige")
@CrossOrigin(origins = "http://localhost:5173")
public class KnjigaController {
     @Autowired
    private KnjigaService knjigaService;
    private KnjigaMapper mapper = new KnjigaMapper();
    
    
      @GetMapping
    public List<KnjigaDTO> getAll() {
        return knjigaService.getAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<KnjigaDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDto(knjigaService.getById(id)));
    }

    @PostMapping
    public ResponseEntity<KnjigaDTO> save(@RequestBody KnjigaDTO dto) {
        return ResponseEntity.ok(mapper.toDto(knjigaService.save(mapper.toEntity(dto))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<KnjigaDTO> update(@PathVariable Long id, @RequestBody KnjigaDTO dto) {
        return ResponseEntity.ok(mapper.toDto(knjigaService.save( mapper.toEntity(dto))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        knjigaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
