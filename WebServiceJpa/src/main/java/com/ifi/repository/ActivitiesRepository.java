package com.ifi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifi.model.Activities;

@Repository
public interface ActivitiesRepository extends JpaRepository<Activities, Integer>{
}
