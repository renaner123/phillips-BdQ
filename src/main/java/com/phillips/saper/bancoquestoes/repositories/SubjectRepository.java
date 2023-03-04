package com.phillips.saper.bancoquestoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phillips.saper.bancoquestoes.models.SubjectModel;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectModel, Long> {

}