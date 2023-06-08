package com.phillips.saper.bancoquestoes.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.phillips.saper.bancoquestoes.dtos.MaterialResponseDTO;
import com.phillips.saper.bancoquestoes.dtos.QuestionRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.QuestionResponseDTO;
import com.phillips.saper.bancoquestoes.models.ClientModel;
import com.phillips.saper.bancoquestoes.models.QuestionModel;
import com.phillips.saper.bancoquestoes.repositories.ClientRepository;
import com.phillips.saper.bancoquestoes.repositories.MaterialRepository;
import com.phillips.saper.bancoquestoes.repositories.QuestionRepository;
import com.phillips.saper.bancoquestoes.repositories.RoleRepository;
import com.phillips.saper.bancoquestoes.repositories.StudentRepository;
import com.phillips.saper.bancoquestoes.repositories.TeacherRepository;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
public class QuestionServiceTest {

    @TestConfiguration
    static class questionTestQuestionConfiguration {

        @Bean
        public QuestionService questionService() {
            return new QuestionService();
        }
    }

    @Autowired
    QuestionService questionService;

    @MockBean
    private ModelMapper modelMapper;

    @MockBean
    QuestionRepository questionRepository;

    @MockBean
    TeacherRepository teacherRepository;

    @Test
    public void shouldReturnAllQuestions() {

        // Cria um objeto paginável com as configurações de paginação
        Pageable pageable = PageRequest.of(0, 10);

        QuestionModel questionModel1 = new QuestionModel("Porque", new ArrayList<String>(Arrays.asList("A", "B")), new ArrayList<String>(Arrays.asList("A", "B")), 0, 1L, 1L);
        QuestionModel questionModel2 = new QuestionModel("Porque não sabe", new ArrayList<String>(Arrays.asList("B", "C")), new ArrayList<String>(Arrays.asList("A", "B")), 0, 2L, 2L);
        List<QuestionModel> listQuestions = new ArrayList<>();
        listQuestions.add(questionModel1);
        listQuestions.add(questionModel2);

        // Simulação do comportamento do repositório
        when(questionRepository.findAll(pageable)).thenReturn(new PageImpl<>(listQuestions));

        // Execução do método a ser testado
        Page<QuestionResponseDTO> result = questionService.findAll(pageable);

        // Valida se tornou todos os elementos
        assertThat(result.getContent(), hasSize(2));

    }

    @Test
    public void shouldSaveQuestionWithSuccess(){

        // Criação do objeto de requisição
        QuestionRequestDTO questionRequest = new QuestionRequestDTO("Porque", new ArrayList<String>(Arrays.asList("A", "B")), 0, 0, 1L, 1L, null);
    
        // Criação do objeto esperado
        QuestionResponseDTO questionExpected = new QuestionResponseDTO();
        BeanUtils.copyProperties(questionRequest, questionExpected);
        questionExpected.setIdQuestion(1L);
    
        // Simulação do comportamento do repositório
        Mockito.when(questionRepository.save(any(QuestionModel.class)))
                .thenAnswer(invocation -> {
                    QuestionModel savedQuestion = invocation.getArgument(0);
                    savedQuestion.setIdQuestion(1L); // Atribui um id fictício    
                    return savedQuestion;
                });
    
        // Execução do método a ser testado
        QuestionResponseDTO savedQuestion = questionService.save(questionRequest).getBody();
    
        // Verificação do resultado
        assertThat(savedQuestion, equalTo(questionExpected));
    }
    
}
