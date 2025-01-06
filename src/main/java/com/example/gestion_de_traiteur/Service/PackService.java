package com.example.gestion_de_traiteur.Service;
import com.example.gestion_de_traiteur.DTO.PackDTO;
import com.example.gestion_de_traiteur.Entités.Pack;
import com.example.gestion_de_traiteur.mapper.PackMapper;
import com.example.gestion_de_traiteur.reposotories.PackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PackService {
    @Autowired
    private  PackRepository packRepository;
    @Autowired
    private  PackMapper packMapper;


    public List<PackDTO> getAllPacks() {
        return packRepository.findAll().stream()
                .map(packMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PackDTO getPackById(Long id) {
        Pack pack = packRepository.findById(id).orElseThrow(() -> new RuntimeException("Pack not found"));
        return packMapper.toDTO(pack);
    }

    public PackDTO createPack(PackDTO packDTO) {
        Pack pack = packMapper.toEntity(packDTO);
        Pack savedPack = packRepository.save(pack);
        return packMapper.toDTO(savedPack);
    }

    public PackDTO updatePack(Long id, PackDTO packDTO) {
        Pack existingPack = packRepository.findById(id).orElseThrow(() -> new RuntimeException("Pack not found"));
        existingPack = packMapper.toEntity(packDTO);

        Pack updatedPack = packRepository.save(existingPack);
        return packMapper.toDTO(updatedPack);
    }

    public void deletePack(Long id) {
        Pack pack = packRepository.findById(id).orElseThrow(() -> new RuntimeException("Pack not found"));
        packRepository.delete(pack);
    }
}
