package org.example.hospital_backend.Usuarios.TiposDeUsuario;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import org.example.hospital_backend.Usuarios.Usuario;

@Entity
@DiscriminatorValue("Recepcionista General")
public class Recepcionista extends Usuario {

    private long id;
    public Recepcionista() {}

    public Recepcionista(String email, String password) {
        super(email, password);
    }
}
