package com.baldosrl.tambuto.DTO;

import com.baldosrl.tambuto.entities.Articolo;

import java.util.List;

public class ConteinerDTO {
    List<Articolo> art;

    public List<Articolo> getArt() {
        return art;
    }

    public void setArt(List<Articolo> art) {
        this.art = art;
    }
}
