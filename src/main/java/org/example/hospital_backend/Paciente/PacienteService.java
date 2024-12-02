package org.example.hospital_backend.Paciente;

import jakarta.transaction.Transactional;
import org.example.hospital_backend.Cita.Cita;
import org.example.hospital_backend.Cita.CitaRepository;
import org.example.hospital_backend.RegistroEmergencia.RegistroDeEmergencia;
import org.example.hospital_backend.RegistroEmergencia.RegistroDeEmergenciaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final CitaRepository CitaRepository;
    private final RegistroDeEmergenciaRepository registroDeEmergenciaRepository;

    public PacienteService(PacienteRepository pacienteRepository, CitaRepository citaRepository, RegistroDeEmergenciaRepository registroDeEmergenciaRepository) {
        this.pacienteRepository = pacienteRepository;
        this.CitaRepository = citaRepository;
        this.registroDeEmergenciaRepository = registroDeEmergenciaRepository;
    }

    public List<Paciente> getListaDePacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente getPacienteById(long id) {
        return pacienteRepository.findById(id).get();
    }

    //Post Methods

    public Paciente registrarPaciente(Paciente paciente,long cita_id) {

        Optional<Cita> cita = CitaRepository.findById(cita_id);

        if(!cita.isPresent()) {
            throw new IllegalArgumentException("Cita no encontrada");
        }

        Cita cita1 = cita.get();

        paciente.addCita(cita1);

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
    @Transactional
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

        pacienteRepository.save(paciente);
    }

    // Patch Methods

    public void anadirRegistroDeEmergencia(long paciente_id, long registroEmergencia_id) {

        Optional<RegistroDeEmergencia> registroDeEmergencia = registroDeEmergenciaRepository.findById(registroEmergencia_id);

        if(!registroDeEmergencia.isPresent()) {
            throw new IllegalArgumentException("Registro emergencia no existe.");
        }

        RegistroDeEmergencia registroDeEmergencia1 = registroDeEmergencia.get();

        Paciente paciente = pacienteRepository.findById(paciente_id).get();

        paciente.addRegistroEmergencia(registroDeEmergencia1);

        pacienteRepository.save(paciente);

    }




}
