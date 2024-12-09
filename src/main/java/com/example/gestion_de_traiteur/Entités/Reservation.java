package com.example.gestion_de_traiteur.Entités;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Entity
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateReservation;
    private Date dateEvenement;
    private String heureEvenement;
    private int nombrePersonnes;
    private String adresseEvenement;
    private String statut;

    @ManyToOne
    private Client client;

    @OneToOne
    @JoinColumn(name = "offre_id") // Clé étrangère dans la table Reservation
    private Offre offre;
}
