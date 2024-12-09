package com.example.gestion_de_traiteur.Entités;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Pack extends Offre {
    @ElementCollection
    private List<String> servicesInclus;
}
