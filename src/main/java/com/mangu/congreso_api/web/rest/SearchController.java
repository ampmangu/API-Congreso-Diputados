package com.mangu.congreso_api.web.rest;

import com.mangu.congreso_api.domain.dto.ResultDto;
import com.mangu.congreso_api.repos.VotacionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Tuple;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class SearchController {


    private VotacionRepository votacionRepository;


    public SearchController(VotacionRepository votacionRepository) {
        this.votacionRepository = votacionRepository;
    }


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
