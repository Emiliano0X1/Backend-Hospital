package org.example.hospital_backend.RegistroEmergencia;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroDeEmergenciaService {

    private final RegistroDeEmergenciaRepository registroDeEmergenciaRepository;

    public RegistroDeEmergenciaService(RegistroDeEmergenciaRepository registroDeEmergenciaRepository) {
        this.registroDeEmergenciaRepository = registroDeEmergenciaRepository;
    }

    public List<RegistroDeEmergencia> getEmergencias(){
        return registroDeEmergenciaRepository.findAll();
    }
}
