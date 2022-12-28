package com.mangu.congreso_api.repository;

import com.mangu.congreso_api.domain.Votacion;
import jakarta.persistence.Tuple;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface VotacionRepository extends JpaRepository<Votacion, Long> {

  List<Votacion> findByFecha(LocalDate fecha);

  @Query(value = "select v.id as id, v.legislatura as legislatura, v.fecha as fecha, v.titulo as titulo, v.textoexpediente as textoexpediente from votacion v where v.textoexpediente like %:search% or v.titulo like %:search% order by fecha desc", nativeQuery = true)
  List<Tuple> findSearch(@Param("search") String search);

  @Query(value = "select distinct(vd.diputado) as diputado, vd.grupo as grupo, v.legislatura as legislatura from votacion v inner join votos_detallado vd on v.id = vd.votacion_id", nativeQuery = true)
  List<Tuple> findMembers();

  @Query(value = "select distinct(v.legislatura) from votacion v join votos_detallado vd on vd.votacion_id = v.id where vd.diputado = :diputado", nativeQuery = true)
  List<String> findListLegislaturaByDiputado(@Param("diputado") String diputado);
}
