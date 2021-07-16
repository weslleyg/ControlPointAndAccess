package com.dio.firstProject.repositories;

import com.dio.firstProject.models.Occurrence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccurrenceRepository extends JpaRepository<Occurrence, Long> {

}
