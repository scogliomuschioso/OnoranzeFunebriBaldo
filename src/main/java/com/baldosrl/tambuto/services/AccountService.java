package com.baldosrl.tambuto.services;

import com.baldosrl.tambuto.DTO.Registrazione;
import com.baldosrl.tambuto.entities.User;
import com.baldosrl.tambuto.repositories.UserRepo;
import com.baldosrl.tambuto.supports.exceptions.EmailGiaPresenteException;
import com.baldosrl.tambuto.supports.exceptions.UtenteNonTrovatoException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private UserRepo userRepo;

    @Transactional
    public void aggiungiuser(Registrazione request){
    if (userRepo.existsByEmail(request.getEmail()))
        throw new EmailGiaPresenteException();
        Keycloak keycloak = KeycloakBuilder.builder()
                .serverUrl("http://localhost:8080")
                .realm("master").clientId("admin-cli").username("admin").password("admin").build();
        UserRepresentation userKeycloak = new UserRepresentation();
        userKeycloak.setEnabled(true);
        userKeycloak.setUsername(request.getNome());
        userKeycloak.setEmail(request.getEmail());
        userKeycloak.setFirstName(request.getNome());

        CredentialRepresentation passwordCred = new CredentialRepresentation();
        passwordCred.setTemporary(false);
        passwordCred.setType(CredentialRepresentation.PASSWORD);
        passwordCred.setValue(request.getPassword());
        userKeycloak.setCredentials(Collections.singletonList(passwordCred));
        Response response = keycloak.realm("myrealm").users().create(userKeycloak);
        if (response.getStatus() != 201) {
            throw new RuntimeException("Errore durante la creazione su Keycloak");
        }

        User user = new User();
        user.setNome(request.getNome());
        user.setTelefono(request.getTelefono());
        user.setCognome(request.getCognome());
        user.setEmail(request.getEmail());
        userRepo.save(user);
    }

    public User trovauser(int id){
        Optional<User> opt = userRepo.getUserById(id);
        if (opt.isPresent())
            return opt.get();
    throw new UtenteNonTrovatoException();
    }

    public User trovauseremail(String email){
        Optional<User> opt = userRepo.getUserByEmail(email);
        if (opt.isPresent())
            return opt.get();
        throw new UtenteNonTrovatoException();
    }

}
