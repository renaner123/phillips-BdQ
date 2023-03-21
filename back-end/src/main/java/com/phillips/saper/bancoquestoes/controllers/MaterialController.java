package com.phillips.saper.bancoquestoes.controllers;

import static com.phillips.saper.bancoquestoes.configuration.SwaggerConfig.BASIC_AUTH_SECURITY_SCHEME;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.phillips.saper.bancoquestoes.dtos.MaterialResponseDTO;
import com.phillips.saper.bancoquestoes.models.MaterialModel;
import com.phillips.saper.bancoquestoes.services.MaterialService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/materials")
public class MaterialController {

    @Autowired
    MaterialService materialService;

    // TODO ver como vai jogar na tela a lista de arquivos
    //@Operation(summary = "Get a list of all Materials", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @GetMapping()
    public ResponseEntity<List<MaterialResponseDTO>> findAll() {
        return materialService.findAll();
    } 
    
    // @ResponseStatus(HttpStatus.CREATED)
    // @Operation(summary = "Register a Material", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    // @PostMapping
    // public ResponseEntity<Object> save(
    //         @RequestBody MaterialRequestDTO materialRequestDTO) {
    //     return materialService.save(materialRequestDTO);
    // }

    // @Operation(summary = "Update a Material", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    // @PutMapping("/{id}")
    // public ResponseEntity<Object> update(
    //         @PathVariable(name = "id") Long id,
    //         @RequestBody MaterialRequestDTO materialRequestDTO) {
    //     return materialService.update(id, materialRequestDTO);
    // }

    @Operation(summary = "Delete a Material", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(
            @PathVariable(name = "id") Long id) {
                return materialService.delete(id);
    }

    //@Operation(summary = "Upload a PDF file", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/uploadFiles")
	public void uploadMultipleFiles(@RequestParam("files") MultipartFile[] files,
                                    @AuthenticationPrincipal UserDetails userDetails) {
		for (MultipartFile file: files) {
			materialService.saveFile(file, userDetails.getUsername());			
		}		
	}

    //@Operation(summary = "Download a PDF file", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Long fileId){
		MaterialModel doc = materialService.getFile(fileId).get();
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(doc.getDocType()))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getFileName()+"\"")
				.body(new ByteArrayResource(doc.getData()));
	}

}
