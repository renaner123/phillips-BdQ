package com.phillips.saper.bancoquestoes.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.hamcrest.Matchers.hasSize;

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

import com.phillips.saper.bancoquestoes.dtos.StudentRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.StudentResponseDTO;
import com.phillips.saper.bancoquestoes.enums.RoleNames;
import com.phillips.saper.bancoquestoes.models.RoleModel;
import com.phillips.saper.bancoquestoes.models.StudentModel;
import com.phillips.saper.bancoquestoes.models.TeacherModel;
import com.phillips.saper.bancoquestoes.repositories.CertifierRepository;
import com.phillips.saper.bancoquestoes.repositories.ClientRepository;
import com.phillips.saper.bancoquestoes.repositories.RoleRepository;
import com.phillips.saper.bancoquestoes.repositories.StudentRepository;
import com.phillips.saper.bancoquestoes.repositories.TeacherRepository;
import com.phillips.saper.bancoquestoes.repositories.TestRepository;


@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
public class StudentServiceTest {

    @TestConfiguration
    static class certifierTestCertifierConfiguration {

        @Bean
        public StudentService studentService() {
            return new StudentService();
        }
        @Bean
        public TeacherService teacherService() {
            return new TeacherService();
        }
    }

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;

    @MockBean
    CertifierRepository certifierRepository;

    @MockBean
    TeacherRepository teacherRepository;

    @MockBean
    RoleRepository roleRepository;

    @MockBean
    TestRepository testRepository;


    @MockBean
    ClientRepository clientRepository;

    @MockBean
    StudentRepository studentRepository;

    private final Long idStudent = 1L;

    @Test
    public void shouldSaveStudentWithSuccess(){
        // Criação do objeto de requisição
        StudentRequestDTO studentRequest = new StudentRequestDTO("Teste", "teste@email.com", "123", "123");

        RoleModel roleStudent = new RoleModel(idStudent,RoleNames.ROLE_STUDENT);
    
        // Criação do objeto esperado
        StudentResponseDTO studentExpected = new StudentResponseDTO();
        BeanUtils.copyProperties(studentRequest, studentExpected);
        studentExpected.setId(idStudent);
    
        // Simulação do comportamento do repositório
        Mockito.when(clientRepository.existsByLogin(studentRequest.getLogin())).thenReturn(false);   

        Mockito.when(teacherRepository.existsByCpf(anyString())).thenReturn(false);

        Mockito.when(studentRepository.existsByCpf(anyString())).thenReturn(false);

        Mockito.when(roleRepository.findByRole(RoleNames.ROLE_STUDENT)).thenReturn(Optional.of(roleStudent));
        
        Mockito.when(studentRepository.save(any(StudentModel.class)))
                .thenAnswer(invocation -> {
                    StudentModel savedStudent = invocation.getArgument(0);
                    savedStudent.setIdStudent(idStudent);// Atribui um id fictício
                    return savedStudent;
                });
    
        // Execução do método a ser testado
        StudentResponseDTO savedStudent = studentService.save(studentRequest).getBody();
    
        // Verificação do resultado
        assertThat(savedStudent, equalTo(studentExpected));

    }

    
/*     @Test
    public void shouldDeleteTeacherWithSuccess(){        
        // Cria um objeto TeacherModel com ID 1
        TeacherModel teacherToDelete = new TeacherModel();
        teacherToDelete.setIdDiscipline(idStudent);

        // Simulação do comportamento do repositório
        Mockito.when(teacherRepository.findById(idStudent)).thenReturn(Optional.of(teacherToDelete));
        
        // Chama o método deleteById do serviço
        teacherService.delete(idStudent);
        
        // Verifica se o método deleteById do repository foi chamado com o ID correto
        Mockito.verify(teacherRepository, times(1)).delete(teacherToDelete);
    }

    @Test
    public void shouldFindAllTeachers(){
        // Criação do objeto esperado
        TeacherModel TeacherModel1 = new TeacherModel("12345678901", "teacher1", "teacher1@email.com", 1L, false);
        TeacherModel TeacherModel2 = new TeacherModel("12345678902", "teacher2", "teacher2@email.com", 1L, false);        
        List<TeacherModel> listDiscipline = new ArrayList<>();        
        listDiscipline.add(TeacherModel1);
        listDiscipline.add(TeacherModel2);

        // Simulação do comportamento do repositório
        Mockito.when(teacherRepository.findAll())
            .thenReturn((listDiscipline));
        
        // Execução do método a ser testado
        assertThat(teacherService.findAll().getBody(),hasSize(2));
    }

    @Test
    public void shouldReturnTeacherByNameArgument(){
        // Criação do objeto esperado
        String nameTeacher = "teacher1";
        TeacherModel TeacherModel1 = new TeacherModel("12345678901", nameTeacher, "teacher1@email.com", 1L, false);
        TeacherModel1.setIdTeacher(1L);

        // Simulação do comportamento do repositório
        Mockito.when(teacherRepository.findByName(nameTeacher))
            .thenReturn((Optional.of(TeacherModel1)));
        
        // Execução do método a ser testado
        assertThat(teacherService.findByName(nameTeacher).get(), equalTo(TeacherModel1));
    } */

    
}
