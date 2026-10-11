/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bookathon.backend.repository;

import com.bookathon.backend.entity.impl.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author user
 */
public interface UserRepository extends JpaRepository<User,Long> {
     User findByUsername(String username);
//    User findByVerifikacioniToken(String token);
//    User findByResetLozinkeToken(String token);
    User findByEmail(String email);

    public User findByVerifikacioniToken(String token);
}
