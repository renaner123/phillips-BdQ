package com.phillips.saper.bancoquestoes.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.hamcrest.Matchers.hasSize;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

import com.phillips.saper.bancoquestoes.Embeddables.StudentTestPK;
import com.phillips.saper.bancoquestoes.dtos.StudentRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.StudentResponseDTO;
import com.phillips.saper.bancoquestoes.dtos.StudentTestResponseDTO;
import com.phillips.saper.bancoquestoes.enums.RoleNames;
import com.phillips.saper.bancoquestoes.models.ClientModel;
import com.phillips.saper.bancoquestoes.models.RoleModel;
import com.phillips.saper.bancoquestoes.models.StudentModel;
import com.phillips.saper.bancoquestoes.models.StudentTest;
import com.phillips.saper.bancoquestoes.models.TeacherModel;
import com.phillips.saper.bancoquestoes.models.TestModel;
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
    public void shouldSaveStudentWithSuccess() {
        // Criação do objeto de requisição
        StudentRequestDTO studentRequest = new StudentRequestDTO("Teste", "teste@email.com", "123", "123");

        RoleModel roleStudent = new RoleModel(idStudent, RoleNames.ROLE_STUDENT);

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

    /*
     * @Test
     * public void shouldDeleteTeacherWithSuccess(){
     * // Cria um objeto TeacherModel com ID 1
     * TeacherModel teacherToDelete = new TeacherModel();
     * teacherToDelete.setIdDiscipline(idStudent);
     * 
     * // Simulação do comportamento do repositório
     * Mockito.when(teacherRepository.findById(idStudent)).thenReturn(Optional.of(
     * teacherToDelete));
     * 
     * // Chama o método deleteById do serviço
     * teacherService.delete(idStudent);
     * 
     * // Verifica se o método deleteById do repository foi chamado com o ID correto
     * Mockito.verify(teacherRepository, times(1)).delete(teacherToDelete);
     * }
     */

    @Test
    public void shouldFindAllStudents() {

        long idStudent1 = 1L;
        long idStudent2 = 2L;

        // Criação do objeto esperado
        StudentModel studentModel1 = new StudentModel(1L, "12345678901", "teste", "teste@email.com");
        StudentModel studentModel2 = new StudentModel(2L, "12345678902", "teste1", "teste1@email.com");

        ClientModel clientModel1 = new ClientModel("teste", "teste1", "teste1");
        ClientModel clientModel2 = new ClientModel("teste2", "teste2", "teste2");

        clientModel1.setId(idStudent1);
        clientModel2.setId(idStudent2);
        studentModel1.setClientModel(clientModel1);
        studentModel2.setClientModel(clientModel2);

        List<StudentModel> listDiscipline = new ArrayList<>();
        listDiscipline.add(studentModel1);
        listDiscipline.add(studentModel2);

        // Simulação do comportamento do repositório
        Mockito.when(studentRepository.findAll())
                .thenReturn((listDiscipline));

        List<StudentResponseDTO> returnStudent = studentService.findAll().getBody();

        // Execução do método a ser testado
        assertThat(returnStudent, hasSize(2));
    }

    @Test
    public void shouldReturnStudentById() {
        // Criação do objeto esperado
        long idStudent = 1L;
        StudentModel studentModel1 = new StudentModel(1L, "12345678901", "teste", "teste@email.com");
        studentModel1.setIdStudent(1L);

        ClientModel clientModel1 = new ClientModel("teste", "teste1", "teste1");

        clientModel1.setId(idStudent);
        studentModel1.setClientModel(clientModel1);


        // Simulação do comportamento do repositório
        Mockito.when(studentRepository.findById(idStudent))
                .thenReturn((Optional.of(studentModel1)));
        
        StudentResponseDTO returnStudentDTO = (StudentResponseDTO) studentService.findById(idStudent).getBody();

        StudentModel returnStudent = new StudentModel(returnStudentDTO);

        // Execução do método a ser testado
        assertThat(returnStudent, equalTo(studentModel1));
    }

    @Test
    public void shouldReturnListWithResultTestByStudentId() {

        long idStudent = 1L;
        long idTest = 1L;

        // Criação do objeto esperado
        StudentModel studentModel1 = new StudentModel(1L, "12345678901", "teste", "teste@email.com");
        studentModel1.setIdStudent(1L);
        ClientModel clientModel1 = new ClientModel("teste", "teste1", "teste1");
        StudentTestPK studentTestPK = new StudentTestPK(idStudent, idTest);
        StudentTest studentTest = new StudentTest(studentTestPK);
        Set<StudentTest> studentTestSet = new HashSet<>(); 
        studentTestSet.add(studentTest); 
        TestModel testModel = new TestModel(idTest, "", null, null, null, null, studentTestSet); 

        clientModel1.setId(idStudent);
        studentModel1.setClientModel(clientModel1);
        studentModel1.setStudentTests(studentTestSet);

        // Simulação do comportamento do repositório
        Mockito.when(studentRepository.findByClientModelId(idStudent))
                .thenReturn((Optional.of(studentModel1)));

        Mockito.when((testRepository.findById(idTest)))
        .thenReturn(Optional.of(testModel));
        
        List<StudentTestResponseDTO> returnStudentDTO = studentService.findResultById(idStudent).getBody();

        // Execução do método a ser testado
        assertThat(returnStudentDTO, hasSize(1));
    }

}
