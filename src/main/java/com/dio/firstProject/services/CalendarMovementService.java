package com.dio.firstProject.services;

import java.util.List;
import java.util.Optional;

import com.dio.firstProject.models.CalendarMovement;
import com.dio.firstProject.repositories.CalendarMovementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalendarMovementService {
  CalendarMovementRepository calendarMovementRepository;

  @Autowired
  public CalendarMovementService(CalendarMovementRepository calendarMovementRepository) {
    this.calendarMovementRepository = calendarMovementRepository;
  }

  public CalendarMovement save(CalendarMovement calendarMovement) {
    return this.calendarMovementRepository.save(calendarMovement);
  }

  public List<CalendarMovement> listAll() {
    return this.calendarMovementRepository.findAll();
  }

  public Optional<CalendarMovement> listById(Long id) {
    return this.calendarMovementRepository.findById(id);
  }

  public CalendarMovement update(CalendarMovement calendarMovement) {
    return this.calendarMovementRepository.save(calendarMovement);
  }

  public void delete(Long id) {
    this.calendarMovementRepository.deleteById(id);
  }
}
