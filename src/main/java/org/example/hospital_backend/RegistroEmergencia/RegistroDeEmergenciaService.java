package org.example.hospital_backend.RegistroEmergencia;

import org.example.hospital_backend.Consultorio.ConsultorioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroDeEmergenciaService {

    private final RegistroDeEmergenciaRepository registroDeEmergenciaRepository;
    private final ConsultorioRepository consultorioRepository;

    public RegistroDeEmergenciaService(RegistroDeEmergenciaRepository registroDeEmergenciaRepository, ConsultorioRepository consultorioRepository) {
        this.registroDeEmergenciaRepository = registroDeEmergenciaRepository;
        this.consultorioRepository = consultorioRepository;
    }

    //Get Methods

    public List<RegistroDeEmergencia> getEmergencias(){
        return registroDeEmergenciaRepository.findAll();
    }

    public RegistroDeEmergencia getRegistroDeEmergenciaById(long registroDeEmergenciaId){
        return registroDeEmergenciaRepository.findById(registroDeEmergenciaId).get();
    }


    //Post Methods

    public RegistroDeEmergencia crearRegistroEmergencia(RegistroDeEmergencia registroDeEmergencia){
        return registroDeEmergenciaRepository.save(registroDeEmergencia);
    }

    //Delete methods

    public void borrarRegistroDeEmergencia(Long registroDeEmergenciaId){

        boolean exist = registroDeEmergenciaRepository.existsById(registroDeEmergenciaId);

        if(!exist){
            throw new IllegalArgumentException("Registro de emergencia no existe");
        }

        registroDeEmergenciaRepository.deleteById(registroDeEmergenciaId);
    }




}
