package com.cognixia.jump.ccc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.ccc.model.Enrollee;

@Repository
public interface EnrolleeRepo extends JpaRepository<Enrollee, Long> {

}
