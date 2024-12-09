package com.example.gestion_de_traiteur.Service;

import com.example.gestion_de_traiteur.DTO.ReservationDTO;
import com.example.gestion_de_traiteur.Entités.Reservation;
import com.example.gestion_de_traiteur.mapper.ReservationMapper;
import com.example.gestion_de_traiteur.reposotories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    public ReservationService(ReservationRepository reservationRepository,
                              ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    public List<ReservationDTO> getAllReservations() {
        return reservationRepository.findAll()
                .stream()
                .map(reservationMapper::toReservationDTO) // Updated to use `toReservationDTO`
                .collect(Collectors.toList());
    }

    public ReservationDTO getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        return reservationMapper.toReservationDTO(reservation); // Updated to use `toReservationDTO`
    }

    public ReservationDTO addReservation(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        reservationMapper.toReservation(reservation, reservationDTO); // Updated to use `toReservation`
        reservation = reservationRepository.save(reservation);
        return reservationMapper.toReservationDTO(reservation); // Updated to use `toReservationDTO`
    }

    public ReservationDTO updateReservation(Long id, ReservationDTO reservationDTO) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        reservationMapper.toReservation(reservation, reservationDTO); // Updated to use `toReservation`
        reservation = reservationRepository.save(reservation);
        return reservationMapper.toReservationDTO(reservation); // Updated to use `toReservationDTO`
    }

    public void deleteReservation(Long id) {
        if (!reservationRepository.existsById(id)) {
            throw new RuntimeException("Reservation not found");
        }
        reservationRepository.deleteById(id);
    }
}
