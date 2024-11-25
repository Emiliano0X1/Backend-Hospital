package org.example.hospital_backend.Expediente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/expediente")
public class ExpedienteController {

    @Autowired
    private final ExpedienteService expedienteService;

    public ExpedienteController(ExpedienteService expedienteService) {
        this.expedienteService = expedienteService;
    }

    @GetMapping
    public List<Expediente> getExpedientes() {
        return expedienteService.getExpedientes();
    }

    @GetMapping(path = "{expedienteId}")
    public Expediente getExpediente(long expedienteId) {
        return expedienteService.getExpedienteById(expedienteId);
    }

    @PostMapping
    public Expediente crearExpediente(Expediente expediente) {
        return expedienteService.crearExpediente(expediente);
    }

    @DeleteMapping(path = "{expediente_id}")
    public void eliminarExpediente(@PathVariable("expedienteId") long expedienteId) {
        expedienteService.eliminarExpediente(expedienteId);
    }

    @PutMapping(path = "{expediente_id}")
    public void actualizarExpediente(@PathVariable("expediente_id") long expedienteId,@RequestBody Expediente expediente) {
        expedienteService.actualizarExpediente(expedienteId,expediente);
    }
}
