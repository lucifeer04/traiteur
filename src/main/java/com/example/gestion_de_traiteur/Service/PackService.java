package com.example.gestion_de_traiteur.Service;

import com.example.gestion_de_traiteur.Entités.Pack;
import com.example.gestion_de_traiteur.reposotories.PackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackService {
    @Autowired
    private PackRepository packRepository;

    // Ajouter un pack
    public Pack ajouterPack(Pack pack) {
        return packRepository.save(pack);
    }

    // Lister tous les packs
    public List<Pack> listerPacks() {
        return packRepository.findAll();
    }
}

