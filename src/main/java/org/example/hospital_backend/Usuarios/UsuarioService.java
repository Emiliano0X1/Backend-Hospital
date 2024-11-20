package org.example.hospital_backend.Usuarios;

import org.example.hospital_backend.Usuarios.TiposDeUsuario.Recepcionista;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getUsuario(){
        return usuarioRepository.findAll();
    }
}
