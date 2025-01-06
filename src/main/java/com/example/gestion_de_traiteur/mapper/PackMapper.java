
package com.example.gestion_de_traiteur.mapper;

import com.example.gestion_de_traiteur.DTO.PackDTO;
import com.example.gestion_de_traiteur.Entités.Pack;
import org.springframework.stereotype.Component;

@Component
public class PackMapper {

    public PackDTO toDTO(Pack pack) {
        PackDTO packDTO = new PackDTO();
        packDTO.setNom(pack.getNom());
        packDTO.setDescription(pack.getDescription());
        packDTO.setPrix(pack.getPrix());
        packDTO.setType(pack.getType());
        packDTO.setDateDebut(pack.getDateDebut() != null ? pack.getDateDebut().toString() : null);
        packDTO.setDateFin(pack.getDateFin() != null ? pack.getDateFin().toString() : null);
        packDTO.setServicesInclus(pack.getServicesInclus());
        return packDTO;
    }

    public Pack toEntity(PackDTO packDTO) {
        Pack pack = new Pack();
        pack.setNom(packDTO.getNom());
        pack.setDescription(packDTO.getDescription());
        pack.setPrix(packDTO.getPrix());
        pack.setType(packDTO.getType());
        pack.setDateDebut(packDTO.getDateDebut() != null ? java.sql.Date.valueOf(packDTO.getDateDebut()) : null);
        pack.setDateFin(packDTO.getDateFin() != null ? java.sql.Date.valueOf(packDTO.getDateFin()) : null);
        pack.setServicesInclus(packDTO.getServicesInclus());
        return pack;
    }
}
