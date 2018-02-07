package com.ifi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifi.model.Activity;
import com.ifi.model.ActivityCode;
import com.ifi.model.Employee;

@Repository
public interface ActivitieCodeRepository extends JpaRepository<ActivityCode, Integer>{

}
