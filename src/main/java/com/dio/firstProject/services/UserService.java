package com.dio.firstProject.services;

import java.util.List;
import java.util.Optional;

import com.dio.firstProject.models.User;
import com.dio.firstProject.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User save(User user) {
    return this.userRepository.save(user);
  }

  public List<User> listAll() {
    return this.userRepository.findAll();
  }

  public Optional<User> listById(Long id) {
    return this.userRepository.findById(id);
  }

  public User update(User user) {
    return this.userRepository.save(user);
  }

  public void delete(Long id) {
    this.userRepository.deleteById(id);
  }
}
