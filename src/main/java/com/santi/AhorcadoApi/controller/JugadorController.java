package com.santi.AhorcadoApi.controller;

import com.santi.AhorcadoApi.model.Jugador;
import com.santi.AhorcadoApi.model.Palabras;
import com.santi.AhorcadoApi.repository.PalabraRepository;
import org.springframework.web.bind.annotation.*;
import com.santi.AhorcadoApi.controller.JugadorController;
import com.santi.AhorcadoApi.repository.JugadorRepository;
import java.util.List;

@RestController
@RequestMapping("/jugador")
public class JugadorController {
    private final JugadorRepository repository;


    public JugadorController(JugadorRepository repository) {
        this.repository = repository;
    }

    // GET /jugadores → trae todos los jugadores
    @GetMapping
    public List<Jugador> listar() {
        return repository.findAll();
    }

    // GET /jugadores/{id} → trae un jugador por su nombre de usuario unico para cada uno
    @GetMapping("/{nombre}")
    public Jugador obtenerPorId(@PathVariable String nombre) {
        return repository.findByNombre(nombre)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
    }


    @PostMapping
    public Jugador crear(@RequestBody Jugador jugador) {
        jugador.setPuntos(0);
        jugador.setRachaActual(0);
        jugador.setMayorRacha(0);
        return repository.save(jugador);
    }


    @PutMapping("/{id}")
    public Jugador actualizar(@PathVariable String nombre, @RequestBody Jugador jugador) {
        repository.findByNombre(nombre)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
        jugador.setNombre(nombre);
        return repository.save(jugador);
    }
}