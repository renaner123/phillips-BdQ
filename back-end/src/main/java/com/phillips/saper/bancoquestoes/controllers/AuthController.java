package com.phillips.saper.bancoquestoes.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phillips.saper.bancoquestoes.dtos.AuthResponse;
import com.phillips.saper.bancoquestoes.dtos.LoginRequest;
import com.phillips.saper.bancoquestoes.models.ClientModel;
import com.phillips.saper.bancoquestoes.services.ClientService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final ClientService clientService;

    @Operation(summary = "Authenticate a client")
    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        Optional<ClientModel> clientOptional = clientService.authenticate(loginRequest.getUsername(),
                loginRequest.getPassword());
        if (clientOptional.isPresent()) {
            ClientModel client = clientOptional.get();
            return ResponseEntity.ok(new AuthResponse(client.getId(), client.getName(), client.getRoles()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    /*
     * @ResponseStatus(HttpStatus.CREATED)
     * 
     * @PostMapping("/signup")
     * public AuthResponse signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
     * if (clientService.hasUserWithUsername(signUpRequest.getUsername())) {
     * throw new
     * DuplicatedUserInfoException(String.format("Username %s is already been used",
     * signUpRequest.getUsername()));
     * }
     * if (clientService.hasUserWithEmail(signUpRequest.getEmail())) {
     * throw new
     * DuplicatedUserInfoException(String.format("Email %s is already been used",
     * signUpRequest.getEmail()));
     * }
     * 
     * User user = clientService.saveUser(createUser(signUpRequest));
     * return new AuthResponse(user.getId(), user.getName(), user.getRole());
     * }
     * 
     * private User createUser(SignUpRequest signUpRequest) {
     * User user = new User();
     * user.setUsername(signUpRequest.getUsername());
     * user.setPassword(signUpRequest.getPassword());
     * user.setName(signUpRequest.getName());
     * user.setEmail(signUpRequest.getEmail());
     * user.setRole(SecurityConfiguration.USER);
     * return user;
     * }
     */
}
