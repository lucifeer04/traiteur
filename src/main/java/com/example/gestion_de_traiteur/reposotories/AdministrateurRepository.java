package com.example.gestion_de_traiteur.reposotories;

import com.example.gestion_de_traiteur.Entités.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministrateurRepository extends JpaRepository<Administrateur, Long> {
    Optional<Administrateur> findByEmail(String email);
}