package com.phillips.saper.bancoquestoes.configuration;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.phillips.saper.bancoquestoes.models.ClientModel;
import com.phillips.saper.bancoquestoes.repositories.ClientRepository;

@Service
public class AuthenticatorService implements UserDetailsService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<ClientModel> clientOptional = clientRepository.findByLogin(username);
        if(clientOptional.isPresent()){
            return clientOptional.get();
        }else{
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

    }
}
