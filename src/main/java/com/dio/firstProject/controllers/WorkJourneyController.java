package com.dio.firstProject.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import com.dio.firstProject.models.WorkJourney;
import com.dio.firstProject.services.WorkJourneyService;

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
@RequestMapping("/journey")
public class WorkJourneyController {

  @Autowired
  WorkJourneyService workJourneyService;

  @PostMapping
  public WorkJourney create(@RequestBody WorkJourney workJourney) {
    return this.workJourneyService.save(workJourney);
  }

  @GetMapping
  public List<WorkJourney> listAll() {
    return this.workJourneyService.listAll();
  }

  // GetMapping("/{id}") @PathVariable("id")
  @GetMapping("/{id}")
  public ResponseEntity<WorkJourney> listById(@PathVariable("id") Long id) throws Exception {
    return ResponseEntity.ok(this.workJourneyService.listById(id)
        .orElseThrow(() -> new NoSuchElementException("Work journey doesn't exists!")));
  }

  @PutMapping
  public ResponseEntity<WorkJourney> update(@RequestBody WorkJourney workJourney) {
    return ResponseEntity.ok(this.workJourneyService.update(workJourney));
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") Long id) {
    this.workJourneyService.delete(id);
  }
}
