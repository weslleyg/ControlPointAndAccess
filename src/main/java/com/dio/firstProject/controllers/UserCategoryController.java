package com.dio.firstProject.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import com.dio.firstProject.models.UserCategory;
import com.dio.firstProject.services.UserCategoryService;

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
@RequestMapping("/category")
public class UserCategoryController {
  UserCategoryService userCategoryService;

  @Autowired
  public UserCategoryController(UserCategoryService userCategoryService) {
    this.userCategoryService = userCategoryService;
  }

  @PostMapping
  public UserCategory create(@RequestBody UserCategory userCategory) {
    return this.userCategoryService.save(userCategory);
  }

  @GetMapping
  public List<UserCategory> listAll() {
    return this.userCategoryService.listAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserCategory> listById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(
        this.userCategoryService.listById(id).orElseThrow(() -> new NoSuchElementException("User doesn't exists!")));
  }

  @PutMapping
  public ResponseEntity<UserCategory> update(@RequestBody UserCategory userCategory) {
    return ResponseEntity.ok(this.userCategoryService.update(userCategory));
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") Long id) {
    this.userCategoryService.delete(id);
  }
}
