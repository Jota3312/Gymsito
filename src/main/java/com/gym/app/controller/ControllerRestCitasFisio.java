package com.gym.app.controller;

import com.gym.app.entity.CitasFisio;
import com.gym.app.repository.CitasFisioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class ControllerRestCitasFisio {

    @Autowired
    private CitasFisioRepository citaFisioRepository;

    @GetMapping
    public List<CitasFisio> listarCitas() {
        return citaFisioRepository.findAll();
    }

    @PostMapping
    public CitasFisio crearCita(@RequestBody CitasFisio citaFisio) {
        return citaFisioRepository.save(citaFisio);
    }
    
    @PutMapping("/{id}/estado")
    public CitasFisio actualizarEstado(@PathVariable String id, @RequestParam String estado) {
        CitasFisio cita = citaFisioRepository.findById(id).orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        cita.setEstado(estado);
        return citaFisioRepository.save(cita);
    }
    @DeleteMapping("/{id}")
    public void eliminarCita(@PathVariable String id) {
        citaFisioRepository.deleteById(id);
    }



}
