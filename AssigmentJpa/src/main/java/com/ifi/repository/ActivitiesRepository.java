package com.ifi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifi.model.Activity;

@Repository
public interface ActivitiesRepository extends JpaRepository<Activity, Integer>{

}
