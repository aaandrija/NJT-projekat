/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.service;

import com.bookathon.backend.entity.impl.Knjiga;
import com.bookathon.backend.repository.KnjigaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class KnjigaService {
    @Autowired
    private KnjigaRepository knjigaRepository;
    
     public List<Knjiga> getAll() { return knjigaRepository.findAll(); }
    public Knjiga getById(Long id) { return knjigaRepository.findById(id).orElse(null); }
    public Knjiga save(Knjiga p) { return knjigaRepository.save(p); }
    public void delete(Long id) { knjigaRepository.deleteById(id); }

   
}
