package com.phillips.saper.bancoquestoes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.phillips.saper.bancoquestoes.dtos.ClientRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.ClientResponseDTO;
import com.phillips.saper.bancoquestoes.exceptions.ConflictStoreException;
import com.phillips.saper.bancoquestoes.exceptions.UserNotFoundException;
import com.phillips.saper.bancoquestoes.models.ClientModel;
import com.phillips.saper.bancoquestoes.repositories.ClientRepository;

import jakarta.transaction.Transactional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public List<ClientModel> findAll(String name) {
        if (name.equals("")) {
            return clientRepository.findAll();
        } else {
            return clientRepository.findAllByNameIgnoreCase(name);
        }
    }

    @Transactional
    public ClientResponseDTO save(ClientRequestDTO clientRequestDTO) {
        // Verificaço de regras
        ClientModel client = clientRequestDTO.toClient();

        if (clientRepository.existsByLogin(client.getLogin())) {
            throw new ConflictStoreException("login already in use");
        }

        return new ClientResponseDTO(clientRepository.save(client));
    }

    public ResponseEntity<Object> find(Long id) {
        ClientModel client = clientRepository.findById(id).orElseThrow();
        return ResponseEntity.status(HttpStatus.OK).body(new ClientResponseDTO(client));
    }

    public Optional<ClientModel> findByLogin(String login) {
        Optional<ClientModel> client = clientRepository.findByLogin(login);        
        return client;
    }

    public Optional<ClientModel> findById(Long id) {
        Optional<ClientModel> client = clientRepository.findById(id);        
        return client;
    }

    @Transactional
    public ResponseEntity<Object> update(Long id, ClientRequestDTO clientRequestDTO) {
        // Achar
        ClientModel client = clientRepository.findById(id).orElseThrow();

        // Modificar
        if (clientRequestDTO.getName() != null) {
            client.setName(clientRequestDTO.getName());
        }
        if (clientRequestDTO.getPassword() != null) {
            client.setPassword(clientRequestDTO.getPassword());
        }
        if (clientRequestDTO.getLogin() != null) {
            client.setLogin(clientRequestDTO.getLogin());
        }
        // Salvar
        ClientResponseDTO clientResponseDTO = new ClientResponseDTO(clientRepository.save(client));
        return ResponseEntity.status(HttpStatus.CREATED).body(clientResponseDTO);
    }

    @Transactional
    public ResponseEntity<Object> delete(Long id) {
        ClientModel client = clientRepository.findById(id).orElseThrow();
        clientRepository.delete(client);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    public Optional<ClientModel> authenticate(String username, String password) {
        return findByLogin(username)
                .filter(user -> passwordEncoder.matches(password, user.getPassword()));
    }
}
