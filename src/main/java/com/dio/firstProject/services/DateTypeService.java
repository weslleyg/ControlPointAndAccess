package com.dio.firstProject.services;

import java.util.List;
import java.util.Optional;

import com.dio.firstProject.models.DateType;
import com.dio.firstProject.repositories.DateTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DateTypeService {
  DateTypeRepository dateTypeRepository;

  @Autowired
  public DateTypeService(DateTypeRepository dateTypeRepository) {
    this.dateTypeRepository = dateTypeRepository;
  }

  public DateType save(DateType dateType) {
    return this.dateTypeRepository.save(dateType);
  }

  public List<DateType> listAll() {
    return this.dateTypeRepository.findAll();
  }

  public Optional<DateType> listById(Long id) {
    return this.dateTypeRepository.findById(id);
  }

  public DateType update(DateType dateType) {
    return this.dateTypeRepository.save(dateType);
  }

  public void delete(Long id) {
    this.dateTypeRepository.deleteById(id);
  }
}
