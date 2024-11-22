package org.example.hospital_backend.Cita;

import jakarta.persistence.*;
import org.example.hospital_backend.Paciente.Paciente;

import java.util.Date;

@Entity
@Table
public class Cita {

    @Id
    @SequenceGenerator(name = "cita_sequence",sequenceName = "cita_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cita_sequence")
    private long id;
    private String nombre;
    private Date fecha;
    private int edad;
    private String consultorio;
    private String telefono;
    private String nombreMedico;

    @ManyToOne()
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    public Cita(){}

    public Cita(String nombre, Date fecha, int edad, String consultorio, String telefono, String nombreMedico) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.edad = edad;
        this.consultorio = consultorio;
        this.telefono = telefono;
        this.nombreMedico = nombreMedico;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
