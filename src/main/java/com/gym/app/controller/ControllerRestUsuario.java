package com.gym.app.controller;

import com.gym.app.entity.Usuario;
import com.gym.app.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class ControllerRestUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Obtener todos los usuarios
     */
    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }

    /**
     * Crear un usuario
     */
    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioCreado = usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCreado);
    }

    /**
     * Actualizar un usuario por ID
     */
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable String id, @RequestBody Usuario usuarioActualizado) {
        // Busca el usuario existente
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));

        // Actualiza solo los campos proporcionados
        if (usuarioActualizado.getNombres() != null) usuarioExistente.setNombres(usuarioActualizado.getNombres());
        if (usuarioActualizado.getApellidos() != null) usuarioExistente.setApellidos(usuarioActualizado.getApellidos());
        if (usuarioActualizado.getCorreo() != null) usuarioExistente.setCorreo(usuarioActualizado.getCorreo());
        if (usuarioActualizado.getTelefono() != null) usuarioExistente.setTelefono(usuarioActualizado.getTelefono());
        if (usuarioActualizado.getPeso() != 0) usuarioExistente.setPeso(usuarioActualizado.getPeso());
        if (usuarioActualizado.getAltura() != 0) usuarioExistente.setAltura(usuarioActualizado.getAltura());

        // Guarda los cambios en la base de datos
        Usuario usuarioActualizadoDB = usuarioRepository.save(usuarioExistente);
        return ResponseEntity.ok(usuarioActualizadoDB);
    }

    /**
     * Eliminar un usuario por ID
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable String id) {
        if (!usuarioRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Obtener un usuario por ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable String id) {
        return usuarioRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
