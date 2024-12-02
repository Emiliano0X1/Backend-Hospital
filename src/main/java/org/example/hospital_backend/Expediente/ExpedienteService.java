package org.example.hospital_backend.Expediente;

import jakarta.transaction.Transactional;
import org.example.hospital_backend.Paciente.Paciente;
import org.example.hospital_backend.Paciente.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ExpedienteService {

    private final ExpedienteRepository expedienteRepository;
    private final PacienteRepository pacienteRepository;

    public ExpedienteService(ExpedienteRepository expedienteRepository, PacienteRepository pacienteRepository) {
        this.expedienteRepository = expedienteRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public List<Expediente> getExpedientes() {
        return expedienteRepository.findAll();
    }

    public Expediente getExpedienteById(Long expedienteId) {
        return expedienteRepository.findById(expedienteId).get();
    }

    public Expediente crearExpediente(Expediente expediente,long paciente_Id) {

        Optional<Paciente> paciente = pacienteRepository.findById(paciente_Id);

        if(!paciente.isPresent()) {
            throw new IllegalArgumentException("El paciente no existe");
        }

        Paciente pace = paciente.get();

        if(pace.getExpediente() != null){
            throw new IllegalArgumentException("El expediente ya existe");
        }

        pace.setExpediente(expediente);

        return expedienteRepository.save(expediente);
    }

    public void eliminarExpediente(Long expedienteId) {

        boolean exists = expedienteRepository.existsById(expedienteId);

        if (!exists) {
            throw new IllegalArgumentException("Expediente no existe.");
        }

        expedienteRepository.deleteById(expedienteId);
    }


    public void actualizarExpediente(Long expedienteId,String historial) {

        Expediente expediente = expedienteRepository.findById(expedienteId).orElseThrow(() -> new IllegalArgumentException("El expediente no existe"));

        expediente.setHistorial(historial);

        expedienteRepository.save(expediente);
    }
}
