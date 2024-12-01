package org.example.hospital_backend.Usuarios;

import org.example.hospital_backend.Usuarios.TiposDeUsuario.Recepcionista;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getUsuario(){
        return usuarioRepository.findAll();
    }


    public boolean loginUsuario(Usuario usuario){

        Optional<Usuario> usuario1 = usuarioRepository.findByNombre(usuario.getNombre());

        if(!usuario1.isPresent()){
            throw new IllegalArgumentException("Usuario no encontrado");
        }

        Usuario usuarioMain = usuario1.get();

        if(!usuario.password.equals(usuarioMain.getPassword())) {
            throw new IllegalArgumentException("Contraseña incorreta");
        }

        return true;

    }
}
