package org.example.hospital_backend.RegistroEmergencia;

import jakarta.persistence.*;
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
    private String consultorio;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    public RegistroDeEmergencia() {}

    public RegistroDeEmergencia(int edad, String nombre, String razonDeIngreso, String consultorio) {
        this.edad = edad;
        this.nombre = nombre;
        this.razonDeIngreso = razonDeIngreso;
        this.consultorio = consultorio;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
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
}
