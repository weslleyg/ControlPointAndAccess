package com.dio.firstProject.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import com.dio.firstProject.models.Movement;
import com.dio.firstProject.services.MovementService;

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
@RequestMapping("/movement")
public class MovementController {
  MovementService movementService;

  @Autowired
  public MovementController(MovementService movementService) {
    this.movementService = movementService;
  }

  @PostMapping
  public Movement create(@RequestBody Movement movement) {
    return this.movementService.save(movement);
  }

  @GetMapping
  public List<Movement> listAll() {
    return this.movementService.listAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Movement> listById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(
        this.movementService.listById(id).orElseThrow(() -> new NoSuchElementException("Movement doesn't exists!")));
  }

  @PutMapping
  public ResponseEntity<Movement> update(@RequestBody Movement movement) {
    return ResponseEntity.ok(this.movementService.update(movement));
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    this.movementService.delete(id);
  }
}
