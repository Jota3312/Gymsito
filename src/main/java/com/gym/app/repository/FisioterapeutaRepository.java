package com.gym.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gym.app.entity.Fisioterapeuta;
import com.gym.app.entity.CitasFisio;

public interface FisioterapeutaRepository extends MongoRepository<Fisioterapeuta, String> {

}
