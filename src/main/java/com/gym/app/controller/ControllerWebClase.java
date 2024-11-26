package com.gym.app.controller;

import com.gym.app.entity.Clase;
import com.gym.app.exception.NotFoundException;
import com.gym.app.repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clases")
public class ControllerWebClase {

    @Autowired
    private ClaseRepository claseRepository;

    @GetMapping
    public String listarClases(Model model) {
        model.addAttribute("clases", claseRepository.findAll());
        return "clases"; // Renderiza clase-lista.html
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("clase", new Clase()); // Objeto vacío para el formulario
        return "clase-form"; // Renderiza clase-form.html
    }

    @PostMapping("/guardar")
    public String guardarClase(@ModelAttribute Clase clase) {
        claseRepository.save(clase);
        return "redirect:/clases"; // Redirige al listado de clases
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable String id, Model model) {
        Clase clase = claseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Clase no encontrada"));
        model.addAttribute("clase", clase); // Objeto existente para edición
        return "clase-form"; // Renderiza clase-form.html
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarClase(@PathVariable String id) {
        claseRepository.deleteById(id);
        return "redirect:/clases"; // Redirige al listado de clases
    }
}
 	