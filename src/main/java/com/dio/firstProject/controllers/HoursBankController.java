package com.dio.firstProject.controllers;

import java.util.List;

import com.dio.firstProject.models.HoursBank;
import com.dio.firstProject.services.HoursBankService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

  @PutMapping
  public ResponseEntity<HoursBank> update(@RequestBody HoursBank hoursBank) {
    return ResponseEntity.ok(this.hoursBankService.update(hoursBank));
  }
}
