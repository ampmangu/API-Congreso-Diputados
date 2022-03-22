package com.mangu.congreso_api.repos;

import com.mangu.congreso_api.domain.Votacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;


public interface VotacionRepository extends JpaRepository<Votacion, Long> {
    List<Votacion> findByFecha(LocalDate fecha);
}
