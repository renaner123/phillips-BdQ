package com.phillips.saper.bancoquestoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;

import java.util.List;

import com.phillips.saper.bancoquestoes.dtos.QuestionResponseDTO;
import com.phillips.saper.bancoquestoes.models.QuestionModel;

public interface QuestionRepository extends JpaRepository<QuestionModel, Long> {
    long count();
    List<QuestionModel> findByCertifiedTrue();
    List<QuestionModel> findByCertifiedFalse();
    List<QuestionModel> findByCertifiedIsNull();

	List<QuestionModel> findByTag(String tag);
    List<QuestionModel> findByIdDisciplineAndIdSubjectAndCertifiedTrue(Long idDiscipline, Long idSubject);
    List<QuestionModel> findByIdDisciplineAndCertifiedIsNull(Long idSubject);
}