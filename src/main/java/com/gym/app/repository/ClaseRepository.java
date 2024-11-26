package com.gym.app.repository;

import com.gym.app.entity.Clase;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClaseRepository extends MongoRepository<Clase, String> {
}
