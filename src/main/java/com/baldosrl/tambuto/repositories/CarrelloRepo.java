package com.baldosrl.tambuto.repositories;


import com.baldosrl.tambuto.entities.Articolo;
import com.baldosrl.tambuto.entities.Carrello;
import com.baldosrl.tambuto.entities.User;
import com.baldosrl.tambuto.supports.enumerations.Stato;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CarrelloRepo extends JpaRepository<Carrello,Integer> {

    public Optional<Carrello> getCarrellosByUtenteAndStato(User u, Stato s);

    @Query("SELECT l.articolo FROM Lista l " +
            "JOIN l.carrello c " +
            "WHERE c.datadiacq >= :data " +
            "AND c.stato = :stato " +
            "AND c.user = :utente")
    List<Articolo> findArticoliAcquistatiDopoDi(@Param("stato") Stato s, @Param("data") Date d, @Param("utente") User u);

    @Query("SELECT l.articolo FROM Lista l " +
            "JOIN l.carrello c " +
            "WHERE c.datadiacq <= :data " +
            "AND c.stato = :stato " +
            "AND c.user = :utente")
    List<Articolo> findArticoliAcquistatiPrimaDi(@Param("stato") Stato s, @Param("data") Date d, @Param("utente") User u);
}
