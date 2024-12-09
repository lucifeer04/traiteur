package com.example.gestion_de_traiteur.Entités;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("CLIENT")
public class Client extends Utilisateur {
    private String adresse;
    private String telephone;
}