package com.mangu.congreso_api.repos;

import com.mangu.congreso_api.domain.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SesionRepository extends JpaRepository<Sesion, Integer> {
}
