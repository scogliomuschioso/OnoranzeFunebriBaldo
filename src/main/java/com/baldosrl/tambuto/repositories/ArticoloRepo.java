package com.baldosrl.tambuto.repositories;

import com.baldosrl.tambuto.entities.Articolo;
import com.baldosrl.tambuto.supports.Stato;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/*ogni entità ha una sua repo, essa implementa il pattern dao, questo permette di evitare
* l'accesso diretto con l'entità usando invece un sostituto che fa da proxy perchè è lui che
* si dedica anche alla parte logica, quindi l'utente non interagisce con l'entità grezza*/
@Repository
public interface ArticoloRepo extends JpaRepository<Articolo,Integer> {
    /*l'idea è di usarlo per creare la sezione cronologia e anche per il carrello stesso*/
    List<Articolo> findByStatoEquals(Stato stato);

    @Query("SELECT a " +
            "FROM Articolo a " +
            "WHERE (a.nome LIKE ?1 OR ?1 IS NULL) AND " +
            "      (a.tipoarticolo LIKE ?2 OR ?2 IS NULL)")
    List<Articolo> advancedSearch(String nome, String tipo);

    @Query("SELECT l.articolo"+
            "FROM Lista l" +
            "WHERE l.datadiacq<=?2 AND l.articolo.stato = ?1")
    List<Articolo> acquistoprimadi(Stato s, Date d);

    @Query("SELECT l.articolo"+
            "FROM Lista l" +
            "WHERE l.datadiacq>=?2 AND l.articolo.stato = ?1")
    List<Articolo> acquistodopodel(Stato s, Date d);
}
