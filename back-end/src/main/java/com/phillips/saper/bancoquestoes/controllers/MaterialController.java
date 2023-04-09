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
import org.springframework.web.bind.annotation.PutMapping;
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
@RequestMapping("/v1/materials")
public class MaterialController {

    @Autowired
    MaterialService materialService;

    @Operation(summary = "Get a list of all Materials", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @GetMapping()
    public ResponseEntity<List<MaterialResponseDTO>> findAll() {
        return materialService.findAll();
    } 

    @Operation(summary = "Return the top five Materials access", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @GetMapping("/amount-access")
    public ResponseEntity<List<MaterialResponseDTO>> FiveAmountAccess() {
                return materialService.findTop5ByOrderByAmountAccessDesc();
    }

    @Operation(summary = "Get all Materials by Tag", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @GetMapping("/{tag}")
    public ResponseEntity<List<MaterialResponseDTO>> materialByTag(
            @PathVariable(name = "tag") String tag) {
        return materialService.findByTag(tag);
    }

    @Operation(summary = "Get a list of all Materials certifieds", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @GetMapping("/certifieds")
    public ResponseEntity<List<MaterialResponseDTO>> findAllCertified() {
        return materialService.findByCertifiedTrue();
    }


    @Operation(summary = "Delete a Material", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(
            @PathVariable(name = "id") Long id) {
                return materialService.delete(id);
    }

    @Operation(summary = "Update a tag of the Material", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @PutMapping("/tags/{id}")
    public ResponseEntity<MaterialResponseDTO> updateTag(
            @RequestParam(name = "tag") String tag,
            @PathVariable(name = "id") Long id) {
        return materialService.updateTag(id, tag);
    }

    @Operation(summary = "Update a certified of the Material", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @PutMapping("/certified/{id}")
    public ResponseEntity<MaterialResponseDTO> updateCertified(
            @RequestParam(name = "certified") Boolean certified,
            @PathVariable(name = "id") Long id) {
        return materialService.updateCertified(id, certified);
    }

    @Operation(summary = "Upload a PDF file", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/upload-files")
	public void uploadMultipleFiles(@RequestParam("files") MultipartFile[] files,
                                    @AuthenticationPrincipal UserDetails userDetails) {
		for (MultipartFile file: files) {
			materialService.saveFile(file, userDetails.getUsername());			
		}		
	}

    @Operation(summary = "Download a PDF file", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
	@GetMapping("/download-file/{fileId}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Long fileId){
		MaterialModel doc = materialService.getFile(fileId).get();
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(doc.getDocType()))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getFileName()+"\"")
				.body(new ByteArrayResource(doc.getData()));
	}

    @Operation(summary = "Return the number of materials stored in the database")
    @GetMapping("/count")
    public long count(){
        return materialService.countMaterials();}

}
