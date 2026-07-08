package com.baldosrl.tambuto.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Lista {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToOne//siccome la relazione deve avere anche la quantità come
    @JoinColumn(name="carrello_id",nullable = false)//attributo non posso usare manytomany
    private Carrello carrello;

    @ManyToOne
    @JoinColumn(name="articolo_id",nullable = false)
    private Articolo articolo;

    @Basic
    @Column(name="quantita",nullable = false)
    private int qta;

}
