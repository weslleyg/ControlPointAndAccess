package com.dio.firstProject.services;

import java.util.List;

import com.dio.firstProject.models.Movement;
import com.dio.firstProject.repositories.MovementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovementService {
  MovementRepository movementRepository;

  @Autowired
  public MovementService(MovementRepository movementRepository) {
    this.movementRepository = movementRepository;
  }

  public Movement save(Movement movement) {
    return this.movementRepository.save(movement);
  }

  public List<Movement> listAll() {
    return this.movementRepository.findAll();
  }

  public Movement update(Movement movement) {
    return this.movementRepository.save(movement);
  }
}
