package com.baldosrl.tambuto.entities;

import com.baldosrl.tambuto.supports.enumerations.Stato;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
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


    @CreationTimestamp
    @Column(name = "datadiacq", updatable = false)
    private LocalDateTime datadiacq;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private User utente;

    @Enumerated(EnumType.STRING)
    private Stato stato;

    @OneToMany(mappedBy = "carrello",cascade = CascadeType.ALL)
    private List<Lista> lista = new LinkedList<>();


}
