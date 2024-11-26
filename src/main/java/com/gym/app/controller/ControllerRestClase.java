package com.gym.app.controller;

import com.gym.app.entity.Clase;
import com.gym.app.repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clases")
public class ControllerRestClase {

    @Autowired
    private ClaseRepository claseRepository;

    @GetMapping
    public List<Clase> listarClases() {
        return claseRepository.findAll();
    }

    @PostMapping
    public Clase crearClase(@RequestBody Clase clase) {
        return claseRepository.save(clase);
    }

    @PutMapping("/{id}")
    public Clase actualizarClase(@PathVariable String id, @RequestBody Clase claseActualizada) {
        Clase claseExistente = claseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));
        claseActualizada.setId(claseExistente.getId());
        return claseRepository.save(claseActualizada);
    }

    @DeleteMapping("/{id}")
    public void eliminarClase(@PathVariable String id) {
        claseRepository.deleteById(id);
    }
}
