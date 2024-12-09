package com.example.gestion_de_traiteur.DTO;

import lombok.Data;

@Data
public class PlatDTO {
    private Long id; // Peut être omis pour la création
    private String nom;
    private String description;
    private Double prix;
}
