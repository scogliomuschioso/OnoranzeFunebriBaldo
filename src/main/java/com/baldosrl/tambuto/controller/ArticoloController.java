package com.baldosrl.tambuto.controller;

import com.baldosrl.tambuto.DTO.ArticoloDTO;
import com.baldosrl.tambuto.DTO.ConteinerDTO;
import com.baldosrl.tambuto.DTO.ResponseMessage;
import com.baldosrl.tambuto.entities.Articolo;
import com.baldosrl.tambuto.services.ArticoloService;
import com.baldosrl.tambuto.services.CarrelloService;
import com.baldosrl.tambuto.supports.exceptions.QuantitaMinoreDiZeroException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articoli")
public class ArticoloController {

    @Autowired
    private ArticoloService articoloService;

    @GetMapping("/tutti")
    public ResponseEntity articolidisp(){
        ConteinerDTO DTO = new ConteinerDTO();
        DTO.setArt(articoloService.tuttiarticoli());
        return ResponseEntity.ok(DTO);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity aggiungiarticolo(@RequestBody ArticoloDTO art){
        Articolo nuovo = new Articolo();
        nuovo.setQuantita(art.getQuantita());
        nuovo.setNome(art.getNome());
        nuovo.setLista(art.getLista());
        nuovo.setDescrizione(art.getDescrizione());
        nuovo.setTipoArticolo(art.getTipoArticolo());
        return ResponseEntity.status(HttpStatus.CREATED).body(articoloService.aggiungiArticolo(nuovo));
    }

    @GetMapping("/cerca")
    public ResponseEntity ricerca(@RequestParam(required = false) String nome, @RequestParam(required = false) String tipo){
       List<Articolo> liste= articoloService.ricercaavanzata(nome,tipo);
       ConteinerDTO dto = new ConteinerDTO();
       dto.setArt(liste);
    return    ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{idArt}/refill")
    public ResponseEntity refillArticolo(@PathVariable int idArt, @RequestParam int qta) {
        try {
            articoloService.refillArticolo(idArt, qta);
            return ResponseEntity.ok("Giacenza aggiornata con successo per l'articolo " + idArt);
        }catch (QuantitaMinoreDiZeroException e){
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }
}
