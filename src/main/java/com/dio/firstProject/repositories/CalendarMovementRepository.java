package com.dio.firstProject.repositories;

import com.dio.firstProject.models.CalendarMovement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarMovementRepository extends JpaRepository<CalendarMovement, Long> {
}
