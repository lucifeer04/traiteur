package com.example.gestion_de_traiteur.securite.controlleurauth;
import com.example.gestion_de_traiteur.DTO.AuthRequest;
import com.example.gestion_de_traiteur.DTO.AuthResponse;
import com.example.gestion_de_traiteur.DTO.ClientRegisterRequest;
import com.example.gestion_de_traiteur.Entités.Client;
import com.example.gestion_de_traiteur.reposotories.UtilisateurRepository;
import com.example.gestion_de_traiteur.securite.Token.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
        );

        String token = jwtUtil.generateToken(authRequest.getEmail(), authentication.getAuthorities().toString());
        return new AuthResponse(token);
    }

    @PostMapping("/client/register")
    public String registerClient(@RequestBody ClientRegisterRequest clientRegisterRequest) {
        System.out.println("Received request: " + clientRegisterRequest);

        if (utilisateurRepository.existsByEmail(clientRegisterRequest.getEmail())) {
            return "Un utilisateur avec cet email existe déjà.";
        }

        Client client = new Client();
        client.setNom(clientRegisterRequest.getNom());
        client.setEmail(clientRegisterRequest.getEmail());
        client.setMotDePasse(new BCryptPasswordEncoder().encode(clientRegisterRequest.getMotDePasse()));
        client.setAdresse(clientRegisterRequest.getAdresse());
        client.setTelephone(clientRegisterRequest.getTelephone());
        client.setRole("CLIENT");
        System.out.printf( client.getRole());
        utilisateurRepository.save(client);
        return "Client enregistré avec succès !";
    }
}
