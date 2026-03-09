    package com.santi.AhorcadoApi.controller;


    import com.santi.AhorcadoApi.repository.JugadorRepository;
    import com.santi.AhorcadoApi.repository.PartidaRepository;
    import com.santi.AhorcadoApi.model.Partida;
    import com.santi.AhorcadoApi.model.Jugador;
    import org.springframework.web.bind.annotation.*;
    import java.util.List;

    @RestController
    @RequestMapping("/partidas" )
    public class PartidaController {
        private final PartidaRepository partidaRepository;
        private final JugadorRepository jugadorRepository;

        public PartidaController(PartidaRepository repository,JugadorRepository jugadorRepository) {
            this.partidaRepository=repository;
            this.jugadorRepository=jugadorRepository;}

        @GetMapping
        public List<Partida> listar(){
            return partidaRepository.findAll();
        }

        @GetMapping("/jugador/{jugadorId}")
        public List<Partida> listarPorJugador(@PathVariable Long jugadorId) {
            Jugador jugador = jugadorRepository.findById(jugadorId)
                    .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
            return partidaRepository.findByJugador(jugador);
        }

        @PostMapping
        public Partida guardar(@RequestBody Partida partida) {
            return partidaRepository.save(partida);
        }

    }
