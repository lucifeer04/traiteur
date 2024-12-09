package com.example.gestion_de_traiteur.Entités;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("Administrateur ")

public class Administrateur extends Utilisateur {
    // Pas de champs supplémentaires pour le moment
}