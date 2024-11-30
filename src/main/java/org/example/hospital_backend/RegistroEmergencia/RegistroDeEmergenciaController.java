package org.example.hospital_backend.RegistroEmergencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "{registroDeEmergenciaId}")
    public RegistroDeEmergencia getRegistroDeEmergencia(@RequestParam Long registroDeEmergenciaId) {
        return registroDeEmergenciaService.getRegistroDeEmergenciaById(registroDeEmergenciaId);
    }

    @PostMapping
    public RegistroDeEmergencia crearRegistroDeEmergencia(@RequestBody RegistroDeEmergencia emergencia) {
        return registroDeEmergenciaService.crearRegistroEmergencia(emergencia);
    }

    @DeleteMapping(path = "{registroDeEmergenciaId}")
    public void borrarRegistroDeEmergencia(@PathVariable("registroDeEmergenciaId") Long registroDeEmergenciaId) {
        registroDeEmergenciaService.borrarRegistroDeEmergencia(registroDeEmergenciaId);
    }
}
