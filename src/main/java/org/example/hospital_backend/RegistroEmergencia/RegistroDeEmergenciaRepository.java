package org.example.hospital_backend.RegistroEmergencia;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroDeEmergenciaRepository extends JpaRepository<RegistroDeEmergencia, Long> {
}
