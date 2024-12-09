package com.example.gestion_de_traiteur.reposotories;

import com.example.gestion_de_traiteur.Entités.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
