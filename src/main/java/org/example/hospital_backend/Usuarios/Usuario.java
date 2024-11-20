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
    protected String email;
    protected String password;

    public Usuario() {}

    public Usuario(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
