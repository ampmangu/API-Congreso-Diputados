package com.mangu.congreso_api.repos;

import com.mangu.congreso_api.domain.Sesion;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface SesionRepository extends PagingAndSortingRepository<Sesion, Integer> {
}
