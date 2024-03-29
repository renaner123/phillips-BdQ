package com.phillips.saper.bancoquestoes.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.phillips.saper.bancoquestoes.dtos.QuestionRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.QuestionResponseDTO;
import com.phillips.saper.bancoquestoes.enums.CertifiedValues;
import com.phillips.saper.bancoquestoes.models.QuestionModel;
import com.phillips.saper.bancoquestoes.repositories.QuestionRepository;
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
    public void shouldsaveTeacherWithSuccess(){

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

    @Test
    public void shouldDeleteQuestionWithSuccess(){        
        // Cria um objeto QuestionModel com ID 1
        QuestionModel questionToDelete = new QuestionModel();
        questionToDelete.setIdQuestion(1L);

        // Simulação do comportamento do repositório
        Mockito.when(questionRepository.findById(1L)).thenReturn(Optional.of(questionToDelete));
        
        // Chama o método deleteById do serviço
        questionService.delete(1L);
        
        // Verifica se o método deleteById do repository foi chamado com o ID correto
        Mockito.verify(questionRepository, times(1)).delete(questionToDelete);
    }

    @Test
    public void shouldReturnTotalQuestionInDatabase(){

    long totalQuestions = 10L;

    Mockito.when(questionRepository.count()).thenReturn(totalQuestions);

    assertEquals(questionService.countQuestions(), totalQuestions);

    }

    @Test
    public void shouldReturnAllQuestionsWithCertifedTrue(){
        QuestionModel questionModel1 = new QuestionModel();
        QuestionModel questionModel2 = new QuestionModel();
        questionModel1.setCertified(true);
        questionModel2.setCertified(true);

        List<QuestionModel> listQuestions = new ArrayList<>();
        listQuestions.add(questionModel1);
        listQuestions.add(questionModel2);

        Mockito.when(questionRepository.findByCertifiedTrue()).thenReturn(listQuestions);

        assertThat(questionService.findByCertifiedTrue().getBody(), hasSize(2));
        //assertThat(questionService.findByCertifiedTrue().getBody(), equalTo(listQuestions));
    }

    @Test
    public void shouldReturnAllQuestionsWithCertifedFalse(){
        QuestionModel questionModel1 = new QuestionModel();
        QuestionModel questionModel2 = new QuestionModel();
        questionModel1.setCertified(false);
        questionModel2.setCertified(false);

        List<QuestionModel> listQuestions = new ArrayList<>();
        listQuestions.add(questionModel1);
        listQuestions.add(questionModel2);

        Mockito.when(questionRepository.findByCertifiedFalse()).thenReturn(listQuestions);

        assertThat(questionService.findByCertified(CertifiedValues.FALSE).getBody(), hasSize(2));
        //assertThat(questionService.findByCertifiedTrue().getBody(), equalTo(listQuestions));
    }

    @Test
    public void shouldReturnAllQuestionsWithCertifedNull(){
        QuestionModel questionModel1 = new QuestionModel();
        QuestionModel questionModel2 = new QuestionModel();

        List<QuestionModel> listQuestions = new ArrayList<>();
        listQuestions.add(questionModel1);
        listQuestions.add(questionModel2);

        Mockito.when(questionRepository.findByCertifiedIsNull()).thenReturn(listQuestions);

        assertThat(questionService.findByCertified(CertifiedValues.NULL).getBody(), hasSize(2));
        //assertThat(questionService.findByCertifiedTrue().getBody(), equalTo(listQuestions));
    }

    @Test
    public void shouldUpdateQuestionTagWithSuccess() throws IOException {
        // Criação do objeto de requisição
        String tag = "aloan";
        Long idQuestion = 1L;

        // Criação da question esperada como resposta
        QuestionModel questionExpectd = new QuestionModel();
        questionExpectd.setTag(tag);

        QuestionResponseDTO questionResponseDTO = new QuestionResponseDTO();
        BeanUtils.copyProperties(questionExpectd, questionResponseDTO);

        // Simulação do comportamento dos repositórios
        Mockito.when(questionRepository.save(any(QuestionModel.class)))
                .thenAnswer(invocation -> {
                    QuestionModel saveTeacher = invocation.getArgument(0);
                    saveTeacher.setIdQuestion(idQuestion); // Atribui um id fictício
                    saveTeacher.setTag(tag);
                    return saveTeacher;
                });
        Mockito.when(questionRepository.findById(idQuestion)).thenReturn(Optional.of(questionExpectd));

        // Execução do método a ser testado
        QuestionResponseDTO updateCertifiedMaterial = questionService.updateTag(idQuestion, tag).getBody();

        // Verificação do resultado
        assertThat(updateCertifiedMaterial.getTag(), equalTo(questionResponseDTO.getTag()));  
    }

    @Test
    public void shouldUpdateQuestionCertifiedWithSuccess() throws IOException {
        // Criação do objeto de requisição
        boolean certified = true;
        Long idQuestion = 1L;

        // Criação da question esperada como resposta
        QuestionModel questionExpectd = new QuestionModel();
        questionExpectd.setCertified(certified);

        QuestionResponseDTO questionResponseDTO = new QuestionResponseDTO();
        BeanUtils.copyProperties(questionExpectd, questionResponseDTO);

        // Simulação do comportamento dos repositórios
        Mockito.when(questionRepository.save(any(QuestionModel.class)))
                .thenAnswer(invocation -> {
                    QuestionModel saveTeacher = invocation.getArgument(0);
                    saveTeacher.setIdQuestion(idQuestion); // Atribui um id fictício
                    saveTeacher.setCertified(certified);
                    return saveTeacher;
                });
        Mockito.when(questionRepository.findById(idQuestion)).thenReturn(Optional.of(questionExpectd));

        // Execução do método a ser testado
        QuestionResponseDTO updateCertifiedMaterial = questionService.updateCertified(idQuestion, certified).getBody();

        // Verificação do resultado
        assertThat(updateCertifiedMaterial.getCertified(), equalTo(questionResponseDTO.getCertified()));  
    }

    @Test
    public void shouldReturnAllQuestionByIdDisciplineAndIdSubjectWithSuccess(){
        // Criação do objeto de requisição
        long idDiscipline = 1L;
        long idSubject = 1L;

        // Criaça do objeto esperado
        QuestionModel questionModel1 = new QuestionModel("", null, null, 0, idSubject, idSubject);
        QuestionModel questionModel2 = new QuestionModel("", null, null, 0, idSubject, idSubject);

        List<QuestionModel> listQuestion = new ArrayList<>();
        listQuestion.add(questionModel1);
        listQuestion.add(questionModel2);

        // Simulação do comportamento do repositório
        Mockito.when(questionRepository.findByIdDisciplineAndIdSubjectAndCertifiedTrue(idDiscipline, idSubject)).thenReturn(listQuestion);

        // Verificação do resultado
        assertThat(questionService.findByidDisciplineAndidSubject(idDiscipline, idSubject).getBody(), hasSize(2));  
    }  

    @Test
    public void shouldReturnAllQuestionByTagWithSuccess(){

        // Criação do objeto de requisição
        String tag = "aloan";

        // Criaça do objeto esperado
        QuestionModel questionModel1 = new QuestionModel();
        QuestionModel questionModel2 = new QuestionModel();
        questionModel1.setTag(tag);
        questionModel2.setTag(tag);

        List<QuestionModel> listQuestion = new ArrayList<>();
        listQuestion.add(questionModel1);
        listQuestion.add(questionModel2);

        // Simulação do comportamento do repositório
        Mockito.when(questionRepository.findByTag(tag)).thenReturn(listQuestion);
        
        // Verificação do resultado
        assertThat(questionService.findByTag(tag).getBody(), hasSize(2));  
    }  
}
