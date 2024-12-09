package com.example.gestion_de_traiteur.Entités;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_utilisateur", discriminatorType = DiscriminatorType.STRING)

public abstract class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Column(unique = true)
    private String email;
    private String motDePasse;
    private String role;
}
