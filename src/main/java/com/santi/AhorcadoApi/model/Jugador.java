package com.santi.AhorcadoApi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "jugador")
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String nombre;
    int puntos;
    int rachaActual;
    int mayorRacha;


    public Jugador() {}

    public Long getId() { return this.id; }
    public void setId(long id) { this.id=id; }


    public String getNombre() { return this.nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getPuntos() { return this.puntos; }
    public void setPuntos(int puntos) { this.puntos = puntos; }

    public int getRachaActual() { return this.rachaActual; }
    public void setRachaActual(int rachaActual) { this.rachaActual = rachaActual; }

    public int getMayorRacha() { return this.mayorRacha; }
    public void setMayorRacha(int mayorRacha) { this.mayorRacha = mayorRacha; }

}
