package com.phillips.saper.bancoquestoes.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

import java.io.IOException;
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
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.phillips.saper.bancoquestoes.dtos.MaterialResponseDTO;
import com.phillips.saper.bancoquestoes.models.ClientModel;
import com.phillips.saper.bancoquestoes.models.MaterialModel;
import com.phillips.saper.bancoquestoes.repositories.ClientRepository;
import com.phillips.saper.bancoquestoes.repositories.MaterialRepository;
import com.phillips.saper.bancoquestoes.repositories.RoleRepository;
import com.phillips.saper.bancoquestoes.repositories.StudentRepository;
import com.phillips.saper.bancoquestoes.repositories.TeacherRepository;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
public class MaterialServiceTest {

    @TestConfiguration
    static class materialTestMaterialConfiguration {

        @Bean
        public MaterialService materialService() {
            return new MaterialService();
        }

        @Bean
        public TeacherService teacherService() {
            return new TeacherService();
        }
    }

    @Autowired
    MaterialService materialService;

    @Autowired
    TeacherService teacherService;

    @MockBean
    MaterialRepository materialRepository;

    @MockBean
    TeacherRepository teacherRepository;

    @MockBean
    ClientRepository clientRepository;

    @MockBean
    RoleRepository roleRepository;

    @MockBean
    StudentRepository studentRepository;

    @Test
    public void shouldFindAllMaterials() {

        MaterialModel materialModel = new MaterialModel("Prog", null, null, 1L, "pdf/application", null, 0, "aloan");
        MaterialModel materialModel2 = new MaterialModel(null, null, null, 2L, "pdf/application", null, 0, "aloan");
        List<MaterialModel> listMaterials = new ArrayList<>();
        listMaterials.add(materialModel);
        listMaterials.add(materialModel2);

        // Simulação do comportamento do repositório
        Mockito.when(materialRepository.findAll())
                .thenReturn((listMaterials));

        // Execução do método a ser testado
        assertThat(materialService.findAll().getBody(), hasSize(2));
    }

    @Test
    public void shoulDeleteDisciplineWithSuccess() {
        // Cria um objeto DisciplineModel com ID 1
        MaterialModel materialToDelete = new MaterialModel();
        materialToDelete.setIdMaterial(1L);

        // Simulação do comportamento do repositório
        Mockito.when(materialRepository.findById(1L)).thenReturn(Optional.of(materialToDelete));

        // Chama o método deleteById do serviço
        materialService.delete(1L);

        // Verifica se o método deleteById do repository foi chamado com o ID correto
        Mockito.verify(materialRepository, times(1)).delete(materialToDelete);

    }

    @Test 
    public void shouldSaveFileWithSuccess() throws IOException {
        // Criação do objeto de requisição
        String fileName = "test";
        MockMultipartFile multipartFile = new MockMultipartFile(
                "uploaded-file",
                fileName,
                "text/plain",
                "This is the file content".getBytes());
        // Criação do cliente que fará o upload do arquivo
        ClientModel clientModel = new ClientModel(fileName, fileName, fileName);

        // Criação do material esperado como resposta
        MaterialModel materialExpectd = new MaterialModel("test", multipartFile.getContentType(),
                multipartFile.getBytes(), 0);

        // Simulação do comportamento dos repositórios
        Mockito.when(materialRepository.save(any(MaterialModel.class)))
                .thenAnswer(invocation -> {
                    MaterialModel saveMaterial = invocation.getArgument(0);
                    saveMaterial.setIdMaterial(3L); // Atribui um id fictício
                    return saveMaterial;
                });
        Mockito.when(clientRepository.findByLogin(clientModel.getUsername())).thenReturn(Optional.of(clientModel));

        // Execução do método a ser testado
        MaterialModel saveMaterial = materialService.saveFile(multipartFile, clientModel.getUsername());

        // Verificação do resultado
        assertThat(saveMaterial, equalTo(materialExpectd));
    }


