package org.example.hospital_backend.Paciente;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.example.hospital_backend.Cita.Cita;
import org.example.hospital_backend.Consultorio.Consultorio;
import org.example.hospital_backend.Expediente.Expediente;
import org.example.hospital_backend.Receta.Receta;
import org.example.hospital_backend.RegistroEmergencia.RegistroDeEmergencia;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Paciente {

    @Id
    @SequenceGenerator(name = "paciente_sequence", sequenceName = "paciente_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_sequence")
    private long id;
    private String name;
    private String razonDeVisita;
    private String telefono;

    @JsonIgnore
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cita> citas = new ArrayList<>();

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegistroDeEmergencia> registroDeEmergencias = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "paciente_id")
    private Expediente expediente;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Receta> recetas = new ArrayList<>();

    public Paciente() {}

    public Paciente(String name,String razonDeVisita, String telefono,List<Cita> citas,List<RegistroDeEmergencia> registroDeEmergencias,Expediente expediente,List<Receta> recetas) {
        this.razonDeVisita = razonDeVisita;
        this.telefono = telefono;
        this.name = name;
        this.citas = citas != null ? citas : new ArrayList<>();
        this.registroDeEmergencias = registroDeEmergencias != null ? registroDeEmergencias : new ArrayList<>();
        this.expediente = expediente;
        this.recetas = recetas != null ? recetas : new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRazonDeVisita() {
        return razonDeVisita;
    }

    public void setRazonDeVisita(String razonDeVisita) {
        this.razonDeVisita = razonDeVisita;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    public List<RegistroDeEmergencia> getRegistroDeEmergencias() {
        return registroDeEmergencias;
    }

    public void setRegistroDeEmergencias(List<RegistroDeEmergencia> registroDeEmergencias) {
        this.registroDeEmergencias = registroDeEmergencias;
    }

    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    public List<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<Receta> recetas) {
        this.recetas = recetas;
    }

    public void addCita(Cita cita){

        if(cita == null){
            this.citas = new ArrayList<>();
        }

        this.citas.add(cita);
        cita.setPaciente(this);
    }

    public void addRegistroEmergencia(RegistroDeEmergencia registroEmergencia){
        if(registroEmergencia == null){
            this.registroDeEmergencias = new ArrayList<>();
        }

        this.registroDeEmergencias.add(registroEmergencia);
        registroEmergencia.setPaciente(this);
    }

    public void addReceta(Receta receta){
        if(receta == null){
            this.recetas = new ArrayList<>();
        }

        this.recetas.add(receta);
        receta.setPaciente(this);
    }
}
