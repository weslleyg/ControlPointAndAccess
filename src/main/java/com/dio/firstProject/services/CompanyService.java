package com.dio.firstProject.services;

import java.util.List;
import java.util.Optional;

import com.dio.firstProject.models.Company;
import com.dio.firstProject.repositories.CompanyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
  CompanyRepository companyRepository;

  @Autowired
  public CompanyService(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  public Company save(Company company) {
    return this.companyRepository.save(company);
  }

  public List<Company> listAll() {
    return this.companyRepository.findAll();
  }

  public Optional<Company> listById(Long id) {
    return this.companyRepository.findById(id);
  }

  public Company update(Company company) {
    return this.companyRepository.save(company);
  }

  public void delete(Long id) {
    this.companyRepository.deleteById(id);
  }

}
