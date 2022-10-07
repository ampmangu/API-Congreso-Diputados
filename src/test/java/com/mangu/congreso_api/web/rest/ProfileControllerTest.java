package com.mangu.congreso_api.web.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.mangu.congreso_api.domain.Votacion;
import com.mangu.congreso_api.domain.VotosDetallado;
import com.mangu.congreso_api.repository.VotacionRepository;
import com.mangu.congreso_api.repository.VotosDetalladoRepository;
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
@WebMvcTest(ProfileController.class)
class ProfileControllerTest {

  @MockBean
  private VotosDetalladoRepository votosDetalladoRepository;

  @MockBean
  private VotacionRepository votacionRepository;

  @Autowired
  MockMvc mockMvc;

  @WithMockUser(value = "admin")
  @Test
  void testGetProfile() throws Exception {
    Mockito.when(votosDetalladoRepository.findByDiputado(Mockito.anyString()))
        .thenReturn(List.of(VotosDetallado.builder().diputado("Garzon Ruiz, Alberto")
            .asiento(123)
            .votacion(Votacion.builder().build())
            .voto("SI")
            .grupo("UP")
            .build()
        ));
    Mockito.when(votacionRepository.findListLegislaturaByDiputado(Mockito.anyString()))
        .thenReturn(List.of("XIV", "XIII", "XII"));
    mockMvc.perform(get("/api/v2/profile?name=garzon")).andExpect(status().isOk())
        .andExpect(jsonPath("$.nameAndSurname", Matchers.is("Garzon Ruiz, Alberto")))
        .andExpect(jsonPath("$.legislaturas", Matchers.is(List.of("XIV", "XIII", "XII"))));
  }

}
