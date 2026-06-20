package com.baldosrl.tambuto.controller;

import com.baldosrl.tambuto.DTO.AggiungiArticoloRequest;
import com.baldosrl.tambuto.DTO.CarrelloDTO;
import com.baldosrl.tambuto.DTO.ListaDTO;
import com.baldosrl.tambuto.DTO.ResponseMessage;
import com.baldosrl.tambuto.entities.Articolo;
import com.baldosrl.tambuto.entities.Carrello;
import com.baldosrl.tambuto.entities.Lista;
import com.baldosrl.tambuto.entities.User;
import com.baldosrl.tambuto.services.AccountService;
import com.baldosrl.tambuto.services.ArticoloService;
import com.baldosrl.tambuto.services.CarrelloService;
import com.baldosrl.tambuto.supports.exceptions.CarrelloChiusoException;
import com.baldosrl.tambuto.supports.exceptions.NonAbbastanzaUnitaException;
import com.baldosrl.tambuto.supports.exceptions.QuantitaMinoreDiZeroException;
import com.baldosrl.tambuto.supports.exceptions.UtenteNonTrovatoException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrello")
public class CarrelloController {

    @Autowired
private CarrelloService carrelloService;
    @Autowired
private AccountService accountService;
@Autowired
private ArticoloService articoloService;




    @PostMapping("/aggiungi")
    public ResponseEntity aggiungiArticolo(@RequestBody AggiungiArticoloRequest agg){
        try{
            User user = accountService.trovauser(agg.getIdutente());
            Lista salvato = carrelloService.aggiungialcarrello(user,agg.getQta(),agg.getIdarticolo());
            ListaDTO dto = new ListaDTO();
            dto.setArticolo(salvato.getArticolo());
            dto.setCarrello(salvato.getCarrello());
            dto.setId(salvato.getId());
            dto.setQta(salvato.getQta());
            return ResponseEntity.ok(dto);
        } catch (UtenteNonTrovatoException | QuantitaMinoreDiZeroException | NonAbbastanzaUnitaException |
                 CarrelloChiusoException e){
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{userid}")
    public ResponseEntity carrello(@PathVariable int userid){
        try {
            User user = accountService.trovauser(userid);
            Carrello carrello = carrelloService.getCarrelloAttivo(user);
            CarrelloDTO dto = new CarrelloDTO();
            dto.setDatadiacq(carrello.getDatadiacq());
            dto.setId(carrello.getId());
            dto.setStato(carrello.getStato());
            dto.setUtente(carrello.getUtente());
            dto.setTotale(carrello.getTotale());
            dto.setLista(carrello.getLista());
            return ResponseEntity.ok(dto);
        } catch (UtenteNonTrovatoException e){
            return new ResponseEntity<>(new ResponseMessage("UTENTE_NON_ESISTE"), HttpStatus.BAD_REQUEST);
        }
    }
}
