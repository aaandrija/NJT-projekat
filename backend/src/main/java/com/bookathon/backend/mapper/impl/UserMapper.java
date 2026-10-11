/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.mapper.impl;

import com.bookathon.backend.dto.impl.UserDTO;
import com.bookathon.backend.entity.impl.User;

/**
 *
 * @author user
 */
public class UserMapper {
    
     public UserDTO toDto(User e) {
        UserDTO dto = new UserDTO();
        dto.setUserID(e.getUserID());
        dto.setAdresa(e.getAdresa());
        dto.setEmail(e.getEmail());
        dto.setIme(e.getIme());
        dto.setPrezime(e.getPrezime());
        dto.setPassword(e.getPassword());
        dto.setUloga(e.getUloga());
        
   
        return dto;
    }

    public User toEntity(UserDTO e) {
        User dto = new User();
       dto.setUserID(e.getUserID());
        dto.setAdresa(e.getAdresa());
        dto.setEmail(e.getEmail());
        dto.setIme(e.getIme());
        dto.setPrezime(e.getPrezime());
        dto.setPassword(e.getPassword());
        dto.setUloga(e.getUloga());
        return dto;
    }
    
}
