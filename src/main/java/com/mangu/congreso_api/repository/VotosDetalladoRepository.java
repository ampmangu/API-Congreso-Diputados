package com.mangu.congreso_api.repository;

import com.mangu.congreso_api.domain.VotosDetallado;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VotosDetalladoRepository extends JpaRepository<VotosDetallado, Long> {

  List<VotosDetallado> findByDiputado(String diputado);
}
