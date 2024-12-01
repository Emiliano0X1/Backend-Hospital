package org.example.hospital_backend.Usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listaUsuarios(){
        return usuarioService.getUsuario();
    }


    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario){

        boolean valid = usuarioService.loginUsuario(usuario);

        if(!valid){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Datos incorrectas");
        }
        else{
            return ResponseEntity.ok(usuario);
        }
    }

}
