package com.dio.firstProject.services;

import java.util.List;
import java.util.Optional;

import com.dio.firstProject.models.UserCategory;
import com.dio.firstProject.repositories.UserCategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCategoryService {
  UserCategoryRepository userCategoryRepository;

  @Autowired
  public UserCategoryService(UserCategoryRepository userCategoryRepository) {
    this.userCategoryRepository = userCategoryRepository;
  }

  public UserCategory save(UserCategory userCategory) {
    return this.userCategoryRepository.save(userCategory);
  }

  public List<UserCategory> listAll() {
    return this.userCategoryRepository.findAll();
  }

  public Optional<UserCategory> listById(Long id) {
    return this.userCategoryRepository.findById(id);
  }

  public UserCategory update(UserCategory userCategory) {
    return this.userCategoryRepository.save(userCategory);
  }

  public void delete(Long id) {
    this.userCategoryRepository.deleteById(id);
  }
}
