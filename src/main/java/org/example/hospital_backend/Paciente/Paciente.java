package org.example.hospital_backend.Paciente;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Paciente {

    @Id
    private long id;
    private String name;
    private String razonDeVisita;
    private String telefono;
    private String expediente;

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
}
