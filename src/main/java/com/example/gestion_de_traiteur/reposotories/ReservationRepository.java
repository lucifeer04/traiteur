package com.example.gestion_de_traiteur.reposotories;

import com.example.gestion_de_traiteur.Entités.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}