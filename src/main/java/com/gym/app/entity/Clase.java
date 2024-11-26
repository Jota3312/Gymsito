package com.gym.app.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Clases")
public class Clase {
    @Id
    private String id;
    private String nombre;
    private String tipoDeClase;
    private String dia;
    private String hora;

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDeClase() {
        return tipoDeClase;
    }

    public void setTipoDeClase(String tipoDeClase) {
        this.tipoDeClase = tipoDeClase;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
