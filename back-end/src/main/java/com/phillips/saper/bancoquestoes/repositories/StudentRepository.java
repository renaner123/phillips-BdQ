package com.phillips.saper.bancoquestoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phillips.saper.bancoquestoes.models.StudentModel;

public interface StudentRepository extends JpaRepository<StudentModel, Long> {

    boolean existsByCpf(String cpf);

}