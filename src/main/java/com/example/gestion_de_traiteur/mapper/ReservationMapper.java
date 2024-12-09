package com.example.gestion_de_traiteur.mapper;


import com.example.gestion_de_traiteur.DTO.ReservationDTO;
import com.example.gestion_de_traiteur.Entités.Client;
import com.example.gestion_de_traiteur.Entités.Offre;
import com.example.gestion_de_traiteur.Entités.Reservation;
import com.example.gestion_de_traiteur.reposotories.ClientRepository;
import com.example.gestion_de_traiteur.reposotories.OffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OffreRepository offreRepository;

    // Mapper DTO vers Entité
    public void toReservation(Reservation reservation, ReservationDTO dto) {
        if (dto != null) {
            reservation.setDateReservation(dto.getDateReservation());
            reservation.setDateEvenement(dto.getDateEvenement());
            reservation.setHeureEvenement(dto.getHeureEvenement());
            reservation.setNombrePersonnes(dto.getNombrePersonnes());
            reservation.setAdresseEvenement(dto.getAdresseEvenement());
            reservation.setStatut(dto.getStatut());

            // Récupération du Client
            Client client = clientRepository.findById(dto.getClientId()).orElse(null);
            reservation.setClient(client);

            // Récupération de l'Offre
            Offre offre = offreRepository.findById(dto.getOffreId()).orElse(null);
            reservation.setOffre(offre);
        }
    }

    // Mapper Entité vers DTO
    public ReservationDTO toReservationDTO(Reservation reservation) {
        if (reservation == null) {
            return null;
        }

        ReservationDTO dto = new ReservationDTO();
        dto.setId(reservation.getId());
        dto.setDateReservation(reservation.getDateReservation());
        dto.setDateEvenement(reservation.getDateEvenement());
        dto.setHeureEvenement(reservation.getHeureEvenement());
        dto.setNombrePersonnes(reservation.getNombrePersonnes());
        dto.setAdresseEvenement(reservation.getAdresseEvenement());
        dto.setStatut(reservation.getStatut());

        // Ajout des IDs pour les relations
        if (reservation.getClient() != null) {
            dto.setClientId(reservation.getClient().getId());
        }
        if (reservation.getOffre() != null) {
            dto.setOffreId(reservation.getOffre().getId());
        }

        return dto;
    }
}
