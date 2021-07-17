package com.dio.firstProject.services;

import java.util.List;
import java.util.Optional;

import com.dio.firstProject.models.Location;
import com.dio.firstProject.repositories.LocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
  LocationRepository locationRepository;

  @Autowired
  public LocationService(LocationRepository locationRepository) {
    this.locationRepository = locationRepository;
  }

  public Location save(Location location) {
    return this.locationRepository.save(location);
  }

  public List<Location> listAll() {
    return this.locationRepository.findAll();
  }

  public Optional<Location> listById(Long id) {
    return this.locationRepository.findById(id);
  }

  public Location update(Location location) {
    return this.locationRepository.save(location);
  }

  public void delete(Long id) {
    this.locationRepository.deleteById(id);
  }
}
