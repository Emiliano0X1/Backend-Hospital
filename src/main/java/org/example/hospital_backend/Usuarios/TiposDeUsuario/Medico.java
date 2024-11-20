package org.example.hospital_backend.Usuarios.TiposDeUsuario;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import org.example.hospital_backend.Usuarios.Usuario;

@Entity
@DiscriminatorValue("medico")
public class Medico extends Usuario {

    private long id;

    public Medico() {}

    public Medico(String email, String password) {
        super(email, password);
    }
}
