package com.massad.todo;

import com.massad.todo.controller.TacheController;
import com.massad.todo.domaine.Tache;
import com.massad.todo.service.TacheService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class MockWebServiceTest {

    private MockMvc mockMvc;

    @Mock
    private TacheService tacheService;

    @InjectMocks
    private TacheController tacheController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(tacheController)
                .build();
    }

    @Test
    public void givenEmployees_whenGetEmployees_thenStatus200()
            throws Exception {

        Tache t1 = new Tache();
        t1.setTitre("t1");t1.setMessage("M1");t1.setActivated(true);t1.setDescription("D1");
        Tache t2 = new Tache();
        t2.setTitre("t2");t2.setMessage("M2");t2.setActivated(true);t2.setDescription("D2");
        Tache t3 = new Tache();
        t3.setTitre("t3");t3.setMessage("M3");t3.setActivated(true);t3.setDescription("D3");
        List<Tache> tacheList = Stream.of(t1,t2,t3).collect(Collectors.toList());

        when(tacheService.getTaches()).thenReturn(tacheList);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/tache")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", Matchers.hasSize(3)));
    }
}
