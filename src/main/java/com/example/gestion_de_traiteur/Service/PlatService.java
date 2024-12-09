package com.example.gestion_de_traiteur.Service;

import com.example.gestion_de_traiteur.DTO.PlatDTO;
import com.example.gestion_de_traiteur.Entités.Plat;
import com.example.gestion_de_traiteur.mapper.PlatMapper;
import com.example.gestion_de_traiteur.reposotories.PlatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatService {
    private final PlatRepository platRepository;
    private final PlatMapper platMapper;

    public PlatService(PlatRepository platRepository, PlatMapper platMapper) {
        this.platRepository = platRepository;
        this.platMapper = platMapper;
    }

    public List<PlatDTO> getAllPlats() {
        return platRepository.findAll()
                .stream()
                .map(platMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PlatDTO getPlatById(Long id) {
        Plat plat = platRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plat non trouvé avec l'ID : " + id));
        return platMapper.toDTO(plat);
    }

    public PlatDTO addPlat(PlatDTO platDTO) {
        Plat plat = platMapper.toEntity(platDTO);
        Plat savedPlat = platRepository.save(plat);
        return platMapper.toDTO(savedPlat);
    }

    public PlatDTO updatePlat(Long id, PlatDTO platDTO) {
        Plat plat = platRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plat non trouvé avec l'ID : " + id));
        plat.setNom(platDTO.getNom());
        plat.setDescription(platDTO.getDescription());
        plat.setPrix(platDTO.getPrix());
        Plat updatedPlat = platRepository.save(plat);
        return platMapper.toDTO(updatedPlat);
    }

    public void deletePlat(Long id) {
        Plat plat = platRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plat non trouvé avec l'ID : " + id));
        platRepository.delete(plat);
    }
}
