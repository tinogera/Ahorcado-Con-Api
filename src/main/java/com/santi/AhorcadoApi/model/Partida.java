package com.santi.AhorcadoApi.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "partidas")
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "jugador_id", nullable = false)
    private Jugador jugador;
    @Column
    private String palabra;
    @Column
    private boolean gano;
    private LocalDateTime fecha;

    public Partida() {}

    @PrePersist
    public void asignarFecha() {
        this.fecha = LocalDateTime.now();
    }

    public Long getId() { return this.id; }
    public Jugador getJugador() { return jugador; }
    public void setJugador(Jugador jugador) { this.jugador = jugador; }
    public String getPalabra() { return palabra; }
    public void setPalabra(String palabra) { this.palabra = palabra; }
    public boolean isGano() { return gano; }
    public void setGano(boolean gano) { this.gano = gano; }
    public LocalDateTime getFecha() { return this.fecha; }

}
