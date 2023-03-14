package com.phillips.saper.bancoquestoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phillips.saper.bancoquestoes.models.QuestionModel;

public interface QuestionRepository extends JpaRepository<QuestionModel, Long> {

}