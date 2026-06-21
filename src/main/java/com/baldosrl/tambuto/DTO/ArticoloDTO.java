package com.baldosrl.tambuto.DTO;

import com.baldosrl.tambuto.entities.Lista;
import jakarta.persistence.*;

import java.util.Set;

public class ArticoloDTO {
    private Set<Lista> lista;
    private String immagine;
    private int quantita;
    private String tipoArticolo;
    private int prezzo;
    private String nome;
    private String descrizione;

    public Set<Lista> getLista() {
        return lista;
    }

    public void setLista(Set<Lista> lista) {
        this.lista = lista;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public String getTipoArticolo() {
        return tipoArticolo;
    }

    public void setTipoArticolo(String tipoArticolo) {
        this.tipoArticolo = tipoArticolo;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
