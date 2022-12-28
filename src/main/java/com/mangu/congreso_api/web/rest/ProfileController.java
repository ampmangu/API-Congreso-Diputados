package com.mangu.congreso_api.web.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.mangu.congreso_api.domain.VotosDetallado;
import com.mangu.congreso_api.domain.dto.ProfileDto;
import com.mangu.congreso_api.repository.VotacionRepository;
import com.mangu.congreso_api.repository.VotosDetalladoRepository;
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
public class ProfileController {

  private final VotosDetalladoRepository votosDetalladoRepository;
  private final VotacionRepository votacionRepository;

  public ProfileController(VotosDetalladoRepository votosDetalladoRepository,
      VotacionRepository votacionRepository) {
    this.votosDetalladoRepository = votosDetalladoRepository;
    this.votacionRepository = votacionRepository;
  }

  @PreAuthorize("isAuthenticated()")
  @GetMapping(value = "/profile", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<ProfileDto> getProfile(@RequestParam String name) {
    List<VotosDetallado> profileList = votosDetalladoRepository.findByDiputado(name);
    if (profileList.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    List<String> groups =
        profileList.stream().map(VotosDetallado::getGrupo).distinct().toList();
    List<String> legislatura = votacionRepository.findListLegislaturaByDiputado(name);
    return ResponseEntity.ok(new ProfileDto.Builder()
        .name(profileList.get(0).getDiputado()).withGroups(groups).withLegislaturas(legislatura)
        .build());

  }
}
