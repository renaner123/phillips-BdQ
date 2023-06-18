package com.phillips.saper.bancoquestoes.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.phillips.saper.bancoquestoes.dtos.SubjectRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.SubjectResponseDTO;
import com.phillips.saper.bancoquestoes.models.SubjectModel;
import com.phillips.saper.bancoquestoes.repositories.SubjectRepository;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
public class SubjectServiceTest {

    @TestConfiguration
    static class subjectSubjectServiceConfiguration {

        @Bean
        public SubjectService subjectService() {
            return new SubjectService();
        }
    }

    @Autowired
    SubjectService subjectService;

    @MockBean
    SubjectRepository subjectRepository;

    @Test
    public void shouldFindAllSubjects() {
        // Criação do objeto esperado
        SubjectModel subjectModel1 = new SubjectModel("any", 10, 1);
        SubjectModel subjectModel2 = new SubjectModel("anymore", 5, 2);
        List<SubjectModel> listSubjects = new ArrayList<>();
        listSubjects.add(subjectModel1);
        listSubjects.add(subjectModel2);

        // Simulação do comportamento do repositório
        Mockito.when(subjectRepository.findAll())
                .thenReturn((listSubjects));

        // Execução do método a ser testado
        assertThat(subjectRepository.findAll(), hasSize(2));
    }

    @Test
    public void shouldSaveDisciplineWithSuccess() {

        // Criação do objeto de requisição
        SubjectRequestDTO subjectRequest = new SubjectRequestDTO("any", 0, 1);

        // Criação do objeto esperado
        SubjectResponseDTO subjectExpectedModel = new SubjectResponseDTO("any", 0, 1);

        // Simulação do comportamento do repositório
        Mockito.when(subjectRepository.save(any(SubjectModel.class)))
                .thenAnswer(invocation -> {
                    SubjectModel subjectSave = invocation.getArgument(0);
                    subjectSave.setIdDiscipline(1); // Atribui um id fictício
                    return subjectSave;
                });

        // Execução do método a ser testado
        SubjectResponseDTO subjectSave = subjectService.save(subjectRequest).getBody();

        // Verificação do resultado
        assertThat(subjectSave, equalTo(subjectExpectedModel));
    }

    
    @Test
    public void shouldDeleteSubjectWithSuccess(){
    // Cria um objeto 
    SubjectModel subjectToDelete = new SubjectModel();
    subjectToDelete.setIdDiscipline(1);
    
    // Simulação do comportamento do repositório
    Mockito.when(subjectRepository.findById(1L)).thenReturn(Optional.of(subjectToDelete));
    
    // Chama o método deleteById do serviço
    subjectService.delete(1L);
    
    // Verifica se o método deleteById do repository foi chamado com o ID correto
    Mockito.verify(subjectRepository, times(1)).delete(subjectToDelete);
    }
    
}