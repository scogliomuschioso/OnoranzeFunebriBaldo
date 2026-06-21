package com.baldosrl.tambuto.controller;


import com.baldosrl.tambuto.DTO.ResponseMessage;
import com.baldosrl.tambuto.DTO.UtenteDTO;
import com.baldosrl.tambuto.entities.User;
import com.baldosrl.tambuto.services.AccountService;
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
    public ResponseEntity registraUtente(@RequestBody UtenteDTO request) {
        try {
            User us = new User();
            us.setCognome(request.getCognome());
            us.setEmail(request.getEmail());
            us.setNome(request.getNome());
            us.setRuolo(request.getRuolo());
            us.setTelefono(request.getTelefono());
            us.setStoricoOrdini(request.getStoricoOrdini());
            accountService.aggiungiuser(us);
            return ResponseEntity.ok("registrazione eseguita con successo");
        } catch (EmailGiaPresenteException e){
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{userid}")
    public ResponseEntity trova(@PathVariable int userid){
        try {
            UtenteDTO dto = new UtenteDTO();
            accountService.trovauser(userid);
            return ResponseEntity.ok(dto);
        } catch (UtenteNonTrovatoException e){
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
