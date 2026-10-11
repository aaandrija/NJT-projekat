/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bookathon.backend.repository;

import com.bookathon.backend.entity.impl.Porudzbina;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author user
 */
public interface PorudzbinaRepository extends JpaRepository <Porudzbina,Long>{
    @Query("SELECT p from Porudzbina p WHERE p.user.UserID = :userID")
    public List<Porudzbina> findByUser_UserID(@Param("userID")Long korisnikId);
    
}
