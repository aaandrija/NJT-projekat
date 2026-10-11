/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bookathon.backend.repository;

import com.bookathon.backend.entity.impl.EmailZadatak;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author user
 */
public interface EmailZadatakRepository extends JpaRepository <EmailZadatak,String>{
        List<EmailZadatak> findByPoslatFalse();

}
