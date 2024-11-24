package org.example.hospital_backend.Usuarios.TiposDeUsuario;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@DiscriminatorValue("Recepcionista Personal")
public class RecepcionistaPersonal extends Recepcionista{

    @Id
    private long id;

    public RecepcionistaPersonal(){}

    public RecepcionistaPersonal(String email, String password) {
        super(email, password);
    }
}
