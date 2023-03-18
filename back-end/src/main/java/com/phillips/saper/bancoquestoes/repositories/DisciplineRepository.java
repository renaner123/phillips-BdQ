package com.phillips.saper.bancoquestoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phillips.saper.bancoquestoes.models.DisciplineModel;

public interface DisciplineRepository extends JpaRepository<DisciplineModel, Long> {

}