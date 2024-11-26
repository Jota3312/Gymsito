package com.gym.app.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CitasFisio")
public class CitasFisio {
    @Id
    private String id;
    private String nombre; // Nombre del paciente
    private String hora;
    private String fecha;
    private String fisioACargo;
    private String estado;// Nombre del fisioterapeuta a cargo

    // Getters y setters
    public String getId() {
        return id;
    }
    public String getEstado() {
        return estado;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFisioACargo() {
        return fisioACargo;
    }

    public void setFisioACargo(String fisioACargo) {
        this.fisioACargo = fisioACargo;
    }
}
