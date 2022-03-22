package com.mangu.congreso_api.web.rest;

import com.mangu.congreso_api.domain.dto.DateDto;
import com.mangu.congreso_api.repos.FechasViewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v2")
public class DateController {
    private static final int DEFAULT_PAGE_SIZE = 50;

    private final Logger logger = LoggerFactory.getLogger(DateController.class);

    private final FechasViewRepository fechasViewRepository;

    public DateController(FechasViewRepository fechasViewRepository) {
        this.fechasViewRepository = fechasViewRepository;
    }

    @GetMapping("/dates")
    public ResponseEntity<List<DateDto>> getAllDates() {
        return ResponseEntity.ok(
                this.fechasViewRepository.findAll().stream().map(f ->
                                new DateDto.Builder().date(f.getFecha().toString()).legislatura(f.getLegislatura()).build())
                        .collect(Collectors.toList()));
    }
}
