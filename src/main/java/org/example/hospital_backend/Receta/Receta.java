package org.example.hospital_backend.Receta;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table
public class Receta {

    @Id
    private long id;
    private List<String> medicamentos;
    private List<String> especificaciones;


    public Receta() {}

    public Receta(List<String> medicamentos, List<String> especificaciones) {
        this.medicamentos = medicamentos;
        this.especificaciones = especificaciones;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<String> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<String> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public List<String> getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(List<String> especificaciones) {
        this.especificaciones = especificaciones;
    }
}
