package com.example.gestion_de_traiteur.Controllers;

import com.example.gestion_de_traiteur.DTO.PackDTO;

import com.example.gestion_de_traiteur.Service.PackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packs")
public class PackController {

    @Autowired
    private  PackService packService;



    @GetMapping
    public ResponseEntity<List<PackDTO>> getAllPacks() {
        return ResponseEntity.ok(packService.getAllPacks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PackDTO> getPackById(@PathVariable Long id) {
        return ResponseEntity.ok(packService.getPackById(id));
    }

    @PostMapping
    public ResponseEntity<PackDTO> createPack(@RequestBody PackDTO packDTO) {
        return ResponseEntity.ok(packService.createPack(packDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PackDTO> updatePack(@PathVariable Long id, @RequestBody PackDTO packDTO) {
        return ResponseEntity.ok(packService.updatePack(id, packDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePack(@PathVariable Long id) {
        packService.deletePack(id);
        return ResponseEntity.noContent().build();
    }
}
