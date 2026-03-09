package com.santi.AhorcadoApi.controller;

import com.santi.AhorcadoApi.model.Palabras;
import com.santi.AhorcadoApi.repository.PalabraRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/palabras")
public class PalabraController {
    private final PalabraRepository repository;
    private final Random random = new Random();

    public PalabraController(PalabraRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Palabras>cargar(){
        return repository.findAll();
    }

    @GetMapping("/random")
    public Palabras random() {
        List<Palabras> palabras = repository.findAll();
        return palabras.get(random.nextInt(palabras.size()));
    }
}
    