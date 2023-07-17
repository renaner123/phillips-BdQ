package com.phillips.saper.bancoquestoes.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.phillips.saper.bancoquestoes.models.DisciplineModel;
import com.phillips.saper.bancoquestoes.repositories.DisciplineRepository;
import com.phillips.saper.bancoquestoes.services.DisciplineService;

@WebMvcTest(DisciplineController.class)
public class DisciplineControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    DisciplineService disciplineService;

    @MockBean
    DisciplineRepository disciplineRepository;

    @WithMockUser(value = "renan", password = "1234")
    @Test
    public void shouldFindAllDisciplines() throws Exception {
        DisciplineModel disciplineModel1 = new DisciplineModel(1L, "programacao", "Coisas de codar as coisas");
        DisciplineModel disciplineModel2 = new DisciplineModel(2L, "embarcado", "Coisas de embarcar as coisas");
        List<DisciplineModel> listDiscipline = new ArrayList<>();

        listDiscipline.add(disciplineModel1);
        listDiscipline.add(disciplineModel2);

        // Simulate the behavior of the service layer
        Mockito.when(disciplineService.findAll())
                .thenReturn(listDiscipline);

        MvcResult result = mockMvc.perform(get("/v1/disciplines")
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();

        assertEquals(responseBody, objectMapper.writeValueAsString(listDiscipline));
    }
}
