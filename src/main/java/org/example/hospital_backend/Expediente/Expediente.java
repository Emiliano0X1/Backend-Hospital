package org.example.hospital_backend.Expediente;

import jakarta.persistence.*;

@Entity
@Table
public class Expediente {

    @Id
    @SequenceGenerator(name = "expediente_sequence",sequenceName = "expediente_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expediente_sequence")
    private long id;
    private String historial;

    public Expediente() {}

    public Expediente(String historial) {
        this.historial = historial;
    }

    public String getHistorial() {
        return historial;
    }

    public void setHistorial(String historial) {
        this.historial = historial;
    }
}
