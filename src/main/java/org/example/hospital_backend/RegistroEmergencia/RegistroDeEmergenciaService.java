package org.example.hospital_backend.RegistroEmergencia;

import org.example.hospital_backend.Consultorio.Consultorio;
import org.example.hospital_backend.Consultorio.ConsultorioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public RegistroDeEmergencia crearRegistroEmergencia(RegistroDeEmergencia registroDeEmergencia, Long consultorio_id){


        if(consultorio_id != null){

            Optional<Consultorio> consultorio = consultorioRepository.findById(consultorio_id);

            if(consultorio.isPresent()){

                Consultorio consultorioAux = consultorio.get();

                if(!consultorioAux.isDisponible()){
                    throw new IllegalArgumentException("El consultorio no esta disponible");
                }

                consultorioAux.setDisponible(false);
                registroDeEmergencia.setConsultorio(consultorioAux);
            }

            else{
                throw new IllegalArgumentException("No existe el consultorio");
            }
        }

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
