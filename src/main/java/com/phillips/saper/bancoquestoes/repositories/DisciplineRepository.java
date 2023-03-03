package com.phillips.saper.bancoquestoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DisciplineRepository extends JpaRepository<DisciplineRepository, Integer> {
    
}