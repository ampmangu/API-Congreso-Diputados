package com.mangu.congreso_api.web.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.mangu.congreso_api.domain.VotoGrupo;
import com.mangu.congreso_api.repository.VotoGrupoRepository;
import java.time.LocalDate;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(GroupController.class)
class GroupControllerTest {

  @MockBean
  private VotoGrupoRepository votoGrupoRepository;

  @Autowired
  MockMvc mockMvc;

  @Test
  void testGetVotesByGroup() throws Exception {
    List<VotoGrupo> votoGrupoList = List.of(
        VotoGrupo.builder().grupo("PSOE").fecha(LocalDate.now()).id(2L).aFavor("0").enContra("2")
            .abstencion("1").build(),
        VotoGrupo.builder().grupo("PP").fecha(LocalDate.now()).id(1L).aFavor("2").enContra("0")
            .abstencion("1").build());

    Mockito.when(votoGrupoRepository.findAllByOrderByFecha()).thenReturn(votoGrupoList);
    mockMvc.perform(get("/api/v2/groups/byGroup?group=PP")).andExpect(status().isOk())
        .andExpect(jsonPath("$[0].grupo", Matchers.is("PP")))
    ;
  }

  @Test
  void testGetAllGroups() throws Exception {
    Mockito.when(votoGrupoRepository.findGrupoLegislatura()).thenReturn(
        List.of(new TestTuple(new Object[]{"XIV", "PP"}),
            new TestTuple(new Object[]{"XIV", "PSOE"}))
    );
    mockMvc.perform(get("/api/v2/groups")).andExpect(status().isOk())
        .andExpect(jsonPath("$[0].grupo", Matchers.is("PP")))
        .andExpect(jsonPath("$[0].legislatura", Matchers.is("XIV")))
        .andExpect(jsonPath("$[1].grupo", Matchers.is("PSOE")));
  }


}
