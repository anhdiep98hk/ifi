package com.ifi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifi.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{

}
