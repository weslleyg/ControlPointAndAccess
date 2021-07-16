package com.dio.firstProject.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import com.dio.firstProject.models.AccessLevel;
import com.dio.firstProject.services.AccessLevelService;

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
@RequestMapping("/access")
public class AccessLevelController {
  AccessLevelService accessLevelService;

  @Autowired
  public AccessLevelController(AccessLevelService accessLevelService) {
    this.accessLevelService = accessLevelService;
  }

  @PostMapping
  public AccessLevel create(@RequestBody AccessLevel accessLevel) {
    return this.accessLevelService.save(accessLevel);
  }

  @GetMapping
  public List<AccessLevel> listAll() {
    return this.accessLevelService.listAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<AccessLevel> listById(@PathVariable Long id) {
    return ResponseEntity.ok(this.accessLevelService.listById(id)
        .orElseThrow(() -> new NoSuchElementException("Access level doesn't exists!")));
  }

  @PutMapping
  public ResponseEntity<AccessLevel> update(@RequestBody AccessLevel accessLevel) {
    return ResponseEntity.ok(this.accessLevelService.update(accessLevel));
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") Long id) {
    this.accessLevelService.delete(id);
  }
}
