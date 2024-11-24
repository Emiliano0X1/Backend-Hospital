package org.example.hospital_backend.Consultorio;

import jakarta.persistence.*;

@Entity
@Table
public class Consultorio {

    @Id
    @SequenceGenerator(name = "consultorio_sequence",sequenceName = "consultorio_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consultorio_sequence")
    private long id;
    private String nombre;
    private boolean disponible;

    public Consultorio() {}

    public Consultorio(String nombre, boolean disponible) {
        this.nombre = nombre;
        this.disponible = disponible;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
