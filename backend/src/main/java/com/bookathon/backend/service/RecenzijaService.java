/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.service;

import com.bookathon.backend.entity.impl.Knjiga;
import com.bookathon.backend.entity.impl.Recenzija;
import com.bookathon.backend.repository.RecenzijaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class RecenzijaService {
    @Autowired
    private RecenzijaRepository recenzijaRepository;
    
    public List<Recenzija> getAll() { return recenzijaRepository.findAll(); }

    public Recenzija getById(Long id) { return recenzijaRepository.findById(id).orElse(null); }
    public Recenzija save(Recenzija p) { return recenzijaRepository.save(p); }
    public void delete(Long id) { recenzijaRepository.deleteById(id); }
    public List<Recenzija> getByKnjiga(Knjiga id) { return (List<Recenzija>) recenzijaRepository.findByKnjiga(id); }
    
}
