package com.ifi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifi.model.CostCenter;

@Repository
public interface CostCenterRepository extends JpaRepository<CostCenter, Integer>{

}
