package com.dio.firstProject.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import com.dio.firstProject.models.CalendarMovement;
import com.dio.firstProject.services.CalendarMovementService;

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
@RequestMapping("/calendar")
public class CalendarMovementController {
  CalendarMovementService calendarMovementService;

  @Autowired
  public CalendarMovementController(CalendarMovementService calendarMovementService) {
    this.calendarMovementService = calendarMovementService;
  }

  @PostMapping
  public CalendarMovement create(@RequestBody CalendarMovement calendarMovement) {
    return this.calendarMovementService.save(calendarMovement);
  }

  @GetMapping
  public List<CalendarMovement> listAll() {
    return this.calendarMovementService.listAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<CalendarMovement> listById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(this.calendarMovementService.listById(id)
        .orElseThrow(() -> new NoSuchElementException("Calendar movement doesn't exists!")));
  }

  @PutMapping
  public ResponseEntity<CalendarMovement> update(@RequestBody CalendarMovement calendarMovement) {
    return ResponseEntity.ok(this.calendarMovementService.update(calendarMovement));
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") Long id) {
    this.calendarMovementService.delete(id);
  }
}
