package org.example.hospital_backend.Paciente;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> getListaDePacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente getPacienteById(long id) {
        return pacienteRepository.findById(id).get();
    }

    //Post Methods

    public Paciente registrarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    //Delete Methods

    public void eliminarPaciente(long paciente_id) {

        boolean exists = pacienteRepository.existsById(paciente_id);

        if(!exists) {
            throw new IllegalArgumentException("Paciente no existe.");
        }

        pacienteRepository.deleteById(paciente_id);
    }

    //Put Methods
    public void modificarPaciente(long pacienteId,Paciente newPaciente) {

        Paciente paciente = pacienteRepository.findById(pacienteId).orElseThrow(() -> new IllegalArgumentException("No existe ese paciente"));

        if(!newPaciente.getName().isEmpty() && !Objects.equals(newPaciente.getName(), paciente.getName())) {
            paciente.setName(newPaciente.getName());
        }

        if(!newPaciente.getRazonDeVisita().isEmpty() && !Objects.equals(newPaciente.getRazonDeVisita(), paciente.getRazonDeVisita())) {
            paciente.setRazonDeVisita(newPaciente.getRazonDeVisita());
        }

        if(!newPaciente.getTelefono().isEmpty() && !Objects.equals(newPaciente.getTelefono(), paciente.getTelefono())) {
            paciente.setTelefono(newPaciente.getTelefono());
        }

        if(!newPaciente.getExpediente().isEmpty() && !Objects.equals(newPaciente.getExpediente(), paciente.getExpediente())) {
            paciente.setExpediente(newPaciente.getExpediente());
        }

        pacienteRepository.save(paciente);
    }


}
