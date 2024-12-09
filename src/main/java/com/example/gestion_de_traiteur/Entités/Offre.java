package com.example.gestion_de_traiteur.Entités;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private Double prix;
    private String type;
    private Date dateDebut;
    private Date dateFin;

    @OneToOne(mappedBy = "offre")
    private Reservation reservation;
}
