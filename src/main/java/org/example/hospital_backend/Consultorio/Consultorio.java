package org.example.hospital_backend.Consultorio;

import jakarta.persistence.*;
import org.example.hospital_backend.Cita.Cita;
import org.example.hospital_backend.Paciente.Paciente;
import org.example.hospital_backend.RegistroEmergencia.RegistroDeEmergencia;

import java.util.List;

@Entity
@Table
public class Consultorio {

    @Id
    @SequenceGenerator(name = "consultorio_sequence", sequenceName = "consultorio_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consultorio_sequence")
    private long id;
    private String nombre;
    private boolean disponible;

    @OneToOne
    @JoinColumn(name = "consultorio_id")
    private Cita cita;

    @OneToOne
    @JoinColumn(name = "consultorio2_id")
    private RegistroDeEmergencia registroDeEmergencia;

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


    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public RegistroDeEmergencia getRegistroDeEmergencia() {
        return registroDeEmergencia;
    }

    public void setRegistroDeEmergencia(RegistroDeEmergencia registroDeEmergencia) {
        this.registroDeEmergencia = registroDeEmergencia;
    }
}
