package com.nsa.book_nsa.controller;

import com.nsa.book_nsa.model.User;
import com.nsa.book_nsa.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

@RestController
@RequestMapping("/api/v1")
public class AuthContoller {
    private final AuthService authService;
    public AuthContoller(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody User userDetails) {
        authService.register(userDetails);
        // Confirm Password
        String welcomeMessage = "Welcome to BOOK NSA";
        return ResponseEntity.status(201).body(welcomeMessage);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User userDetails) {
        return ResponseEntity.ok("Login successful");
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout() {
        return ResponseEntity.ok("Logout");
    }
}
