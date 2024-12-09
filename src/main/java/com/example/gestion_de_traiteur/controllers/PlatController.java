package com.example.gestion_de_traiteur.controllers;

import com.example.gestion_de_traiteur.DTO.PlatDTO;
import com.example.gestion_de_traiteur.Service.PlatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plats")
public class PlatController {
    private final PlatService platService;

    public PlatController(PlatService platService) {
        this.platService = platService;
    }

    @GetMapping
    public ResponseEntity<List<PlatDTO>> getAllPlats() {
        return ResponseEntity.ok(platService.getAllPlats());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlatDTO> getPlatById(@PathVariable Long id) {
        return ResponseEntity.ok(platService.getPlatById(id));
    }

    @PostMapping
    public ResponseEntity<PlatDTO> addPlat(@RequestBody PlatDTO platDTO) {
        return ResponseEntity.ok(platService.addPlat(platDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlatDTO> updatePlat(@PathVariable Long id, @RequestBody PlatDTO platDTO) {
        return ResponseEntity.ok(platService.updatePlat(id, platDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlat(@PathVariable Long id) {
        platService.deletePlat(id);
        return ResponseEntity.noContent().build();
    }
}
