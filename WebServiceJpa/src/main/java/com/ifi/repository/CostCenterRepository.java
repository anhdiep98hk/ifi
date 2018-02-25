package com.ifi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifi.model.CostCenters;

@Repository
public interface CostCenterRepository extends JpaRepository<CostCenters, Integer>{

}
