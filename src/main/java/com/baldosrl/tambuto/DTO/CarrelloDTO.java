package com.baldosrl.tambuto.DTO;

import com.baldosrl.tambuto.entities.Lista;
import com.baldosrl.tambuto.entities.User;
import com.baldosrl.tambuto.supports.enumerations.Stato;

import java.util.Date;
import java.util.List;

public class CarrelloDTO {
    private int id;
    private int totale;
    private Date datadiacq;
    private User utente;
    private Stato stato;
    private List<Lista> lista;

    public void setId(int id) {
        this.id = id;
    }

    public void setTotale(int totale) {
        this.totale = totale;
    }

    public void setDatadiacq(Date datadiacq) {
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
