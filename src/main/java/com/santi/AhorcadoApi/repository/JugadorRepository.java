package com.santi.AhorcadoApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.santi.AhorcadoApi.model.Jugador;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {
    // Buscar jugador por nombre (lo vamos a necesitar en el juego)
    Jugador findByNombre(String nombre);
}
