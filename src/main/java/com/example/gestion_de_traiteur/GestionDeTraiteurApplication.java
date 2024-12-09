package com.example.gestion_de_traiteur;

import com.example.gestion_de_traiteur.Entités.Administrateur;
import com.example.gestion_de_traiteur.reposotories.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class GestionDeTraiteurApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionDeTraiteurApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(UtilisateurRepository utilisateurRepository) {
		return args -> {
			if (!utilisateurRepository.existsByEmail("admin@example.com")) {
				Administrateur admin = new Administrateur();
				admin.setNom("Admin");
				admin.setEmail("admin@example.com");
				admin.setMotDePasse(new BCryptPasswordEncoder().encode("admin123"));
				admin.setRole("ADMIN");
				utilisateurRepository.save(admin);
			}
		};
	}


}
