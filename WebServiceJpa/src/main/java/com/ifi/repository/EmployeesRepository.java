package com.ifi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifi.model.Employees;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer>{

}
