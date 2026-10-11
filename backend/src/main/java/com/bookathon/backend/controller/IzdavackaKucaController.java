/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.controller;

import com.bookathon.backend.dto.impl.IzdavackaKucaDTO;
import com.bookathon.backend.entity.impl.IzdavackaKuca;
import com.bookathon.backend.mapper.impl.IzdavackaKucaMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bookathon.backend.service.IzdavackaKucaService;
import java.util.stream.Collectors;
/**
 *
 * @author user
 */
@RestController
@RequestMapping("api/izdavacke-kuce")
@CrossOrigin(origins = "http://localhost:5173")
public class IzdavackaKucaController {
    @Autowired
    private IzdavackaKucaService service;
    private IzdavackaKucaMapper mapper=new IzdavackaKucaMapper();
    
    @GetMapping
    private List<IzdavackaKucaDTO> vratiSve(){
    return service.getAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }
}
