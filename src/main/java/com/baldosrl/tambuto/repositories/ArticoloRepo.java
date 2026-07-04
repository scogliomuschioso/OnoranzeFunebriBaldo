package com.baldosrl.tambuto.repositories;

import com.baldosrl.tambuto.entities.Articolo;
import com.baldosrl.tambuto.entities.User;
import com.baldosrl.tambuto.supports.enumerations.Stato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/*ogni entità ha una sua repo, essa implementa il pattern dao, questo permette di evitare
* l'accesso diretto con l'entità usando invece un sostituto che fa da proxy perchè è lui che
* si dedica anche alla parte logica, quindi l'utente non interagisce con l'entità grezza*/
@Repository
public interface ArticoloRepo extends JpaRepository<Articolo,Integer> {

    boolean existsByNomeAndTipoArticolo(String nome,String tipo);

    @Query("SELECT a " +
            "FROM Articolo a " +
            "WHERE (a.nome LIKE ?1 OR ?1 IS NULL) AND " +
            "      (a.tipoArticolo LIKE ?2 OR ?2 IS NULL)")
    List<Articolo> advancedSearch(String nome, String tipo);




}
