package com.mangu.congreso_api.repos;

import com.mangu.congreso_api.domain.VotosDetallado;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VotosDetalladoRepository extends JpaRepository<VotosDetallado, Long> {
}
