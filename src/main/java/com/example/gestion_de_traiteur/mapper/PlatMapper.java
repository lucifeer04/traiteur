package com.example.gestion_de_traiteur.mapper;
import com.example.gestion_de_traiteur.DTO.PlatDTO;
import com.example.gestion_de_traiteur.Entités.Plat;
import org.springframework.stereotype.Component;

@Component
public class PlatMapper {

    public PlatDTO toDTO(Plat plat) {
        PlatDTO platDTO = new PlatDTO();
        platDTO.setId(plat.getId());
        platDTO.setNom(plat.getNom());
        platDTO.setDescription(plat.getDescription());
        platDTO.setPrix(plat.getPrix());
        return platDTO;
    }

    public Plat toEntity(PlatDTO platDTO) {
        Plat plat = new Plat();
        plat.setId(platDTO.getId()); // Important uniquement pour les mises à jour
        plat.setNom(platDTO.getNom());
        plat.setDescription(platDTO.getDescription());
        plat.setPrix(platDTO.getPrix());
        return plat;
    }
}
