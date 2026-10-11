/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.service;

import com.bookathon.backend.entity.impl.User;
import com.bookathon.backend.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class UserService {
     @Autowired
    private UserRepository userRepository;

    public List<User> getAll() { return userRepository.findAll(); }
    public User getById(Long id) { return userRepository.findById(id).orElse(null); }
    public User findByUsername(String username) { return userRepository.findByUsername(username); }
    public User findByEmail(String email) { return userRepository.findByEmail(email); }
    public User findByToken(String token) { return userRepository.findByVerifikacioniToken(token); }
//    public User findByResetToken(String token) { return userRepository.findByResetLozinkeToken(token); }
    public User save(User k) { return userRepository.save(k); }
    public void delete(Long id) { userRepository.deleteById(id); }
}
