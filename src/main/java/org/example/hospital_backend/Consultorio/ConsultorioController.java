package org.example.hospital_backend.Consultorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/consultorio")
public class ConsultorioController {

    @Autowired
    private final ConsultorioService consultorioService;

    public ConsultorioController(ConsultorioService consultorioService) {
        this.consultorioService = consultorioService;
    }

    @GetMapping
    public List<Consultorio> getConsultorios() {
        return consultorioService.getAllConsultorios();
    }

    @GetMapping(path = "{consultorio_id}")
    public Consultorio getConsultorio(@PathVariable("consultorio_id") long id) {
        return consultorioService.getConsultorioById(id);
    }

    @PostMapping
    public Consultorio crearConsultorio(@RequestBody Consultorio consultorio) {
        return consultorioService.crearConsultorio(consultorio);
    }

    @DeleteMapping
    public void eliminarConsultorio(long consultorio_id) {
        consultorioService.eliminarConsultorio(consultorio_id);
    }

    @PutMapping(path = "{consultorio_id}")
    public void actualizarConsultorio(@PathVariable("consultorio_id") Long consultorio_id,@RequestBody Consultorio consultorio) {
        consultorioService.actualizarConsultorio(consultorio_id, consultorio);
    }




}
