package com.phillips.saper.bancoquestoes.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phillips.saper.bancoquestoes.models.ClientModel;

public interface ClientRepository extends JpaRepository<ClientModel, Long> {
    List<ClientModel> findAllByNameIgnoreCase(String name);

    Optional<ClientModel> findByLogin(String username);

    boolean existsByLogin(String login);
}
