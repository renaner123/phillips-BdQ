package com.phillips.saper.bancoquestoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phillips.saper.bancoquestoes.models.QuestionModel;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionModel, Long> {

}