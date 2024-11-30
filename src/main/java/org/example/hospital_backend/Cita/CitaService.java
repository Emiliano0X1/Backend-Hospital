package org.example.hospital_backend.Cita;

import org.example.hospital_backend.Consultorio.Consultorio;
import org.example.hospital_backend.Consultorio.ConsultorioRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    private final CitaRepository citaRepository;
    private final ConsultorioRepository consultorioRepository;

    public CitaService(CitaRepository citaRepository, ConsultorioRepository consultorioRepository) {
        this.citaRepository = citaRepository;
        this.consultorioRepository = consultorioRepository;
    }

    //Get methods

    public List<Cita> getAllCitas() {
        return citaRepository.findAll();
    }

    public Cita getCitaById(long id) {
        return citaRepository.findById(id).get();
    }

    //Post Methods

    public Cita agendarCita(Cita cita,Long consultorio_id) {

        if(consultorio_id != null) {
            Optional<Consultorio> consultorio = consultorioRepository.findById(consultorio_id);

            if (consultorio.isPresent()) {
                Consultorio consul = consultorio.get();

                consul.setDisponible(false);

                cita.setConsultorio(consul);
            }

            else{
                throw new IllegalArgumentException("El consultorio no existe");
            }

        }

        return citaRepository.save(cita);
    }

    //Delete Methods

    public void borrarCita(long cita_id) {

        boolean exists = citaRepository.existsById(cita_id);

        if(!exists){
            throw new IllegalArgumentException("No existe esa cita");
        }

        citaRepository.deleteById(cita_id);
    }


    //Put Mehthods

    public void modificarFecha(long cita_id, Date fecha) {

        Cita cita = citaRepository.findById(cita_id).orElseThrow(() -> new IllegalArgumentException("No existe esa cita"));

        cita.setFecha(fecha);

        citaRepository.save(cita);
    }
}