    @Test
    public void shouldDownloadFileWithSuccess() throws IOException {
        // Criação do objeto de requisição
        String fileName = "test";
        Long idMaterial = 3L;
        MockMultipartFile multipartFile = new MockMultipartFile(
                "uploaded-file",
                fileName,
                "text/plain",
                "This is the file content".getBytes());

        // Criação do material esperado como resposta
        MaterialModel materialExpectd = new MaterialModel("test", multipartFile.getContentType(),
                multipartFile.getBytes(), 0);

        // Simulação do comportamento dos repositórios
        Mockito.when(materialRepository.save(any(MaterialModel.class)))
                .thenAnswer(invocation -> {
                    MaterialModel saveMaterial = invocation.getArgument(0);
                    saveMaterial.setIdMaterial(idMaterial); // Atribui um id fictício
                    return saveMaterial;
                });
        Mockito.when(materialRepository.findById(idMaterial)).thenReturn(Optional.of(materialExpectd));

        // Execução do método a ser testado
        Optional<MaterialModel> downloadedMaterial = materialService.getFile(idMaterial);

        // Verificação do resultado
        assertThat(downloadedMaterial.get(), equalTo(materialExpectd));
    }

    @Test
    public void shouldReturnArrayWithTop5AmountAccessInDescOrder() {
        // Criação do objeto de requisição
        MaterialModel materialModel = new MaterialModel("Prog1", null, null, 1L, "pdf/application", null, 0, "aloan");
        MaterialModel materialModel2 = new MaterialModel("Prog2", null, null, 2L, "pdf/application", null, 0, "aloan");
        MaterialModel materialModel3 = new MaterialModel("Prog3", null, null, 1L, "pdf/application", null, 0, "aloan");
        MaterialModel materialModel4 = new MaterialModel("Prog4", null, null, 2L, "pdf/application", null, 0, "aloan");
        MaterialModel materialModel5 = new MaterialModel("Prog5", null, null, 1L, "pdf/application", null, 0, "aloan");
        List<MaterialModel> listMaterials = new ArrayList<>();
        listMaterials.add(materialModel);
        listMaterials.add(materialModel2);
        listMaterials.add(materialModel3);
        listMaterials.add(materialModel4);
        listMaterials.add(materialModel5);

        // Simulação do comportamento do repositório
        Mockito.when(materialRepository.findTop5ByOrderByAmountAccessDesc())
        .thenReturn((listMaterials));

        // Execução do método a ser testado
        assertThat(materialService.findTop5ByOrderByAmountAccessDesc().getBody(), hasSize(5));
    }

    @Test
    public void shouldReturnNumberTotalOfMaterialsInDatabase() {
        // Criação do objeto de requisição
        MaterialModel materialModel = new MaterialModel("Prog1", null, null, 1L, "pdf/application", null, 0, "aloan");
        MaterialModel materialModel2 = new MaterialModel("Prog2", null, null, 2L, "pdf/application", null, 0, "aloan");
        MaterialModel materialModel3 = new MaterialModel("Prog3", null, null, 1L, "pdf/application", null, 0, "aloan");
        MaterialModel materialModel4 = new MaterialModel("Prog4", null, null, 2L, "pdf/application", null, 0, "aloan");
        MaterialModel materialModel5 = new MaterialModel("Prog5", null, null, 1L, "pdf/application", null, 0, "aloan");
        List<MaterialModel> listMaterials = new ArrayList<>();
        listMaterials.add(materialModel);
        listMaterials.add(materialModel2);
        listMaterials.add(materialModel3);
        listMaterials.add(materialModel4);
        listMaterials.add(materialModel5);

        Long countExpected = (long) listMaterials.size();        

        // Simulação do comportamento do repositório
        Mockito.when(materialRepository.count())
        .thenReturn(((long) listMaterials.size()));

        // Execução do método a ser testado
        assertEquals(materialService.countMaterials(), countExpected);

    }

