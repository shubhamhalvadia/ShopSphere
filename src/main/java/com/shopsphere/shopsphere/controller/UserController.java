package com.shopsphere.shopsphere.controller;

import com.shopsphere.shopsphere.dto.RegisterRequest;
import com.shopsphere.shopsphere.dto.LoginRequest;
import com.shopsphere.shopsphere.model.User;
import com.shopsphere.shopsphere.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        if (userRepo.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already in use.");
        }

        User user = new User(null, request.getEmail(), request.getPassword(), request.getRole());
        userRepo.save(user);

        return ResponseEntity.ok("User registered successfully.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Optional<User> userOpt = userRepo.findByEmail(request.getEmail());

        if (userOpt.isEmpty() || !userOpt.get().getPassword().equals(request.getPassword())) {
            return ResponseEntity.status(401).body("Invalid email or password.");
        }

        return ResponseEntity.ok("Login successful.");
    }
}