package com.baldosrl.tambuto.DTO;

import com.baldosrl.tambuto.entities.Articolo;
import com.baldosrl.tambuto.entities.Carrello;

public class ListaDTO {
    private int id;
    private Carrello carrello;
    private Articolo articolo;
    private int qta;

    public int getId() {
        return id;
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public Articolo getArticolo() {
        return articolo;
    }

    public int getQta() {
        return qta;
    }

    public void setQta(int qta) {
        this.qta = qta;
    }

    public void setArticolo(Articolo articolo) {
        this.articolo = articolo;
    }

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
    }

    public void setId(int id) {
        this.id = id;
    }
}
