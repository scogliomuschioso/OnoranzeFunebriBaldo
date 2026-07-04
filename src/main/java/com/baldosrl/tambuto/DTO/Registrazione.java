package com.baldosrl.tambuto.DTO;

import com.baldosrl.tambuto.entities.Carrello;

import java.util.ArrayList;
import java.util.List;

public class Registrazione {
    private String email;
    private String password;
    private String nome;
    private String cognome;
    private int telefono;
    private int id;
    private List<Carrello> storicoOrdini = new ArrayList<>();

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setStoricoOrdini(List<Carrello> storicoOrdini) {
        this.storicoOrdini = storicoOrdini;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
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

    public List<Carrello> getStoricoOrdini() {
        return storicoOrdini;
    }
}
