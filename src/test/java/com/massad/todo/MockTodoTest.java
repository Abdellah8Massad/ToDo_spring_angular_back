package com.massad.todo;

import com.massad.todo.domaine.Tache;
import com.massad.todo.repository.TacheRepository;
import com.massad.todo.service.TacheService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockTodoTest {

    @Autowired
    private TacheService tacheService;

    @MockBean
    private TacheRepository tacheRepository;

    @Before
    public void setUp(){
        Tache t1 = new Tache();
        t1.setTitre("t1");t1.setMessage("M1");t1.setActivated(true);t1.setDescription("D1");
        Tache t2 = new Tache();
        t2.setTitre("t2");t2.setMessage("M2");t2.setActivated(true);t2.setDescription("D2");
        Tache t3 = new Tache();
        t3.setTitre("t3");t3.setMessage("M3");t3.setActivated(true);t3.setDescription("D3");
        List<Tache> tacheList = Stream.of(t1,t2,t3).collect(Collectors.toList());
        Mockito.when(tacheRepository.findAll()).thenReturn(tacheList);
    }

    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        List<Tache> tList = tacheService.getTaches();
        System.out.println("------------- Tache ------------------ " + tList.get(1).getTitre());
        assertThat(tList.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @EnumSource(Month.class)
    void getValueForAMonth_IsAlwaysBetweenOneAndTwelve(Month month) {
        int monthNumber = month.getValue();
        assertTrue(monthNumber >= 1 && monthNumber <= 12);
    }

}
