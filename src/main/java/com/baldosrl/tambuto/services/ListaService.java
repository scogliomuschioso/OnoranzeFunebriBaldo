package com.baldosrl.tambuto.services;

import com.baldosrl.tambuto.entities.Articolo;
import com.baldosrl.tambuto.entities.Carrello;
import com.baldosrl.tambuto.entities.Lista;
import com.baldosrl.tambuto.entities.User;
import com.baldosrl.tambuto.repositories.ArticoloRepo;
import com.baldosrl.tambuto.repositories.CarrelloRepo;
import com.baldosrl.tambuto.repositories.ListaRepo;
import com.baldosrl.tambuto.repositories.UserRepo;
import com.baldosrl.tambuto.supports.enumerations.Stato;
import com.baldosrl.tambuto.supports.exceptions.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ListaService {

    @Autowired
    private CarrelloRepo carrelloRepo;

    @Transactional
    public void compracarrello(User u) {
        Optional<Carrello> carrello = carrelloRepo.getCarrellosByUtenteAndStato(u,Stato.incarrello);
        if(!carrello.isPresent()) throw new CarrelloNonEsistenteException();
        Carrello carrelloutente = carrello.get();
        List<Lista>oggetti = carrelloutente.getLista();
                for (Lista l:oggetti){
                    Articolo art = l.getArticolo();
                    if (l.getQta()>art.getQuantita())
                        throw new NonAbbastanzaUnitaException();
                    else
                        art.setQuantita(art.getQuantita()-l.getQta());
                    carrelloutente.setStato(Stato.comprato);
                    carrelloutente.setDatadiacq(new Date());
        }

    }
}
