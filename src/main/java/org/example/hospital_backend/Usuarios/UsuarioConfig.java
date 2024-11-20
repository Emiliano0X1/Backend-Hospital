package org.example.hospital_backend.Usuarios;

import org.example.hospital_backend.Usuarios.TiposDeUsuario.Medico;
import org.example.hospital_backend.Usuarios.TiposDeUsuario.Recepcionista;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UsuarioConfig {

    @Bean
    CommandLineRunner commandLineRunner(UsuarioRepository usuarioRepository) {
        return args -> {
            Usuario num1 = new Medico("egp2506@gmail.com","Hola");
            Usuario num2 = new Recepcionista("spiterman@gmail.com","Hola2");

            usuarioRepository.saveAll(List.of(num1,num2));
        };
    }
}
