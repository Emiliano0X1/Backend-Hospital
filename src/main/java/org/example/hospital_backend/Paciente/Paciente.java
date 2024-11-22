package org.example.hospital_backend.Paciente;

import jakarta.persistence.*;
import org.example.hospital_backend.Cita.Cita;
import org.example.hospital_backend.RegistroEmergencia.RegistroDeEmergencia;

import java.util.List;

@Entity
@Table
public class Paciente {

    @Id
    @SequenceGenerator(name = "paciente_sequence",sequenceName = "paciente_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_sequence")
    private long id;
    private String name;
    private String razonDeVisita;
    private String telefono;
    private String expediente;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cita> citas;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegistroDeEmergencia> registroDeEmergencias;

    public Paciente() {}

    public Paciente(String name,String razonDeVisita, String telefono, String expediente) {
        this.razonDeVisita = razonDeVisita;
        this.telefono = telefono;
        this.expediente = expediente;
        this.name = name;
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

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
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
}
