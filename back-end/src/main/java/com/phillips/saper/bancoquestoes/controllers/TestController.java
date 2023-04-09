package com.phillips.saper.bancoquestoes.controllers;

import static com.phillips.saper.bancoquestoes.configuration.SwaggerConfig.BASIC_AUTH_SECURITY_SCHEME;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.phillips.saper.bancoquestoes.dtos.TestRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.TestResponseDTO;
import com.phillips.saper.bancoquestoes.models.TestModel;
import com.phillips.saper.bancoquestoes.services.TestService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/v1/tests")
public class TestController {

    @Autowired
    TestService testService;

    @Operation(summary = "Get list of all Tests", security = {
            @SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME) })
    @GetMapping
    public ResponseEntity<List<TestResponseDTO>> findAll() {
        return testService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Generate a new test by discipline and subject of interest", security = {
            @SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME) })
    @PostMapping
    public ResponseEntity<TestResponseDTO> save(@RequestBody TestRequestDTO testRequestDTO) {
        return testService.save(testRequestDTO);
    }

/*     @Operation(summary = "Update a test", security = { @SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME) })
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
            @PathVariable(name = "id") Long id,
            @RequestBody TestRequestDTO testResquestDTO) {

        return testService.update(id, testResquestDTO);
    } */

    @Operation(summary = "Delete a Test", security = { @SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME) })
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") Long id) {

        return testService.delete(id);
    }
}
