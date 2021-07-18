package com.dio.firstProject.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import com.dio.firstProject.models.DateType;
import com.dio.firstProject.services.DateTypeService;

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
@RequestMapping("/date")
public class DateTypeController {
  DateTypeService dateTypeService;

  @Autowired
  public DateTypeController(DateTypeService dateTypeService) {
    this.dateTypeService = dateTypeService;
  }

  @PostMapping
  public DateType create(@RequestBody DateType dateType) {
    return this.dateTypeService.save(dateType);
  }

  @GetMapping
  public List<DateType> listAll() {
    return this.dateTypeService.listAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<DateType> listById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(
        this.dateTypeService.listById(id).orElseThrow(() -> new NoSuchElementException("Date type doesn't exists!")));
  }

  @PutMapping
  public ResponseEntity<DateType> update(@RequestBody DateType dateType) {
    return ResponseEntity.ok(this.dateTypeService.update(dateType));
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") Long id) {
    this.dateTypeService.delete(id);
  }
}
