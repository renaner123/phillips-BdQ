package com.phillips.saper.bancoquestoes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phillips.saper.bancoquestoes.models.MaterialModel;

public interface MaterialRepository extends JpaRepository<MaterialModel, Long> {
    
    List<MaterialModel> findTop5ByOrderByAmountAccessDesc();

	List<MaterialModel> findByTag(String tag);

    List<MaterialModel> findByCertifiedTrue();

}