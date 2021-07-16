package com.dio.firstProject.services;

import java.util.List;
import java.util.Optional;

import com.dio.firstProject.models.Occurrence;
import com.dio.firstProject.repositories.OccurrenceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OccurrenceService {
  OccurrenceRepository occurrenceRepository;

  @Autowired
  public OccurrenceService(OccurrenceRepository occurrenceRepository) {
    this.occurrenceRepository = occurrenceRepository;
  }

  public Occurrence save(Occurrence occurrence) {
    return this.occurrenceRepository.save(occurrence);
  }

  public List<Occurrence> listAll() {
    return this.occurrenceRepository.findAll();
  }

  public Optional<Occurrence> listById(Long id) {
    return this.occurrenceRepository.findById(id);
  }

  public Occurrence update(Occurrence occurrence) {
    return this.occurrenceRepository.save(occurrence);
  }

  public void delete(Long id) {
    this.occurrenceRepository.deleteById(id);
  }
}
