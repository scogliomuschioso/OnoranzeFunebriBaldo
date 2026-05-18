package com.baldosrl.tambuto.entities;

import jakarta.persistence.*;
import lombok.Data;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.Set;


@Entity
@Data
public class Articolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "articolo",cascade = CascadeType.ALL)
    private Set<Lista> lista;

    @Basic
    @Column(name="immagine",nullable = false)
    private String immagine;

    @Basic
    @Column(name="quantita",nullable = false)
    private int quantita;

    @Basic
    @Column(name="tipoarticolo",nullable = false)
    private String tipoArticolo;

    @Basic
    @Column(name="prezzo",nullable = false)
    private int prezzo;

    @Basic
    @Column(name="nome",nullable = false)
    private String nome;

    @Basic
    @Column(name="descrizione",nullable = false)
    private String descrizione;

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(name="stato",nullable = false)
    private Stato stato;

enum Stato{
        incarrello,comprato
    }
}

