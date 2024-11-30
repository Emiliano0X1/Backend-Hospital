package org.example.hospital_backend.RegistroEmergencia;

import jakarta.persistence.*;
import org.example.hospital_backend.Consultorio.Consultorio;
import org.example.hospital_backend.Paciente.Paciente;

@Entity
@Table
public class RegistroDeEmergencia {

    @Id
    @SequenceGenerator(name = "registroEmergencia_sequence",sequenceName = "registroEmergencia_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registroEmergencia_sequence")
    private long id;
    private int edad;
    private String nombre;
    private String razonDeIngreso;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "emergencia_id")
    private Consultorio consultorio;

    public RegistroDeEmergencia() {}

    public RegistroDeEmergencia(int edad, String nombre, String razonDeIngreso,Consultorio consultorio) {
        this.edad = edad;
        this.nombre = nombre;
        this.razonDeIngreso = razonDeIngreso;
        this.consultorio = consultorio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRazonDeIngreso() {
        return razonDeIngreso;
    }

    public void setRazonDeIngreso(String razonDeIngreso) {
        this.razonDeIngreso = razonDeIngreso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }
}
