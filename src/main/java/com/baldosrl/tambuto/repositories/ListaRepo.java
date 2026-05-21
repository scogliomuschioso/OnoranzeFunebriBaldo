package com.baldosrl.tambuto.repositories;

import com.baldosrl.tambuto.entities.Articolo;
import com.baldosrl.tambuto.entities.Lista;
import com.baldosrl.tambuto.supports.Stato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface ListaRepo extends JpaRepository<Lista,Integer> {

}
