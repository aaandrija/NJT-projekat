/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.service;

import com.bookathon.backend.entity.impl.IzdavackaKuca;
import com.bookathon.backend.repository.IzdavackaKucaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class IzdavackaKucaService {
     @Autowired
    private IzdavackaKucaRepository izdavackaKucaRepository;
     public List<IzdavackaKuca> getAll() { return izdavackaKucaRepository.findAll(); }
}
