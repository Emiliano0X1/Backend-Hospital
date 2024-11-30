package org.example.hospital_backend.Receta;

import org.example.hospital_backend.Paciente.Paciente;
import org.example.hospital_backend.Paciente.PacienteRepository;
import org.example.hospital_backend.Paciente.PacienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecetaService {

    private final RecetaRepository recetaRepository;
    private final PacienteRepository pacienteRepository;

    public RecetaService(RecetaRepository recetaRepository, PacienteRepository pacienteRepository) {
        this.recetaRepository = recetaRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public List<Receta> getRecetas() {
        return recetaRepository.findAll();
    }

    public Receta getRecetaById(long id) {
        return recetaRepository.findById(id).get();
    }

    public Receta addReceta(Receta receta, long paciente_id) {

        Optional<Paciente> paciente = pacienteRepository.findById(paciente_id);

        if(!paciente.isPresent()) {
            throw new IllegalArgumentException("El paciente no existe");
        }

        Paciente p = paciente.get();

        p.addReceta(receta);

        return recetaRepository.save(receta);
    }

    public void deleteReceta(long receta_id) {

        boolean exists = recetaRepository.existsById(receta_id);

        if (!exists) {
            throw new IllegalArgumentException("Receta with id " + receta_id + " does not exist");
        }

        recetaRepository.deleteById(receta_id);
    }


}
