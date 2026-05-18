package com.baldosrl.tambuto.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Lista {

    @Id
    private Long id;

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
