    package com.santi.AhorcadoApi.controller;

    import com.santi.AhorcadoApi.repository.*;
    import com.santi.AhorcadoApi.model.Partida;
    import com.santi.AhorcadoApi.model.Jugador;
    import org.springframework.web.bind.annotation.*;
    import java.util.List;

    @RestController
    @RequestMapping("/partidas" )
    public class PartidaController {
        private final PartidaRepository partidaRepository;
        private final JugadorRepository jugadorRepository;
        private final PalabraRepository palabraRepository;

        public PartidaController(PartidaRepository partidaRepository,
                                 JugadorRepository jugadorRepository,
                                 PalabraRepository palabraRepository) {
            this.partidaRepository = partidaRepository;
            this.jugadorRepository = jugadorRepository;
            this.palabraRepository = palabraRepository;
        }

        @GetMapping
        public List<Partida> listar(){
            return partidaRepository.findAll();
        }

        @GetMapping("/jugador/{jugador_nombre}")
        public List<Partida> listarPorJugador(@PathVariable String jugadorNombre) {
            Jugador jugador = jugadorRepository.findByNombre(jugadorNombre)
                    .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
            return partidaRepository.findByJugador(jugador);
        }

        @PostMapping
        public Partida guardar(@RequestBody Partida partida) {
            palabraRepository.findById(partida.getPalabra().getId())
                    .orElseThrow(() -> new RuntimeException("Palabra no encontrada"));
            return partidaRepository.save(partida);
        }

    }
