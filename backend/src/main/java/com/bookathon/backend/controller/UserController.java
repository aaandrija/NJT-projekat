/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookathon.backend.controller;

import com.bookathon.backend.JwtUtil;
import com.bookathon.backend.entity.enums.Uloga;
import com.bookathon.backend.entity.impl.User;
import com.bookathon.backend.service.EmailService;
import com.bookathon.backend.service.UserService;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
       @Autowired
    private UserService userService;
       @Autowired
       private EmailService emailService;
    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        User user = userService.findByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Pogresno korisnicko ime ili lozinka!");
            return ResponseEntity.status(401).body(error);
        }
        String token = jwtUtil.generateToken(username, user.getUloga().toString());
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("korisnikID", user.getUserID());
        response.put("username", user.getUsername());
        response.put("ime", user.getIme());
        response.put("prezime", user.getPrezime());
        response.put("uloga", user.getUloga());
        response.put("adresa", user.getAdresa());
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/register")
public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
    String username = request.get("username");
    String password = request.get("password");
    String email = request.get("email");
    String ime = request.get("ime");
    String prezime = request.get("prezime");
    String adresa = request.get("adresa");

    if (username == null || username.trim().isEmpty() ||
        password == null || password.trim().isEmpty() ||
        email == null || email.trim().isEmpty()) {
        
        Map<String, String> error = new HashMap<>();
        error.put("error", "Username, password i email su obavezna polja!");
        return ResponseEntity.status(400).body(error);
    }

    if (userService.findByUsername(username) != null) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "Korisničko ime je već zauzeto!");
        return ResponseEntity.status(400).body(error);
    }

    User novUser = new User();
    novUser.setUsername(username);
    novUser.setPassword(password);
    novUser.setEmail(email);
    novUser.setIme(ime);
    novUser.setPrezime(prezime);
    novUser.setAdresa(adresa);
    
    novUser.setUloga(Uloga.KUPAC); 

    userService.save(novUser);

    Map<String, String> response = new HashMap<>();
    response.put("poruka", "Uspešno ste se registrovali!");
    return ResponseEntity.ok(response);
}
    @PostMapping("/posalji-verifikaciju")
    public ResponseEntity<?> posaljiVerifikaciju(@RequestBody Map<String, String> request) {
        String email = request.get("email");

        if (userService.findByEmail(email) != null) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Ovaj email je vec registrovan!");
            return ResponseEntity.status(400).body(error);
        }

        String token = UUID.randomUUID().toString();
//
        User privremeni = new User();
        privremeni.setEmail(email);
        privremeni.setVerifikacioniToken(token);
        privremeni.setEmailPotvrdjen(false);
        privremeni.setUloga(Uloga.KUPAC);
        userService.save(privremeni);

        emailService.posaljiVerifikacioniEmail(email, token);

        Map<String, String> response = new HashMap<>();
        response.put("poruka", "Verifikacioni link je poslat na vaš email. Proverite inbox.");
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/verifikuj/{token}")
    public ResponseEntity<?> verifikuj(@PathVariable String token) {
        User korisnik = userService.findByToken(token);
        if (korisnik == null) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Nevažeći verifikacioni link.");
            return ResponseEntity.status(400).body(error);
        }
        korisnik.setEmailPotvrdjen(true);
        userService.save(korisnik);

        Map<String, String> response = new HashMap<>();
        response.put("poruka", "Email je potvrđen! Dovršite registraciju.");
        response.put("email", korisnik.getEmail());
        return ResponseEntity.ok(response);
    }
    
        @PostMapping("/dovrsi-registraciju")
    public ResponseEntity<?> dovrsiRegistraciju(@RequestBody Map<String, String> request) {
        String token = request.get("token");
        User korisnik = userService.findByToken(token);

        if (korisnik == null || !Boolean.TRUE.equals(korisnik.getEmailPotvrdjen())) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Email nije potvrđen. Ne možete dovršiti registraciju.");
            return ResponseEntity.status(400).body(error);
        }

        String username = request.get("username");
        String password = request.get("password");
        String ime = request.get("ime");
        String prezime = request.get("prezime");
        String adresa = request.get("adresa");

        if (username == null || username.trim().length() < 3) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Korisničko ime mora imati bar 3 karaktera!");
            return ResponseEntity.status(400).body(error);
        }
        if (password == null || password.length() < 6) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Lozinka mora imati bar 6 karaktera!");
            return ResponseEntity.status(400).body(error);
        }
        if (ime == null || ime.trim().length() < 2) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Ime mora imati bar 2 karaktera!");
            return ResponseEntity.status(400).body(error);
        }
        if (prezime == null || prezime.trim().length() < 2) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Prezime mora imati bar 2 karaktera!");
            return ResponseEntity.status(400).body(error);
        }
        if (adresa == null || adresa.trim().length() < 3) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Adresa mora imati bar 3 karaktera!");
            return ResponseEntity.status(400).body(error);
        }

        if (userService.findByUsername(username) != null) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Korisničko ime već postoji!");
            return ResponseEntity.status(400).body(error);
        }

        korisnik.setUsername(username);
        korisnik.setPassword(password);
        korisnik.setIme(ime);
        korisnik.setPrezime(prezime);
        korisnik.setAdresa(adresa);
        userService.save(korisnik);

        Map<String, String> response = new HashMap<>();
        response.put("poruka", "Registracija uspešno završena! Prijavite se.");
        return ResponseEntity.ok(response);
    }
}
