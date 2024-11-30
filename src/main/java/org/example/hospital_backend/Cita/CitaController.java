package org.example.hospital_backend.Cita;

import org.example.hospital_backend.Consultorio.Consultorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/cita")
public class CitaController {

    @Autowired
    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping
    public List<Cita> getAllCitas() {
        return citaService.getAllCitas();
    }

    @GetMapping(path = "{cita_id}")
    public Cita getCitaById(long id) {
        return citaService.getCitaById(id);
    }

    @PostMapping
    public Cita agendarCita(@RequestBody Cita cita,@RequestParam(required = false) Long consultorio_id) {
        return citaService.agendarCita(cita,consultorio_id);
    }

    @DeleteMapping(path = "{cita_id}")
    public void borrarCita(@PathVariable("cita_id") long cita_id) {
        citaService.borrarCita(cita_id);
    }

    @PatchMapping(path = "{cita_id}")
    public void actualizarFecha(@PathVariable("cita_id") long cita_id, @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha) {
        citaService.modificarFecha(cita_id,fecha);
    }

}
