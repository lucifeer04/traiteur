package com.example.gestion_de_traiteur.DTO;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
