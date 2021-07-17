package com.dio.firstProject.services;

import java.util.List;
import java.util.Optional;

import com.dio.firstProject.models.HoursBank;
import com.dio.firstProject.repositories.HoursBankRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HoursBankService {
  HoursBankRepository hoursBankRepository;

  @Autowired
  public HoursBankService(HoursBankRepository hoursBankRepository) {
    this.hoursBankRepository = hoursBankRepository;
  }

  public HoursBank save(HoursBank hoursBank) {
    return this.hoursBankRepository.save(hoursBank);
  }

  public List<HoursBank> listAll() {
    return this.hoursBankRepository.findAll();
  }

  public Optional<HoursBank> listById(Long id) {
    return this.hoursBankRepository.findById(id);
  }

  public HoursBank update(HoursBank hoursBank) {
    return this.hoursBankRepository.save(hoursBank);
  }

  public void delete(Long id) {
    this.hoursBankRepository.deleteById(id);
  }
}
