package com.santi.AhorcadoApi.model;
import com.santi.AhorcadoApi.model.Palabras;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "partidas")
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "jugador_nombre", nullable = false)
    private Jugador jugador;
    @ManyToOne
    @JoinColumn(name = "palabra_id", nullable = false)
    private Palabras palabra;
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
    public Palabras getPalabra() { return palabra; }
    public void setPalabra(Palabras palabra) { this.palabra = palabra; }
    public boolean isGano() { return gano; }
    public void setGano(boolean gano) { this.gano = gano; }
    public LocalDateTime getFecha() { return this.fecha; }

}
