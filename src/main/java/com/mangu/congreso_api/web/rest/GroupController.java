package com.mangu.congreso_api.web.rest;

import com.mangu.congreso_api.domain.VotoGrupo;
import com.mangu.congreso_api.repos.VotoGrupoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v2")
public class GroupController {
    private final VotoGrupoRepository votoGrupoRepository;

    public GroupController(VotoGrupoRepository votoGrupoRepository) {
        this.votoGrupoRepository = votoGrupoRepository;
    }

    @GetMapping("/groups/byGroup")
    public ResponseEntity<List<VotoGrupo>> getVotesByGroup(@RequestParam String group) {
        List<VotoGrupo> collect = votoGrupoRepository.findAll().stream().filter(votoGrupo -> votoGrupo.getGrupo().replaceAll("\\s", "").equalsIgnoreCase(group)).collect(Collectors.toList());
        return ResponseEntity.ok(collect);
    }
}
