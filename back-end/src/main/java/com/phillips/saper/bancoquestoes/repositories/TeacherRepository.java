package com.phillips.saper.bancoquestoes.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phillips.saper.bancoquestoes.models.TeacherModel;

public interface TeacherRepository extends JpaRepository<TeacherModel, Long> {

    Optional<TeacherModel> findByName(String username);

}
