package org.example.hospital_backend.Paciente;

import org.example.hospital_backend.Cita.Cita;
import org.example.hospital_backend.RegistroEmergencia.RegistroDeEmergencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/paciente")
public class PacienteController {

    @Autowired
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    //Get Methods
    @GetMapping
    public List<Paciente> getPacientes(){
        return pacienteService.getListaDePacientes();
    }

    @GetMapping(path = "{paciente_Id}")
    public Paciente getPaciente(@PathVariable("paciente_Id") long id){
        return pacienteService.getPacienteById(id);
    }

    //Post Methods

    @PostMapping(path = "{cita_id}")
    public Paciente registrarPaciente(@RequestBody Paciente paciente,@PathVariable("cita_id") long cita_id){
        return pacienteService.registrarPaciente(paciente,cita_id);
    }


    //Delete Methods
    @DeleteMapping(path = "{paciente_id}")
    public void deletePaciente(@PathVariable("paciente_id") long paciente_id){
        pacienteService.eliminarPaciente(paciente_id);
    }

    //Put Methods
    @PutMapping(path = "{paciente_id}")
    public void modificarPaciente(@PathVariable("paciente_id") Long paciente_id,@RequestBody Paciente paciente){
        pacienteService.modificarPaciente(paciente_id,paciente);
    }

    //Patch Methods

    @PatchMapping(path = "{paciente_id}")
    public void anadirRegistroEmergencia(@PathVariable("paciente_id") Long paciente_id,@RequestParam Long registro_id){
        pacienteService.anadirRegistroDeEmergencia(paciente_id,registro_id);
    }

}
