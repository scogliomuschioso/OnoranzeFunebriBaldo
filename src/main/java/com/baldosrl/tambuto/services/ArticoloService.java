package com.baldosrl.tambuto.services;

import com.baldosrl.tambuto.entities.Articolo;
import com.baldosrl.tambuto.repositories.ArticoloRepo;
import com.baldosrl.tambuto.supports.exceptions.ArticoloGiaPresenteException;
import com.baldosrl.tambuto.supports.exceptions.ArticoloNonEsistenteException;
import com.baldosrl.tambuto.supports.exceptions.QuantitaMinoreDiZeroException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticoloService {
    @Autowired
    private ArticoloRepo articoloRepo;

    public List<Articolo> tuttiarticoli(){
        return articoloRepo.findAll();
    }

    @Transactional
    public Articolo aggiungiArticolo(Articolo art) {
        boolean esisteGia = articoloRepo.existsByNomeAndTipoArticolo(art.getNome(), art.getTipoArticolo());
        if (esisteGia) {
            throw new ArticoloGiaPresenteException();
        }
        if(art.getQuantita() < 0) {
            art.setQuantita(0);
        }
        return articoloRepo.save(art);
    }

    @Transactional
    public void refillArticolo(int idArt, int qta){
        if (qta <= 0) {
            throw new QuantitaMinoreDiZeroException();
        }

        Articolo old = articoloRepo.findById(idArt)
                .orElseThrow(ArticoloNonEsistenteException::new);

        old.setQuantita(old.getQuantita() + qta);
    }

    public List<Articolo> ricercaavanzata(String nome,String tipo){
        return articoloRepo.advancedSearch(nome,tipo);
    }
}
