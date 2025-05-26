package com.shopsphere.shopsphere.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String password;
    private String role; // Optional: "USER" or "ADMIN"
}