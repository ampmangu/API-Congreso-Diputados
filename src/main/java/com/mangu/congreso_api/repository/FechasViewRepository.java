package com.mangu.congreso_api.repository;

import com.mangu.congreso_api.domain.FechasView;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FechasViewRepository extends JpaRepository<FechasView, Long> {

  List<FechasView> findByLegislatura(String legislatura);
}
