package com.dio.firstProject.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import com.dio.firstProject.models.Location;
import com.dio.firstProject.services.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
public class LocationController {
  LocationService locationService;

  @Autowired
  public LocationController(LocationService locationService) {
    this.locationService = locationService;
  }

  @PostMapping
  public Location save(@RequestBody Location location) {
    return this.locationService.save(location);
  }

  @GetMapping
  public List<Location> listAll() {
    return this.locationService.listAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Location> listById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(
        this.locationService.listById(id).orElseThrow(() -> new NoSuchElementException("Location doesn't exists!")));
  }

  @PutMapping
  public ResponseEntity<Location> update(@RequestBody Location location) {
    return ResponseEntity.ok(this.locationService.update(location));
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") Long id) {
    this.locationService.delete(id);
  }
}
