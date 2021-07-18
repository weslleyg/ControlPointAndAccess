package com.dio.firstProject.repositories;

import com.dio.firstProject.models.HoursBank;
import com.dio.firstProject.models.HoursBank.HoursBankId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoursBankRepository extends JpaRepository<HoursBank, HoursBankId> {
}
