package com.phillips.saper.bancoquestoes.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.hamcrest.Matchers.equalTo;

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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.phillips.saper.bancoquestoes.dtos.ClientRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.ClientResponseDTO;
import com.phillips.saper.bancoquestoes.models.ClientModel;
import com.phillips.saper.bancoquestoes.repositories.ClientRepository;
import com.phillips.saper.bancoquestoes.repositories.DisciplineRepository;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
public class ClientServiceTest {


    @TestConfiguration
    static class clientTestClientConfiguration {

        @Bean
        public ClientService clientService(){
            return new ClientService();
        }

        @Bean
        public PasswordEncoder passwordEncoder(){            
            return new PasswordEncoder() {

                // FIXME verificar como testar o PasswordEncoder
                @Override
                public String encode(CharSequence rawPassword) {
                    throw new UnsupportedOperationException("Unimplemented method 'encode'");
                }

                @Override
                public boolean matches(CharSequence rawPassword, String encodedPassword) {
                    return true;
                }          
            };
        }

    }

    @Autowired
    ClientService clientService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @MockBean
    ClientRepository clientRepository;

    @MockBean
    DisciplineRepository disciplineRepository;

    @Test
    public void shouldReturnAllClients(){
        // Criação do objeto esperado
        ClientModel ClientModel1 = new ClientModel("test", "teste123", "teste123");
        ClientModel ClientModel2 = new ClientModel("test", "teste456", "teste456");
        ClientModel ClientModel3 = new ClientModel("test", "teste789", "teste789");
        List<ClientModel> listClients = new ArrayList<>();        
        listClients.add(ClientModel1);
        listClients.add(ClientModel2);
        listClients.add(ClientModel3);

        // Simulação do comportamento do repositório
        Mockito.when(clientRepository.findAll())
            .thenReturn((listClients));
        
        // Execução do método a ser testado
        assertThat(clientService.findAll(""),hasSize(3));

    }

    @Test
    public void shouldSaveClientWithSuccess(){

        long idClient = 1L;

        // Criação do objeto de requisição
        ClientRequestDTO clientRequest = new ClientRequestDTO("cloud", "cloud123", "cloud123");
    
        // Criação do objeto esperado
        ClientResponseDTO clientExpected = new ClientResponseDTO();
        clientExpected.setid_client(idClient);
        BeanUtils.copyProperties(clientRequest, clientExpected);
    
        // Simulação do comportamento do repositório
        Mockito.when(clientRepository.save(any(ClientModel.class)))
                .thenAnswer(invocation -> {
                    ClientModel savedClient = invocation.getArgument(0);
                    savedClient.setId(idClient); // Atribui um id fictício
                    return savedClient;
                });
    
        // Execução do método a ser testado
        ClientResponseDTO savedClient = clientService.save(clientRequest);
    
        // Verificação do resultado
        assertThat(savedClient, equalTo(clientExpected));
    }

    @Test
    public void shouldReturnClientByLoginWithSuccess(){

        String loginWanted = "teste123";

        // Criação do objeto esperado
        ClientModel ClientModel1 = new ClientModel("test", "teste123", "teste123");

        // Simulação do comportamento do repositório
        Mockito.when(clientRepository.findByLogin(loginWanted))
            .thenReturn((Optional.of(ClientModel1)));
        
        // Execução do método a ser testado
        assertThat(clientService.findByLogin(loginWanted), equalTo(Optional.of(ClientModel1)));
    }

    @Test
    public void shouldReturnClientByIdWithSuccess(){

        long idWanted = 1L;

        // Criação do objeto esperado
        ClientModel ClientModel1 = new ClientModel("test", "teste123", "teste123");
        ClientModel1.setId(idWanted);

        // Simulação do comportamento do repositório
        Mockito.when(clientRepository.findById(idWanted))
            .thenReturn((Optional.of(ClientModel1)));
        
        // Execução do método a ser testado
        assertThat(clientService.findById(idWanted), equalTo(Optional.of(ClientModel1)));
    }

    @Test
    public void shouldDeleteClientByIdWithSuccess(){    
        
        long idToDelete = 1L;

        // Cria um objeto ClientModel com ID 1
        ClientModel clientToDelete = new ClientModel();
        clientToDelete.setId(idToDelete);

        // Simulação do comportamento do repositório
        Mockito.when(clientRepository.findById(idToDelete)).thenReturn(Optional.of(clientToDelete));
        
        // Chama o método deleteById do serviço
        clientService.delete(idToDelete);
        
        // Verifica se o método deleteById do repository foi chamado com o ID correto
        Mockito.verify(clientRepository, times(1)).delete(clientToDelete);
    }

    @Test
    public void shouldAuthenticateClientAndReturnClient() {
        String login = "teste123";
        String password = "teste123";
    
        // Criação do objeto esperado
        ClientModel clientModel1 = new ClientModel("test", login, password);
    
        // Simulação do comportamento do repositório
        Mockito.when(clientRepository.findByLogin(Mockito.eq(login)))
                .thenReturn(Optional.of(clientModel1));
    
        // Execução do método a ser testado
        assertThat(clientService.authenticate(login, password), equalTo(Optional.of(clientModel1)));
    }
}
