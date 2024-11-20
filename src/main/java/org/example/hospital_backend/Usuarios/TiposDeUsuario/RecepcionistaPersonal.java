package org.example.hospital_backend.Usuarios.TiposDeUsuario;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Recepcionista Personal")
public class RecepcionistaPersonal extends Recepcionista{

    private long id;

    public RecepcionistaPersonal(){}

    public RecepcionistaPersonal(String email, String password) {
        super(email, password);
    }
}
