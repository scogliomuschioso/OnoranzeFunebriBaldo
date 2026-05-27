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

import java.util.List;
import java.util.Optional;

@Service
public class CarrelloService {

    @Autowired
    private ListaRepo listarepo;

    @Autowired
    private ArticoloRepo articoloRepo;

@Autowired
private CarrelloRepo carrelloRepo;

@Autowired
private UserRepo userRepo;

public float getTotale(User u){
    if (!userRepo.existsById(u.getId())) throw new UtenteNonTrovatoException();
    return getCarrelloAttivo(u).getTotale();
        }

    public Carrello getCarrelloAttivo(User u){
        Optional<Carrello> carrello =carrelloRepo.getCarrellosByUtenteAndStato(u,Stato.incarrello);
        if (carrello.isPresent()){
            return carrello.get();
        }
        Carrello carellonuovo= new Carrello();
        carellonuovo.setUtente(u);
        carellonuovo.setStato(Stato.incarrello);
        return carrelloRepo.save(carellonuovo);
    }

    @Transactional
    public Lista aggiungialcarrello(User u,int qta,int idart){
        if (qta<=0)
            throw new QuantitaMinoreDiZeroException();
        Articolo art = articoloRepo.findById(idart)
                .orElseThrow(ArticoloNonEsistenteException::new);

        if (qta>art.getQuantita()) throw new NonAbbastanzaUnitaException();
        Carrello carrello = getCarrelloAttivo(u);
        //verificare che il carrello esista e che non sia già stato pagato
        if (carrello.getStato() != Stato.incarrello) {
            throw new CarrelloChiusoException();
        }
        //verifico che l'articolo ci sia già nel carrello
        Optional<Lista> doppione =listarepo.findByArticoloAndCarrello(art,carrello);
        //effettivamnete c'è un doppione
        Lista rigaDaSalvare;
        if (doppione.isPresent()){
            rigaDaSalvare = doppione.get();
            int tot = rigaDaSalvare.getQta()+qta;
            if (tot>art.getQuantita()) throw new NonAbbastanzaUnitaException();
            rigaDaSalvare.setQta(tot);
        }
        else {
            rigaDaSalvare = new Lista();
            rigaDaSalvare.setCarrello(carrello);
            rigaDaSalvare.setArticolo(art);
            rigaDaSalvare.setQta(qta);
        }
        //quindi in caso fa la insert se non c'è niente, altrimenti fa la update
        return  listarepo.save(rigaDaSalvare);
    }

    //siccome fa un azione di lettura non inserisco transactional
    public List<Lista> carrello(User u){
        if (userRepo.existsById(u.getId())){
            return listarepo.findByCarrelloStatoAndCarrelloUtente(Stato.incarrello,u);
        } else
            throw new UtenteNonTrovatoException();
    }

}
