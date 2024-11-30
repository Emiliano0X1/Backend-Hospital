package org.example.hospital_backend.Consultorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsultorioRepository extends JpaRepository<Consultorio, Long> {

    Optional<Consultorio> findById(long id);
}
