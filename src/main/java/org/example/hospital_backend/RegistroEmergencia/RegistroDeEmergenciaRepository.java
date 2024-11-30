package org.example.hospital_backend.RegistroEmergencia;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistroDeEmergenciaRepository extends JpaRepository<RegistroDeEmergencia, Long> {

    Optional<RegistroDeEmergencia> findById(Long id);
}
