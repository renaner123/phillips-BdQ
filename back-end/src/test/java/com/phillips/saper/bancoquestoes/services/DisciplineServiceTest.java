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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.phillips.saper.bancoquestoes.dtos.DisciplineRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.DisciplineResponseDTO;
import com.phillips.saper.bancoquestoes.models.DisciplineModel;
import com.phillips.saper.bancoquestoes.repositories.DisciplineRepository;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
public class DisciplineServiceTest {

    @TestConfiguration
    static class disciplineTestDisciplineConfiguration {

        @Bean
        public DisciplineService disciplineService(){
            return new DisciplineService();
        }
    }

    @Autowired
    DisciplineService disciplineService;

    @MockBean
    DisciplineRepository disciplineRepository;

    @Test
    public void disciplineTestService_FindAll(){
        // Criação do objeto esperado
        DisciplineModel disciplineModel1 = new DisciplineModel(1L, "programação", "Coisas de codar as coisas");
        DisciplineModel disciplineModel2 = new DisciplineModel(2L, "embarcado", "Coisas de embarcar as coisas");
        List<DisciplineModel> listDiscipline = new ArrayList<>();        
        listDiscipline.add(disciplineModel1);
        listDiscipline.add(disciplineModel2);

        // Simulação do comportamento do repositório
        Mockito.when(disciplineRepository.findAll())
            .thenReturn((listDiscipline));
        
        // Execução do método a ser testado
        assertThat(disciplineService.findAll(),hasSize(2));
    }


    @Test
    public void disciplineTestService_SaveSuccess(){

        // Criação do objeto de requisição
        DisciplineRequestDTO disciplineRequest = new DisciplineRequestDTO("cloud", "Coisas das nuvens");
    
        // Criação do objeto esperado
        DisciplineResponseDTO disciplineExpectedModel = new DisciplineResponseDTO();
        BeanUtils.copyProperties(disciplineRequest, disciplineExpectedModel);
    
        // Simulação do comportamento do repositório
        Mockito.when(disciplineRepository.save(any(DisciplineModel.class)))
                .thenAnswer(invocation -> {
                    DisciplineModel savedDiscipline = invocation.getArgument(0);
                    savedDiscipline.setIdDiscipline(3L); // Atribui um id fictício
                    return savedDiscipline;
                });
    
        // Execução do método a ser testado
        DisciplineResponseDTO savedDiscipline = disciplineService.save(disciplineRequest).getBody();
    
        // Verificação do resultado
        assertThat(savedDiscipline, equalTo(disciplineExpectedModel));
    }

    @Test
    public void deisciplineTestService_DeleteById(){        
        // Cria um objeto DisciplineModel com ID 1
        DisciplineModel disciplineToDelete = new DisciplineModel();
        disciplineToDelete.setIdDiscipline(1L);

        // Simulação do comportamento do repositório
        Mockito.when(disciplineRepository.findById(1L)).thenReturn(Optional.of(disciplineToDelete));
        
        // Chama o método deleteById do serviço
        disciplineService.delete(1L);
        
        // Verifica se o método deleteById do repository foi chamado com o ID correto
        Mockito.verify(disciplineRepository, times(1)).delete(disciplineToDelete);
    }
}