package com.baldosrl.tambuto.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Carrello {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name="totale",nullable = false)
    private int totale;

    @OneToOne
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private User cliente;

    @OneToMany(mappedBy = "carrello",cascade = CascadeType.ALL)
    private List<Lista> lista = new LinkedList<>();


}
