package com.dio.firstProject.repositories;

import com.dio.firstProject.models.WorkJourney;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkJourneyRepository extends JpaRepository<WorkJourney, Long> {
}
