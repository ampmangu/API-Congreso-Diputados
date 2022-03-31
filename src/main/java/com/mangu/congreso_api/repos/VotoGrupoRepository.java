package com.mangu.congreso_api.repos;

import com.mangu.congreso_api.domain.VotoGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Tuple;
import java.util.List;

public interface VotoGrupoRepository extends JpaRepository<VotoGrupo, Long> {
    List<VotoGrupo> findAllByOrderByFecha();

    @Query(value = "select distinct v.legislatura, vr.grupo from votacion v inner join votos_resumido vr on v.id = vr.votacion_id order by legislatura desc;", nativeQuery = true)
    List<Tuple> findGrupoLegislatura();
}
