package com.ifi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifi.model.CostCenter;
import com.ifi.model.Employee;

@Repository
public interface CostCenterRepository extends JpaRepository<CostCenter, Integer>{

}
