package com.example.gestion_de_traiteur.mapper;

import com.example.gestion_de_traiteur.DTO.MenuDTO;
import com.example.gestion_de_traiteur.Entités.Menu;
import com.example.gestion_de_traiteur.Entités.Plat;
import com.example.gestion_de_traiteur.reposotories.PlatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MenuMapper {
    @Autowired
    PlatRepository platRepository;

    // Convertit Menu en MenuDTO
    public MenuDTO toDTO(Menu menu) {
        MenuDTO menuDTO = new MenuDTO();

        menuDTO.setNom(menu.getNom());
        menuDTO.setDescription(menu.getDescription());
        menuDTO.setPrix(menu.getPrix());
        menuDTO.setType(menu.getType());
        menuDTO.setDateDebut(menu.getDateDebut());
        menuDTO.setDateFin(menu.getDateFin());
        // Convertir la liste des plats en liste de PlatDTO
        List<Long> platsIds = menu.getPlats().stream()
                .map(Plat::getId)
                .collect(Collectors.toList());
        menuDTO.setPlatsIds(platsIds);
        return menuDTO;
    }

    // Convertit MenuDTO en Menu
    public Menu toEntity(MenuDTO menuDTO) {
        Menu menu = new Menu();
         // Important uniquement pour les mises à jour
        menu.setNom(menuDTO.getNom());
        menu.setDescription(menuDTO.getDescription());
        menu.setPrix(menuDTO.getPrix());
        menu.setDateDebut(menuDTO.getDateDebut());
        menu.setDateFin(menuDTO.getDateFin());
        menu.setType(menuDTO.getType());

        // Check if platsIds is not null and not empty before calling findAllById
        if (menuDTO.getPlatsIds() != null && !menuDTO.getPlatsIds().isEmpty()) {
            try {
                menu.setPlats(platRepository.findAllById(menuDTO.getPlatsIds())); // Si nécessaire
            } catch (DataIntegrityViolationException e) {
                // Handle the duplicate entry exception
                System.out.println("Duplicate entry detected: " + e.getMessage());
                // Optionally, you can log the error or take other actions
            }
        } else {
            menu.setPlats(Collections.emptyList()); // Set an empty list if platsIds is null or empty
        }

        return menu;
    }
}