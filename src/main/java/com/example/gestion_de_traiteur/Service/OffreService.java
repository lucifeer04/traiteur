package com.example.gestion_de_traiteur.Service;

import com.example.gestion_de_traiteur.Entités.Offre;
import com.example.gestion_de_traiteur.reposotories.OffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OffreService {
    @Autowired
    private OffreRepository offreRepository;

    // Créer une offre
    public Offre creerOffre(Offre offre) {
        return offreRepository.save(offre);
    }

    // Modifier une offre
    public Offre modifierOffre(Long id, Offre updatedOffre) {
        Offre offre = offreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Offre non trouvée."));
        offre.setNom(updatedOffre.getNom());
        offre.setDescription(updatedOffre.getDescription());
        offre.setPrix(updatedOffre.getPrix());
        offre.setType(updatedOffre.getType());
        offre.setDateDebut(updatedOffre.getDateDebut());
        offre.setDateFin(updatedOffre.getDateFin());
        return offreRepository.save(offre);
    }

    // Supprimer une offre
    public void supprimerOffre(Long id) {
        offreRepository.deleteById(id);
    }

    // Lister toutes les offres
    public List<Offre> listerOffres() {
        return offreRepository.findAll();
    }
}


