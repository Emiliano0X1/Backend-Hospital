package org.example.hospital_backend.Expediente;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ExpedienteService {

    private final ExpedienteRepository expedienteRepository;

    public ExpedienteService(ExpedienteRepository expedienteRepository) {
        this.expedienteRepository = expedienteRepository;
    }

    public List<Expediente> getExpedientes() {
        return expedienteRepository.findAll();
    }

    public Expediente getExpedienteById(Long expedienteId) {
        return expedienteRepository.findById(expedienteId).get();
    }

    public Expediente crearExpediente(Expediente expediente) {
        return expedienteRepository.save(expediente);
    }

    public void eliminarExpediente(Long expedienteId) {

        boolean exists = expedienteRepository.existsById(expedienteId);

        if (!exists) {
            throw new IllegalArgumentException("Expediente no existe.");
        }

        expedienteRepository.deleteById(expedienteId);
    }

    @Transactional
    public void actualizarExpediente(Long expedienteId,Expediente newExpediente) {

        Expediente expediente = expedienteRepository.findById(expedienteId).orElseThrow(() -> new IllegalArgumentException("Expediente no existe."));

        if(!newExpediente.getHistorial().isEmpty() && Objects.equals(newExpediente.getHistorial(), expediente.getHistorial())) {
            expediente.setHistorial(newExpediente.getHistorial());
        }

        expedienteRepository.save(expediente);
    }
}
