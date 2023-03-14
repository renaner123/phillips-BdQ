package com.phillips.saper.bancoquestoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phillips.saper.bancoquestoes.models.TestModel;

public interface TestRepository extends JpaRepository<TestModel, Long> {

}
