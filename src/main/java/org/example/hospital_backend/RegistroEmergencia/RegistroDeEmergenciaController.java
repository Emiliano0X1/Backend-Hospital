package org.example.hospital_backend.RegistroEmergencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/emergencias")
public class RegistroDeEmergenciaController {

    @Autowired
    private final RegistroDeEmergenciaService registroDeEmergenciaService;

    public RegistroDeEmergenciaController(RegistroDeEmergenciaService registroDeEmergenciaService) {
        this.registroDeEmergenciaService = registroDeEmergenciaService;
    }

    @GetMapping
    public List<RegistroDeEmergencia> getEmergencias() {
        return registroDeEmergenciaService.getEmergencias();
    }


}
