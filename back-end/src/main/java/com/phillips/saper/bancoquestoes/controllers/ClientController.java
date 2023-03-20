package com.phillips.saper.bancoquestoes.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import com.phillips.saper.bancoquestoes.dtos.ClientRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.ClientResponseDTO;
import com.phillips.saper.bancoquestoes.models.ClientModel;
import com.phillips.saper.bancoquestoes.services.ClientService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

import static com.phillips.saper.bancoquestoes.configuration.SwaggerConfig.BASIC_AUTH_SECURITY_SCHEME;
@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientService clientService;
    
/*     @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @GetMapping("/{id}")
    public ResponseEntity<Object> find(@PathVariable(name = "id") Long id){
        return clientService.find(id);
    } */

    //@Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @Operation(summary = "Get Client by username/login")
    @GetMapping("/{username}")
    public ClientResponseDTO findClient(@PathVariable String username) {

        Optional<ClientModel> client = clientService.findByLogin(username);
        ClientResponseDTO clientResponse = new ClientResponseDTO();
        clientResponse.setLogin(client.get().getLogin());
        clientResponse.setName(client.get().getName());
        clientResponse.setRole(client.get().getRoles());
        clientResponse.setid_client(client.get().getId());

        return clientResponse;
    }

    //@Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @Operation(summary = "Get a list of all Clients")
    @GetMapping
    public List<ClientResponseDTO> findAll(
            @RequestParam(name = "name", defaultValue = "") String name){
        List<ClientModel> list = clientService.findAll(name);
        return list.stream().map(ClientResponseDTO::new).toList();
    }

// Quando criar um Student ele já vincula a uma Client, não precisa do POST
//    @PostMapping
//    public ClientResponseDTO save(@RequestBody ClientRequestDTO clientRequestDTO){
//
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        String username;
//
//        if (principal instanceof UserDetails) {
//            username = ((UserDetails)principal).getUsername();
//        }
//
//        return clientService.save(clientRequestDTO);
//    }

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
            @PathVariable(name = "id") Long id,
            @RequestBody ClientRequestDTO clientRequestDTO){
        return clientService.update(id, clientRequestDTO);
    }
    
    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(
            @PathVariable(name = "id") Long id){
        return clientService.delete(id);
    }
}
