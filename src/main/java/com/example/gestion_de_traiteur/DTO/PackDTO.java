package com.example.gestion_de_traiteur.DTO;

import lombok.Data;
import java.util.List;

@Data
public class PackDTO {
    private String nom;
    private String description;
    private Double prix;
    private String type;
    private String dateDebut;
    private String dateFin;
    private List<String> servicesInclus;
}
