package com.mangu.congreso_api.repos;

import com.mangu.congreso_api.domain.VotoGrupo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VotoGrupoRepository extends JpaRepository<VotoGrupo, Long> {
    public List<VotoGrupo> findAllByOrderByFecha();

}
