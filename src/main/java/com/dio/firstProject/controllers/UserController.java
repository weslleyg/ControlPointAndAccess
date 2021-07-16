package com.dio.firstProject.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import com.dio.firstProject.models.User;
import com.dio.firstProject.services.UserService;

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
@RequestMapping("/user")
public class UserController {
  UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public User create(@RequestBody User user) {
    return this.userService.save(user);
  }

  @GetMapping
  public List<User> listAll() {
    return this.userService.listAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> listById(@PathVariable Long id) {
    return ResponseEntity
        .ok(this.userService.listById(id).orElseThrow(() -> new NoSuchElementException("User doesn't exists!")));
  }

  @PutMapping
  public ResponseEntity<User> update(@RequestBody User user) {
    return ResponseEntity.ok(this.userService.update(user));
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    this.userService.delete(id);
  }

}
