package com.santi.AhorcadoApi.repository;

import com.santi.AhorcadoApi.model.Palabras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PalabraRepository extends JpaRepository<Palabras,Long> {

}