    @Test
    public void shouldUpdateMaterialTagWithSuccess() throws IOException {
        // Criação do objeto de requisição
        String fileName = "test";
        String tag = "aloan";
        Long idMaterial = 3L;
        MockMultipartFile multipartFile = new MockMultipartFile(
                "uploaded-file",
                fileName,
                "text/plain",
                "This is the file content".getBytes());

        // Criação do material esperado como resposta
        MaterialModel materialExpectd = new MaterialModel(fileName, multipartFile.getContentType(),
                multipartFile.getBytes(), 0);
        materialExpectd.setTag(tag);

        MaterialResponseDTO materialResponseExpectd = new MaterialResponseDTO();
        BeanUtils.copyProperties(materialExpectd, materialResponseExpectd);

        // Simulação do comportamento dos repositórios
        Mockito.when(materialRepository.save(any(MaterialModel.class)))
                .thenAnswer(invocation -> {
                    MaterialModel saveMaterial = invocation.getArgument(0);
                    saveMaterial.setIdMaterial(idMaterial); // Atribui um id fictício
                    saveMaterial.setTag(tag);
                    return saveMaterial;
                });
        Mockito.when(materialRepository.findById(idMaterial)).thenReturn(Optional.of(materialExpectd));

        // Execução do método a ser testado
        MaterialResponseDTO updateCertifiedMaterial = materialService.updateTag(idMaterial, tag).getBody();

        // Verificação do resultado
        assertThat(updateCertifiedMaterial, equalTo(materialResponseExpectd));  
    }

    @Test
    public void shouldReturnMaterialByTag() {

        String tag = "aloan";
        MaterialModel materialModel = new MaterialModel("Prog", null, null, 1L, "pdf/application", null, 0, tag);
        MaterialModel materialModel2 = new MaterialModel("Prog2", null, null, 1L, "pdf/txt", null, 0, tag);

        List<MaterialModel> listMaterialExpected = new ArrayList<>();
        listMaterialExpected.add(materialModel);
        listMaterialExpected.add(materialModel2);


        // Simulação do comportamento do repositório
        Mockito.when(materialRepository.findByTag(tag))
                .thenReturn((listMaterialExpected));

        // Execução do método a ser testado
        assertThat(materialService.findByTag(tag).getBody(), hasSize(2));
    }

    @Test
    public void shouldReturnAllMaterialsWithCertifiedTrue() {
        String tag = "aloan";
        MaterialModel materialModel = new MaterialModel("Prog", null, null, 1L, "pdf/application", null, 0, tag);
        materialModel.setCertified(true);

        List<MaterialModel> listMaterialExpected = new ArrayList<>();
        listMaterialExpected.add(materialModel);


        // Simulação do comportamento do repositório
        Mockito.when(materialRepository.findByCertifiedTrue())
                .thenReturn((listMaterialExpected));

        // Execução do método a ser testado
        assertTrue(materialService.findByCertifiedTrue().getBody().get(0).getCertified());
    }

    @Test
    public void shouldUpdateMaterialCertifiedWithSuccess() throws IOException {
        // Criação do objeto de requisição
        String fileName = "test";
        Boolean certified = true;
        Long idMaterial = 3L;
        MockMultipartFile multipartFile = new MockMultipartFile(
                "uploaded-file",
                fileName,
                "text/plain",
                "This is the file content".getBytes());

        // Criação do material esperado como resposta
        MaterialModel materialExpectd = new MaterialModel(fileName, multipartFile.getContentType(),
                multipartFile.getBytes(), 0);

        MaterialResponseDTO materialResponseExpectd = new MaterialResponseDTO();
        BeanUtils.copyProperties(materialExpectd, materialResponseExpectd);

        // Simulação do comportamento dos repositórios
        Mockito.when(materialRepository.save(any(MaterialModel.class)))
                .thenAnswer(invocation -> {
                    MaterialModel saveMaterial = invocation.getArgument(0);
                    saveMaterial.setIdMaterial(idMaterial); // Atribui um id fictício
                    saveMaterial.setCertified(certified);
                    return saveMaterial;
                });
        Mockito.when(materialRepository.findById(idMaterial)).thenReturn(Optional.of(materialExpectd));

        // Execução do método a ser testado
        MaterialResponseDTO updateCertifiedMaterial = materialService.updateCertified(idMaterial, certified).getBody();

        // Verificação do resultado
        assertThat(updateCertifiedMaterial, equalTo(materialResponseExpectd));  
    }

}