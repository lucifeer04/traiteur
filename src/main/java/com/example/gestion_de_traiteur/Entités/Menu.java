package com.example.gestion_de_traiteur.Entités;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Menu extends Offre {
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Plat> plats;
}
