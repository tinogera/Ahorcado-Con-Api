package com.santi.AhorcadoApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.santi.AhorcadoApi.model.Jugador;
import java.util.Optional;

public interface JugadorRepository extends JpaRepository<Jugador, String> {
    Optional<Jugador> findByNombre(String nombre);
}
