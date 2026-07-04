package com.baldosrl.tambuto.entities;

import com.baldosrl.tambuto.supports.enumerations.Stato;
import jakarta.persistence.*;
import lombok.Data;

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

}

