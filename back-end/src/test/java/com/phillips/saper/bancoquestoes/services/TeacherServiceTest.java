package com.phillips.saper.bancoquestoes.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

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

import com.phillips.saper.bancoquestoes.dtos.TeacherRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.TeacherResponseDTO;
import com.phillips.saper.bancoquestoes.enums.RoleNames;
import com.phillips.saper.bancoquestoes.models.RoleModel;
import com.phillips.saper.bancoquestoes.models.TeacherModel;
import com.phillips.saper.bancoquestoes.repositories.CertifierRepository;
import com.phillips.saper.bancoquestoes.repositories.ClientRepository;
import com.phillips.saper.bancoquestoes.repositories.RoleRepository;
import com.phillips.saper.bancoquestoes.repositories.StudentRepository;
import com.phillips.saper.bancoquestoes.repositories.TeacherRepository;


@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
public class TeacherServiceTest {

    @TestConfiguration
    static class certifierTestCertifierConfiguration {

        @Bean
        public TeacherService teacherService() {
            return new TeacherService();
        }
    }

    @Autowired
    TeacherService teacherService;

    @MockBean
    CertifierRepository certifierRepository;

    @MockBean
    TeacherRepository teacherRepository;

    @MockBean
    RoleRepository roleRepository;

    @MockBean
    ClientRepository clientRepository;

    @MockBean
    StudentRepository studentRepository;

    private final Long idTest = 1L;

    @Test
    public void shouldSaveTeacherWithSuccess(){
        // Criação do objeto de requisição
        String cpfTeacher = "12345678901";
        String loginTeacher = "teste@email.com";
        TeacherRequestDTO teacherRequest = new TeacherRequestDTO(cpfTeacher, "Test", "123456", "123456", loginTeacher, null);

        RoleModel roleTeacher = new RoleModel(idTest,RoleNames.ROLE_TEACHER);
    
        // Criação do objeto esperado
        TeacherResponseDTO teacherExpectedResponse = new TeacherResponseDTO();
        BeanUtils.copyProperties(teacherRequest, teacherExpectedResponse);
        teacherExpectedResponse.setEmail(loginTeacher);
    
        // Simulação do comportamento do repositório
        Mockito.when(clientRepository.existsByLogin(cpfTeacher)).thenReturn(false);   

        Mockito.when(clientRepository.existsByLogin(loginTeacher)).thenReturn(false);

        Mockito.when(roleRepository.findByRole(RoleNames.ROLE_TEACHER)).thenReturn(Optional.of(roleTeacher));

        Mockito.when(teacherRepository.save(any(TeacherModel.class)))
                .thenAnswer(invocation -> {
                    TeacherModel savedTeacher = invocation.getArgument(0);
                    savedTeacher.setIdTeacher(idTest);// Atribui um id fictício
                    return savedTeacher;
                });
    
        // Execução do método a ser testado
        TeacherResponseDTO savedTeacher = teacherService.save(teacherRequest).getBody();
    
        // Verificação do resultado
        assertThat(savedTeacher, equalTo(teacherExpectedResponse));

    }

    
    @Test
    public void shouldDeleteTeacherWithSuccess(){        
        // Cria um objeto TeacherModel com ID 1
        TeacherModel teacherToDelete = new TeacherModel();
        teacherToDelete.setIdDiscipline(idTest);

        // Simulação do comportamento do repositório
        Mockito.when(teacherRepository.findById(idTest)).thenReturn(Optional.of(teacherToDelete));
        
        // Chama o método deleteById do serviço
        teacherService.delete(idTest);
        
        // Verifica se o método deleteById do repository foi chamado com o ID correto
        Mockito.verify(teacherRepository, times(1)).delete(teacherToDelete);
    }
    
}
