package com.example.gestion_de_traiteur.Service;
import com.example.gestion_de_traiteur.DTO.MenuDTO;
import com.example.gestion_de_traiteur.Entités.Menu;
import com.example.gestion_de_traiteur.mapper.MenuMapper;
import com.example.gestion_de_traiteur.reposotories.MenuRepository;
import com.example.gestion_de_traiteur.reposotories.PlatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MenuService {
    @Autowired
    PlatRepository platRepository ;
    private final MenuRepository menuRepository;
    private final MenuMapper menuMapper;

    public MenuService(MenuRepository menuRepository, MenuMapper menuMapper) {
        this.menuRepository = menuRepository;
        this.menuMapper = menuMapper;
    }

    public List<MenuDTO> getAllMenus() {
        return menuRepository.findAll().stream()
                .map(menuMapper::toDTO)  // Utiliser le mapper pour convertir Menu en MenuDTO
                .collect(Collectors.toList());
    }

    public MenuDTO getMenuById(Long id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu not found"));
        return menuMapper.toDTO(menu);  // Utiliser le mapper pour convertir Menu en MenuDTO
    }

    public MenuDTO addMenu(MenuDTO menuDTO) {
        Menu menu = menuMapper.toEntity(menuDTO);

        // Vérifiez les plats déjà existants pour éviter les doublons
        Set<Long> platsIdsSet = new HashSet<>(menuDTO.getPlatsIds());
        menu.setPlats(platsIdsSet.stream()
                .map(platId -> platRepository.findById(platId).orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList()));

        menuRepository.save(menu);
        return menuMapper.toDTO(menu);
    }

    public MenuDTO updateMenu(Long id, MenuDTO menuDTO) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu not found"));
        menu = menuMapper.toEntity(menuDTO);  // Utiliser le mapper pour mettre à jour le Menu
        menuRepository.save(menu);
        return menuMapper.toDTO(menu);  // Retourner MenuDTO
    }

    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }
}
