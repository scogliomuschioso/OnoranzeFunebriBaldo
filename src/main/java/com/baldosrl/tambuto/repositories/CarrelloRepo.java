package com.baldosrl.tambuto.repositories;


import com.baldosrl.tambuto.entities.Articolo;
import com.baldosrl.tambuto.entities.Carrello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarrelloRepo extends JpaRepository<Carrello,Integer> {

}
