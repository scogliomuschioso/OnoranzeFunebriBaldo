package com.baldosrl.tambuto.DTO;

public class AggiungiArticoloRequest {
    private int idarticolo;
    private int qta;


    public int getIdarticolo() {
        return idarticolo;
    }

    public int getQta() {
        return qta;
    }


    public void setIdarticolo(int idarticolo) {
        this.idarticolo = idarticolo;
    }

    public void setQta(int qta) {
        this.qta = qta;
    }
}
