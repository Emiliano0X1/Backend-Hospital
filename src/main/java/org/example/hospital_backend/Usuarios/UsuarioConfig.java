package org.example.hospital_backend.Usuarios;

import org.example.hospital_backend.Usuarios.TiposDeUsuario.Medico;
import org.example.hospital_backend.Usuarios.TiposDeUsuario.Recepcionista;
import org.example.hospital_backend.Usuarios.TiposDeUsuario.RecepcionistaPersonal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UsuarioConfig {

    @Bean
    CommandLineRunner commandLineRunner(UsuarioRepository usuarioRepository) {
        return args -> {
            Usuario num1 = new Medico("medico","Hola");
            Usuario num2 = new Recepcionista("recepcionista","Hola2");
            Usuario num3 = new RecepcionistaPersonal("recepcionistaPersonal","Hola3");

            usuarioRepository.saveAll(List.of(num1,num2,num3));
        };
    }
}
