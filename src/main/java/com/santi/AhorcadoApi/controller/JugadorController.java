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

    // GET /jugadores/{id} → trae un jugador por su ID
    @GetMapping("/{id}")
    public Jugador obtenerPorId(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
    }

    // GET /jugadores/nombre/{nombre} → busca un jugador por su nombre
    @GetMapping("/nombre/{nombre}")
    public Jugador obtenerPorNombre(@PathVariable String nombre) {
        return repository.findByNombre(nombre);
    }

    @PostMapping
    public Jugador crear(@RequestBody Jugador jugador) {
        jugador.setPuntos(0);
        jugador.setRachaActual(0);
        jugador.setMayorRacha(0);
        return repository.save(jugador);
    }


    @PutMapping("/{id}")
    public Jugador actualizar(@PathVariable Long id, @RequestBody Jugador jugador) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
        jugador.setId(id);
        return repository.save(jugador);
    }
}