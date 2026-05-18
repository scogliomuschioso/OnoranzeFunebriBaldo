package com.baldosrl.tambuto.entities;


import jakarta.persistence.*;
import lombok.Data;


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

    @OneToOne(mappedBy = "cliente",cascade = CascadeType.ALL) //il controllo della relazione non ce l'ha
    //client ma carrello
    private Carrello carello;
}
