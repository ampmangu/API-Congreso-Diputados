package com.mangu.congreso_api.repos;

import com.mangu.congreso_api.domain.Votacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Tuple;
import java.time.LocalDate;
import java.util.List;


public interface VotacionRepository extends JpaRepository<Votacion, Long> {
    List<Votacion> findByFecha(LocalDate fecha);

    @Query(value = "select v.id as id, v.legislatura as legislatura, v.fecha as fecha, v.titulo as titulo, v.textoexpediente as textoexpediente from votacion v where v.textoexpediente like %:search% or v.titulo like %:search% order by fecha desc", nativeQuery = true)
    List<Tuple> findSearch(@Param("search") String search);
}
