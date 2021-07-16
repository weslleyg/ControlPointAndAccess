package com.dio.firstProject.services;

import java.util.List;
import java.util.Optional;

import com.dio.firstProject.models.AccessLevel;
import com.dio.firstProject.repositories.AccessLevelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessLevelService {
  AccessLevelRepository accessLevelRepository;

  @Autowired
  public AccessLevelService(AccessLevelRepository accessLevelRepository) {
    this.accessLevelRepository = accessLevelRepository;
  }

  public AccessLevel save(AccessLevel accessLevel) {
    return this.accessLevelRepository.save(accessLevel);
  }

  public List<AccessLevel> listAll() {
    return this.accessLevelRepository.findAll();
  }

  public Optional<AccessLevel> listById(Long id) {
    return this.accessLevelRepository.findById(id);
  }

  public AccessLevel update(AccessLevel accessLevel) {
    return this.accessLevelRepository.save(accessLevel);
  }

  public void delete(Long id) {
    this.accessLevelRepository.deleteById(id);
  }
}
