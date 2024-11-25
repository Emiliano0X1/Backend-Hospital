package org.example.hospital_backend.Receta;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecetaService {

    private final RecetaRepository recetaRepository;

    public RecetaService(RecetaRepository recetaRepository) {
        this.recetaRepository = recetaRepository;
    }

    public List<Receta> getRecetas() {
        return recetaRepository.findAll();
    }

    public Receta getRecetaById(long id) {
        return recetaRepository.findById(id).get();
    }

    public Receta addReceta(Receta receta) {
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
