package org.example.hospital_backend.Cita;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CitaService {

    private final CitaRepository citaRepository;

    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    //Get methods

    public List<Cita> getAllCitas() {
        return citaRepository.findAll();
    }

    public Cita getCitaById(long id) {
        return citaRepository.findById(id).get();
    }

    //Post Methods

    public Cita agendarCita(Cita cita) {
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

    public void modificarFecha(long cita_id, Date fecha){

        Cita cita = citaRepository.findById(cita_id).orElseThrow(()-> new IllegalArgumentException("No existe esa cita"));

        citaRepository.save(cita);
    }
}
