package com.mangu.congreso_api.web.rest;

import com.mangu.congreso_api.domain.Votacion;
import com.mangu.congreso_api.repos.VotacionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v2")
public class VotesController {
    private final VotacionRepository votacionRepository;

    public VotesController(VotacionRepository votacionRepository) {
        this.votacionRepository = votacionRepository;
    }

    @GetMapping(value = "/votes/byDate", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Votacion>> getVotesByDate(@RequestParam String date) {
        List<Votacion> byFecha = votacionRepository
                .findByFecha(LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return ResponseEntity.ok(
                byFecha.stream()
                        .filter(votacion -> votacion.getVotacionVotosResumidos() != null && !votacion.getVotacionVotosResumidos().isEmpty())
                        .collect(Collectors.toList()));
    }

    @GetMapping(value = "/votes/byId", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Votacion> getVotesById(@RequestParam String id) {
        Optional<Votacion> byId = votacionRepository.findById(Long.parseLong(id));
        return ResponseEntity.of(byId);
    }
}
