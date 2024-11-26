package com.gym.app.repository;

import com.gym.app.entity.CitasFisio;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CitasFisioRepository extends MongoRepository<CitasFisio, String> {

    // Buscar citas por fecha
    List<CitasFisio> findByFecha(String fecha);

    // Buscar citas por fisioterapeuta
    List<CitasFisio> findByFisioACargo(String fisioACargo);
}
