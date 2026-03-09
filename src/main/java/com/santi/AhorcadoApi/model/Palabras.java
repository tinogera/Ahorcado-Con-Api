package com.santi.AhorcadoApi.model;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "palabras")
public class Palabras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id
            ;
    @Column
    String palabra;

    public Palabras() {}


    public String getPalabra() {
        return this.palabra;
    }

    public Long getId() {
        return this.id;
    }

    public void setPalabra(String nuevaPalabra) {
        this.palabra = nuevaPalabra;
    }
}