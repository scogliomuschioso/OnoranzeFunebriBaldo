package com.baldosrl.tambuto.DTO;

import com.baldosrl.tambuto.entities.Lista;
import com.baldosrl.tambuto.entities.User;
import com.baldosrl.tambuto.supports.enumerations.Stato;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class CarrelloDTO {
    private int id;
    private int totale;

    public int getId() {
        return id;
    }

    public int getTotale() {
        return totale;
    }

    public LocalDateTime getDatadiacq() {
        return datadiacq;
    }

    public User getUtente() {
        return utente;
    }

    public Stato getStato() {
        return stato;
    }

    public List<Lista> getLista() {
        return lista;
    }

    private LocalDateTime datadiacq;
    private User utente;
    private Stato stato;
    private List<Lista> lista;

    public void setId(int id) {
        this.id = id;
    }

    public void setTotale(int totale) {
        this.totale = totale;
    }

    public void setDatadiacq(LocalDateTime datadiacq) {
        this.datadiacq = datadiacq;
    }

    public void setUtente(User utente) {
        this.utente = utente;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public void setLista(List<Lista> lista) {
        this.lista = lista;
    }

}
