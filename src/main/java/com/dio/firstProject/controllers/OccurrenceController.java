package com.dio.firstProject.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import com.dio.firstProject.models.Occurrence;
import com.dio.firstProject.services.OccurrenceService;

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
@RequestMapping("/occurrence")
public class OccurrenceController {
  OccurrenceService occurrenceService;

  @Autowired
  public OccurrenceController(OccurrenceService occurrenceService) {
    this.occurrenceService = occurrenceService;
  }

  @PostMapping
  public Occurrence create(@RequestBody Occurrence occurrence) {
    return this.occurrenceService.save(occurrence);
  }

  @GetMapping
  public List<Occurrence> listAll() {
    return this.occurrenceService.listAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Occurrence> listById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(
        this.occurrenceService.listById(id).orElseThrow(() -> new NoSuchElementException("Occurrence doesn't exist!")));
  }

  @PutMapping
  public ResponseEntity<Occurrence> update(@RequestBody Occurrence occurrence) {
    return ResponseEntity.ok(this.occurrenceService.update(occurrence));
  }

  @DeleteMapping("/id")
  public void delete(@PathVariable Long id) {
    this.occurrenceService.delete(id);
  }

}
