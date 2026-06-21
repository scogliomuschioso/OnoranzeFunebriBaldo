package com.baldosrl.tambuto.DTO;

import com.baldosrl.tambuto.entities.Carrello;
import com.baldosrl.tambuto.supports.enumerations.Ruolo;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class UtenteDTO {
    private String email;
    private String nome;
    private String cognome;
    private int telefono;
    private int id;
    private Ruolo ruolo;
    private List<Carrello> storicoOrdini = new ArrayList<>();

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getTelefono() {
        return telefono;
    }

    public int getId() {
        return id;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public List<Carrello> getStoricoOrdini() {
        return storicoOrdini;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public void setStoricoOrdini(List<Carrello> storicoOrdini) {
        this.storicoOrdini = storicoOrdini;
    }
}
