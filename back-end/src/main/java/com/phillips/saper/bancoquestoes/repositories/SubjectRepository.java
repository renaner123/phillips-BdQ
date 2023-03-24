package com.phillips.saper.bancoquestoes.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.phillips.saper.bancoquestoes.models.SubjectModel;

public interface SubjectRepository extends JpaRepository<SubjectModel, Long> {

    List<SubjectModel> findTop5ByOrderByAmountAccessDesc();

}