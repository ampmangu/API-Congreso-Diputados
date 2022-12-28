package com.mangu.congreso_api.web.rest;

import com.mangu.congreso_api.domain.dto.DateDto;
import com.mangu.congreso_api.repository.FechasViewRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 4800)
@RestController
@RequestMapping("/api/v2")
public class DateController {

  private final Logger logger = LoggerFactory.getLogger(DateController.class);

  private final FechasViewRepository fechasViewRepository;

  public DateController(FechasViewRepository fechasViewRepository) {
    this.fechasViewRepository = fechasViewRepository;
  }

  @PreAuthorize("isAuthenticated()")
  @GetMapping("/dates")
  public ResponseEntity<List<DateDto>> getAllDates() {
    return ResponseEntity.ok(
        this.fechasViewRepository.findAll().stream().map(f ->
                new DateDto.Builder().date(f.getFecha().toString()).legislatura(f.getLegislatura())
                    .build())
            .toList());
  }
}
