package com.baldosrl.tambuto.controller;


import com.baldosrl.tambuto.DTO.Registrazione;
import com.baldosrl.tambuto.DTO.ResponseMessage;
import com.baldosrl.tambuto.DTO.UtenteDTO;
import com.baldosrl.tambuto.entities.User;
import com.baldosrl.tambuto.services.AccountService;
import com.baldosrl.tambuto.supports.authentication.Utils;
import com.baldosrl.tambuto.supports.exceptions.EmailGiaPresenteException;
import com.baldosrl.tambuto.supports.exceptions.UtenteNonTrovatoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/utente")
public class UserController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/registrazione")
    public ResponseEntity registraUtente(@RequestBody Registrazione request) {
        try {
            accountService.aggiungiuser(request);
            return ResponseEntity.ok("registrazione eseguita con successo");
        } catch (EmailGiaPresenteException e){
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity trova(){
        try {
            String email =Utils.getEmail();
            User user= accountService.trovauseremail(email);
            UtenteDTO dto = new UtenteDTO();
            dto.setId(user.getId());
            dto.setCognome(user.getCognome());
            dto.setEmail(user.getEmail());
            dto.setNome(user.getNome());
            dto.setTelefono(user.getTelefono());
            dto.setStoricoOrdini(user.getStoricoOrdini());
            return ResponseEntity.ok(dto);
        } catch (UtenteNonTrovatoException e){
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
