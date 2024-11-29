package org.example.hospital_backend.Receta;

import jakarta.persistence.*;
import org.example.hospital_backend.Paciente.Paciente;

import java.util.List;

@Entity
@Table
public class Receta {

    @Id
    @SequenceGenerator(name = "receta_sequence",sequenceName = "receta_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "receta_sequence")
    private long id;
    private List<String> medicamentos;
    private List<String> especificaciones;

    @ManyToOne
    @JoinColumn(name = "pacienteId")
    private Paciente paciente;


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
