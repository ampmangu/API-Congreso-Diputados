package com.mangu.congreso_api.web.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.mangu.congreso_api.repository.VotacionRepository;
import java.math.BigInteger;
import java.util.Date;
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
@WebMvcTest(SearchController.class)
class SearchControllerTest {

  @MockBean
  private VotacionRepository votacionRepository;
  @Autowired
  MockMvc mockMvc;

  @Test
  void testFindSearch() throws Exception {

    Mockito.when(votacionRepository.findSearch(Mockito.anyString())).thenReturn(
        List.of(new TestTuple(
            new Object[]{BigInteger.valueOf(123L), "test", new Date(), "test", "test"}))
    );

    mockMvc.perform(get("/api/v2/search?textSearch=personas"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", Matchers.hasSize(1)))
        .andExpect(jsonPath("$[0].id", Matchers.is(123)))
        .andExpect(jsonPath("$[0].legislatura", Matchers.is("test")));
  }
}
