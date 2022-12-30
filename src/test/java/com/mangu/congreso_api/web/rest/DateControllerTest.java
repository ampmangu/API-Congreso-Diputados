package com.mangu.congreso_api.web.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.mangu.congreso_api.domain.FechasView;
import com.mangu.congreso_api.repository.FechasViewRepository;
import java.time.LocalDate;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(DateController.class)
class DateControllerTest {

  @MockBean
  private FechasViewRepository fechasViewRepository;

  @Autowired
  MockMvc mockMvc;

  @WithMockUser(value = "admin")
  @Test
  void testGetAllDates() throws Exception {
    List<FechasView> fechasViewList = List.of(FechasView.builder()
            .fecha(LocalDate.now())
            .id("1")
            .legislatura("XIII")
            .build(),
        FechasView.builder().id("2").fecha(LocalDate.now().minusDays(1L)).legislatura("XIV")
            .build());
    Mockito.when(fechasViewRepository.findAll()).thenReturn(fechasViewList);
    mockMvc.perform(get("/api/v2/dates/")).andExpect(status().isOk())
        .andExpect(jsonPath("$[0].legislatura", Matchers.is("XIII")))
        .andExpect(jsonPath("$[1].legislatura", Matchers.is("XIV")))
    ;
  }

  @WithMockUser(value = "admin")
  @Test
  void testGetAllDatesByLegislatura() throws Exception {
    List<FechasView> fechasViewList = List.of(
        FechasView.builder().id("2").fecha(LocalDate.now().minusDays(1L)).legislatura("XIV")
            .build()
        , FechasView.builder().legislatura("XIV").id("3").fecha(LocalDate.now().minusDays(1))
            .build());
    Mockito.when(fechasViewRepository.findByLegislatura(any())).thenReturn(fechasViewList);
    mockMvc.perform(get("/api/v2/dates?legislatura=XIV")).andExpect(status().isOk())
        .andExpect(jsonPath("$[0].legislatura", Matchers.is("XIV")));
  }
}
