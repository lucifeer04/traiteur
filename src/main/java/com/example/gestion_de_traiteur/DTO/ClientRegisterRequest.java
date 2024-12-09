package com.example.gestion_de_traiteur.DTO;

import lombok.Data;

@Data
public class ClientRegisterRequest {
    private String nom;
    private String email;
    private String motDePasse;
    private String adresse;
    private String telephone;
}
