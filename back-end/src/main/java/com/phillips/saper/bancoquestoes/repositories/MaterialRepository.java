package com.phillips.saper.bancoquestoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phillips.saper.bancoquestoes.models.MaterialModel;

public interface MaterialRepository extends JpaRepository<MaterialModel, Long> {

}