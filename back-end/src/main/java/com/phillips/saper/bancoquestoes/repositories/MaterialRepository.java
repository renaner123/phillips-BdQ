package com.phillips.saper.bancoquestoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.phillips.saper.bancoquestoes.models.MaterialModel;

public interface MaterialRepository extends JpaRepository<MaterialModel, Long> {
    
    List<MaterialModel> findTop5ByOrderByAmountAccessDesc();

}