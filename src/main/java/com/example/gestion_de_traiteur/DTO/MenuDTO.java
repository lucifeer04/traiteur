package com.example.gestion_de_traiteur.DTO;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MenuDTO {
    private Long id;
    private String nom;
    private String description;
    private Double prix;
    private String type;
    private Date dateDebut;
    private Date dateFin;
    private List<Long> platsIds; // Liste des ID des plats associés
}
