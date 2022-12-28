package com.mangu.congreso_api.web.rest;

import com.mangu.congreso_api.domain.dto.ResultDto;
import com.mangu.congreso_api.repository.VotacionRepository;
import jakarta.persistence.Tuple;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
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
public class SearchController {


  private final VotacionRepository votacionRepository;


  public SearchController(VotacionRepository votacionRepository) {
    this.votacionRepository = votacionRepository;
  }

  @PreAuthorize("isAuthenticated()")
  @GetMapping("/search")
  public ResponseEntity<List<ResultDto>> getSearchResults(@RequestParam String textSearch) {
    List<ResultDto> results = new ArrayList<>();
    List<Tuple> all = votacionRepository.findSearch(textSearch);
    all.forEach(iVotacion -> results.add(new ResultDto.Builder()
        .id(iVotacion.get(0, BigInteger.class).longValue())
        .legislatura(iVotacion.get(1, String.class))
        .fecha(iVotacion.get(2, Date.class).toString())
        .titulo(iVotacion.get(3, String.class))
        .textoexpediente(iVotacion.get(4, String.class))
        .build()));
    return ResponseEntity.ok(results);
  }

}
