package com.baldosrl.tambuto.repositories;

import com.baldosrl.tambuto.entities.Articolo;
import com.baldosrl.tambuto.entities.Carrello;
import com.baldosrl.tambuto.entities.Lista;
import com.baldosrl.tambuto.entities.User;
import com.baldosrl.tambuto.supports.enumerations.Stato;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ListaRepo extends JpaRepository<Lista,Integer> {



    List<Lista> findByCarrelloStatoAndCarrelloUtente(Stato stato, User utente);
    Optional<Lista> findByArticoloAndCarrello(Articolo articolo, Carrello car);
}
