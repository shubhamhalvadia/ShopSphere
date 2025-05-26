package com.shopsphere.shopsphere.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}