package com.dio.firstProject.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import com.dio.firstProject.models.Company;
import com.dio.firstProject.services.CompanyService;

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
@RequestMapping("/company")
public class CompanyController {
  CompanyService companyService;

  @Autowired
  public CompanyController(CompanyService companyService) {
    this.companyService = companyService;
  }

  @PostMapping
  public Company create(@RequestBody Company company) {
    return this.companyService.save(company);
  }

  @GetMapping
  public List<Company> listAll() {
    return this.companyService.listAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Company> listById(@PathVariable("id") Long id) {
    return ResponseEntity
        .ok(this.companyService.listById(id).orElseThrow(() -> new NoSuchElementException("Company doesn't exists!")));
  }

  @PutMapping
  public ResponseEntity<Company> update(@RequestBody Company company) {
    return ResponseEntity.ok(this.companyService.save(company));
  }

  @DeleteMapping("/{id}")
  public void delete(Long id) {
    this.companyService.delete(id);
  }
}
