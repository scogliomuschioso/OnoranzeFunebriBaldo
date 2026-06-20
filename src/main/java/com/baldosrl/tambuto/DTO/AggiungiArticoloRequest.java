package com.baldosrl.tambuto.DTO;

public class AggiungiArticoloRequest {
    private int idutente;
    private int idarticolo;
    private int qta;

    public int getIdutente() {
        return idutente;
    }

    public int getIdarticolo() {
        return idarticolo;
    }

    public int getQta() {
        return qta;
    }

    public void setIdutente(int idutente) {
        this.idutente = idutente;
    }

    public void setIdarticolo(int idarticolo) {
        this.idarticolo = idarticolo;
    }

    public void setQta(int qta) {
        this.qta = qta;
    }
}
