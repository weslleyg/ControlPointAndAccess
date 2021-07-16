package com.dio.firstProject.repositories;

import com.dio.firstProject.models.DateType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTypeRepository extends JpaRepository<DateType, Long> {
}
