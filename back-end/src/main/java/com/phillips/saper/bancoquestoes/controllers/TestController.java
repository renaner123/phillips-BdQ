package com.phillips.saper.bancoquestoes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phillips.saper.bancoquestoes.dtos.TestRequestDTO;
import com.phillips.saper.bancoquestoes.models.TestModel;
import com.phillips.saper.bancoquestoes.services.TestService;

// TODO adicionar Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)}) nos recursos

@RestController
@RequestMapping("/tests")
public class TestController {
    
    @Autowired
    TestService testService;

    // TODO ver como receber e responder um objeto json na chave answers (e.g {"1":"B","2":"C"}) No momento está como string "{\"1\":\"B\",\"2\":\"C\"}",

    /*
     {
		"name": "Prova de alfabeto",
		"answers":"{\"1\":\"B\",\"2\":\"C\"}",
		"dateTime": "2022-03-12T00:13:40Z"
	}
     */

    @GetMapping
    public ResponseEntity<List<TestModel>> findAll(){
        return testService.findAll();
    }


    @PostMapping
    public ResponseEntity<Object> save(@RequestBody TestRequestDTO testRequestDTO){
        return testService.save(testRequestDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
        @PathVariable(name = "id") Long id,
        @RequestBody TestRequestDTO testResquestDTO){

        return testService.update(id, testResquestDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") Long id){

        return testService.delete(id);
    }
}
