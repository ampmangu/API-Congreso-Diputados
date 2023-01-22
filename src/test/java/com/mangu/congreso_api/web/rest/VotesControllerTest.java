package com.mangu.congreso_api.web.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.mangu.congreso_api.domain.Votacion;
import com.mangu.congreso_api.domain.VotosResumido;
import com.mangu.congreso_api.repository.VotacionRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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
@WebMvcTest(VotesController.class)
class VotesControllerTest {

  @MockBean
  private VotacionRepository votacionRepository;

  @Autowired
  MockMvc mockMvc;

  @WithMockUser(value = "admin")
  @Test
  void testFindAllByDate() throws Exception {
    List<Votacion> results = List.of(Votacion.builder()
        .id(12345L)
        .fecha(LocalDate.parse("2013-04-18"))
        .votacionVotosResumidos(Set.of(new VotosResumido()))
        .build());
    Mockito.when(votacionRepository.findByFecha(Mockito.any())).thenReturn(results);
    mockMvc.perform(get("/api/v2/votes/byDate?date=2013-04-18"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", Matchers.hasSize(1)))
        .andExpect(jsonPath("$[0].id", Matchers.is(12345)))
        .andExpect(jsonPath("$[0].fecha", Matchers.containsString("2013-04-18")))
    ;
  }

  @WithMockUser(value = "admin")
  @Test
  void testFindById() throws Exception {
    Votacion votacion = Votacion.builder()
        .id(12345L)
        .fecha(LocalDate.parse("2013-04-18"))
        .votacionVotosResumidos(Set.of(new VotosResumido()))
        .build();
    Mockito.when(votacionRepository.findById(Mockito.any())).thenReturn(Optional.of(votacion));
    mockMvc.perform(get("/api/v2/votes/byId?id=12345"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id", Matchers.is(12345)))
        .andExpect(jsonPath("$.fecha", Matchers.containsString("2013-04-18")));

  }

  @WithMockUser(value = "admin")
  @Test
  void testFindMembers() throws Exception{
    Mockito.when(votacionRepository.findMembers()).thenReturn(
        List.of(new TestTuple(new Object[]{"Abad Pérez, Juan Antonio", "GP", "X"}),
            new TestTuple(new Object[]{"Ábalos Meco, José Luis",	"GS", "X, XI, XII, XIII, XIV"}))
    );
    mockMvc.perform(get("/api/v2/votes/members"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", Matchers.hasSize(2)));
  }
}
