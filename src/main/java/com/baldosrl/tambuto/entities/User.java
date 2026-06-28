package com.baldosrl.tambuto.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data

public class User {
    @Basic
    @Column(name="email",nullable = false)
    private String email;

    @Basic
    @Column(name="nome",nullable = false)
    private String nome;

    @Basic
    @Column(name="cognome",nullable = false)
    private String cognome;

    @Basic
    @Column(name="telefono",nullable = false)
    private int telefono;

    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;


    // l'utente ha più carrelli in modo da poter andare a dividere quelli acquistati e non
    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
    private List<Carrello> storicoOrdini = new ArrayList<>();
}
