package org.example.hospital_backend.Consultorio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ConsultorioConfig {

    @Bean
    CommandLineRunner commandLineRunnerConsultorios(ConsultorioRepository consultorioRepository) {
        return args -> {
            Consultorio num1 = new Consultorio("Heart Stop",true);
            Consultorio num2 = new Consultorio("Normal",true);
            Consultorio num3 = new Consultorio("Tilted Towers",true);
            Consultorio num4 = new Consultorio("META",true);
            Consultorio num5 = new Consultorio("Head Shot",true);
            Consultorio num6 = new Consultorio("OMG",true);
            Consultorio num7 = new Consultorio("N",true);
            Consultorio num8 = new Consultorio("Day One",true);
            Consultorio num9 = new Consultorio("Rhamed",true);
            Consultorio num10 = new Consultorio("Messi",true);

            consultorioRepository.saveAll(List.of(num1,num2,num3,num4,num5,num6,num7,num8,num9,num10));
        };
    }
}
