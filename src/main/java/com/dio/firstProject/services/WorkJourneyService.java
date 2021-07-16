package com.dio.firstProject.services;

import java.util.List;
import java.util.Optional;

import com.dio.firstProject.models.WorkJourney;
import com.dio.firstProject.repositories.WorkJourneyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkJourneyService {

  WorkJourneyRepository workJourneyRepository;

  @Autowired
  public WorkJourneyService(WorkJourneyRepository workJourneyRepository) {
    this.workJourneyRepository = workJourneyRepository;
  }

  public WorkJourney save(WorkJourney workJourney) {
    return this.workJourneyRepository.save(workJourney);
  }

  public List<WorkJourney> listAll() {
    return this.workJourneyRepository.findAll();
  }

  public Optional<WorkJourney> listById(Long id) {
    return this.workJourneyRepository.findById(id);
  }

  public WorkJourney update(WorkJourney workJourney) {

    return this.workJourneyRepository.save(workJourney);
  }

  public void delete(Long id) {
    this.workJourneyRepository.deleteById(id);
  }
}
