package com.dio.firstProject.repositories;

import com.dio.firstProject.models.Movement;
import com.dio.firstProject.models.Movement.MovementId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository<Movement, MovementId> {
}
