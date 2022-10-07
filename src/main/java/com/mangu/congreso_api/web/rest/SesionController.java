package com.mangu.congreso_api.web.rest;

import com.mangu.congreso_api.domain.Sesion;
import com.mangu.congreso_api.repository.SesionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 4800)
@RestController
@RequestMapping("/api/v2")
public class SesionController {

  private static final int DEFAULT_PAGE_SIZE = 50;

  private final SesionRepository sesionRepository;
  private final Logger logger = LoggerFactory.getLogger(SesionController.class);

  public SesionController(SesionRepository sesionRepository) {
    this.sesionRepository = sesionRepository;
  }

  @GetMapping("/sesions")
  @PreAuthorize("isAuthenticated()")
  public ResponseEntity<Page<Sesion>> getAllSesions(
      @ParameterObject @PageableDefault(size = DEFAULT_PAGE_SIZE)
      @SortDefault.SortDefaults({
          @SortDefault(sort = "sesionNumber", direction = Sort.Direction.ASC)
      }) Pageable pageable) {
    Page<Sesion> page = sesionRepository.findAll(pageable);
    return ResponseEntity.ok().body(page);
  }
}
