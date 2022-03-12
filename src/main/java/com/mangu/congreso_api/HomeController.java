package com.mangu.congreso_api;

import com.mangu.congreso_api.domain.Sesion;
import com.mangu.congreso_api.repos.SesionRepository;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class HomeController {
    private final SesionRepository sesionService;

    public HomeController(SesionRepository sesionService) {
        this.sesionService = sesionService;
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Sesion>> index(@ParameterObject @PageableDefault(size = 50)
                                                  @SortDefault.SortDefaults({
                                                          @SortDefault(sort = "sesionNumber", direction = Sort.Direction.ASC)
                                                  }) Pageable pageable) {
        Page<Sesion> page = this.sesionService.findAll(pageable);
        return ResponseEntity.ok(page.getContent());
    }

}
