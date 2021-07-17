package com.dio.firstProject.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import com.dio.firstProject.models.HoursBank;
import com.dio.firstProject.services.HoursBankService;

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
@RequestMapping("/hours")
public class HoursBankController {
  HoursBankService hoursBankService;

  @Autowired
  public HoursBankController(HoursBankService hoursBankService) {
    this.hoursBankService = hoursBankService;
  }

  @PostMapping
  public HoursBank create(@RequestBody HoursBank hoursBank) {
    return this.hoursBankService.save(hoursBank);
  }

  @GetMapping
  public List<HoursBank> listAll() {
    return this.hoursBankService.listAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<HoursBank> listById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(
        this.hoursBankService.listById(id).orElseThrow(() -> new NoSuchElementException("Hours bank doesn't exists!")));
  }

  @PutMapping
  public ResponseEntity<HoursBank> update(@RequestBody HoursBank hoursBank) {
    return ResponseEntity.ok(this.hoursBankService.update(hoursBank));
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") Long id) {
    this.hoursBankService.delete(id);
  }
}
