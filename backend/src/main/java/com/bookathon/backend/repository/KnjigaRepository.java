/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bookathon.backend.repository;

import com.bookathon.backend.entity.impl.Knjiga;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author user
 */
public interface KnjigaRepository extends JpaRepository <Knjiga,Long>{

    
}
