package com.mangu.congreso_api.repos;

import com.mangu.congreso_api.domain.Votacion;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VotacionRepository extends JpaRepository<Votacion, Long> {
}
