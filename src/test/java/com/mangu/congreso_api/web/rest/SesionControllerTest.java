package com.mangu.congreso_api.web.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.mangu.congreso_api.domain.Sesion;
import com.mangu.congreso_api.repository.SesionRepository;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SesionController.class)
class SesionControllerTest {

  @MockBean
  private SesionRepository sesionRepository;

  @Autowired
  MockMvc mockMvc;

  @Test
  void testSesionOk() throws Exception {
    List<Sesion> sesions = List.of(Sesion.builder().sesionNumber(123L).legislatura("XI").build(),
        Sesion.builder().sesionNumber(234L).legislatura("XIV").build());
    Page<Sesion> sesionPage = new PageImpl<>(sesions);
    Mockito.when(sesionRepository.findAll(Mockito.any(Pageable.class))).thenReturn(sesionPage);
    mockMvc.perform(get("/api/v2/sesions"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.content", Matchers.hasSize(2)))
        .andExpect(jsonPath("$.content[0].sesionNumber", Matchers.is(123)))
        .andExpect(jsonPath("$.content[1].sesionNumber", Matchers.is(234)));
  }
}
