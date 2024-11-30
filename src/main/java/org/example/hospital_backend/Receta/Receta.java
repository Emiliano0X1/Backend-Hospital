package org.example.hospital_backend.Receta;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.example.hospital_backend.Paciente.Paciente;

import java.util.List;

@Entity
@Table
public class Receta {

    @Id
    @SequenceGenerator(name = "receta_sequence", sequenceName = "receta_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "receta_sequence")
    private long id;
    private String medicamentos;
    private String especificaciones;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pacienteId")
    private Paciente paciente;


    public Receta() {}

    public Receta(String especificaciones, String medicamentos) {
        this.especificaciones = especificaciones;
        this.medicamentos = medicamentos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }
}
