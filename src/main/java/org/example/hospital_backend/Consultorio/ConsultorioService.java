package org.example.hospital_backend.Consultorio;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ConsultorioService {

    private final ConsultorioRepository consultorioRepository;

    public ConsultorioService(ConsultorioRepository consultorioRepository) {
        this.consultorioRepository = consultorioRepository;
    }

    public List<Consultorio> getAllConsultorios() {
        return consultorioRepository.findAll();
    }

    public Consultorio getConsultorioById(long id) {
        return consultorioRepository.findById(id).get();
    }

    public Consultorio crearConsultorio(Consultorio consultorio) {
        return consultorioRepository.save(consultorio);
    }

    public void eliminarConsultorio(long consultorio_id) {

        boolean exists = consultorioRepository.existsById(consultorio_id);

        if (!exists) {
            throw new IllegalArgumentException("Consultorio no existe.");
        }

        consultorioRepository.deleteById(consultorio_id);
    }

    public void actualizarConsultorio(long consultorioId, Consultorio newConsultorio) {

        Consultorio consultorio = consultorioRepository.findById(consultorioId).orElseThrow(() -> new IllegalArgumentException("Consultorio no existe."));

        if(!newConsultorio.getNombre().isEmpty() && !Objects.equals(newConsultorio.getNombre(), consultorio.getNombre())) {
            consultorio.setNombre(newConsultorio.getNombre());
        }

        if(!newConsultorio.isDisponible() && !Objects.equals(newConsultorio.isDisponible(), consultorio.isDisponible())) {
            consultorio.setDisponible(newConsultorio.isDisponible());
        }

        consultorioRepository.save(consultorio);
    }

}
