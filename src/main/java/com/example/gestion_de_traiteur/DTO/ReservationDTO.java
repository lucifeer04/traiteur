package com.example.gestion_de_traiteur.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReservationDTO {
    private Long id;
    private Date dateReservation;
    private Date dateEvenement;
    private String heureEvenement;
    private int nombrePersonnes;
    private String adresseEvenement;
    private String statut;

    private Long clientId;
    private Long offreId;
}
