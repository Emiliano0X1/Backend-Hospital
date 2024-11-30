package org.example.hospital_backend.Usuarios;

import jakarta.persistence.*;

@Entity
@Table
@DiscriminatorColumn(name = "usuario_Type")
public class Usuario {

    @Id
    @SequenceGenerator(name = "usuario_sequence",sequenceName = "usuario_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_sequence")
    private long id;
    protected String nombre;
    protected String password;

    public Usuario() {}

    public Usuario(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
