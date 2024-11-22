package org.example.hospital_backend.Paciente;

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
    public Paciente getPaciente(@RequestParam long id){
        return pacienteService.getPacienteById(id);
    }

    //Post Methods

    @PostMapping
    public Paciente registrarPaciente(@RequestBody Paciente paciente){
        return pacienteService.registrarPaciente(paciente);
    }

    //Put Methods
    @PutMapping(path = "{paciente_id}")
    public void modificarPaciente(@PathVariable("paciente_id") Long paciente_id,@RequestBody Paciente paciente){
        pacienteService.modificarPaciente(paciente_id,paciente);
    }



}
