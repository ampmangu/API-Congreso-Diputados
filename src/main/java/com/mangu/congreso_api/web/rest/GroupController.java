package com.mangu.congreso_api.web.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.mangu.congreso_api.domain.VotoGrupo;
import com.mangu.congreso_api.domain.dto.GroupDto;
import com.mangu.congreso_api.repository.VotoGrupoRepository;
import jakarta.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 4800)
@RestController
@RequestMapping("/api/v2")
public class GroupController {

  private final VotoGrupoRepository votoGrupoRepository;

  public GroupController(VotoGrupoRepository votoGrupoRepository) {
    this.votoGrupoRepository = votoGrupoRepository;
  }

  @PreAuthorize("isAuthenticated()")
  @GetMapping("/groups/byGroup")
  public ResponseEntity<List<VotoGrupo>> getVotesByGroup(@RequestParam String group) {
    List<VotoGrupo> collect = votoGrupoRepository.findAllByOrderByFecha().stream()
        .filter(votoGrupo -> votoGrupo.getGrupo().replaceAll("\\s", "").equalsIgnoreCase(group))
        .toList();
    return ResponseEntity.ok(collect);
  }

  @PreAuthorize("isAuthenticated()")
  @GetMapping(value = "/groups", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<List<GroupDto>> getGroups() {
    List<GroupDto> results = new ArrayList<>();

    List<Tuple> all = votoGrupoRepository.findGrupoLegislatura();
    all.forEach(group -> results.add(
        new GroupDto.Builder()
            .legislatura(group.get(0, String.class))
            .grupo(group.get(1, String.class))
            .build()
    ));
    return ResponseEntity.ok(results);
  }
}
