package com.ifi.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifi.model.Location;
import com.ifi.repository.LocationRepository;

@Service
public class LocationService {
	
	public static final Logger logger = LoggerFactory.getLogger(LocationService.class);
	
	@Autowired
	private LocationRepository locationRepository;
	
	public List<Location> getAllLocation(){
		return locationRepository.findAll();
	}
	
	public Location getLocationById(int id) {
		return locationRepository.findOne(id);
	}
	
	public boolean addLocation(Location location) {
		Location location2 = locationRepository.save(location);
		if(location2 != null) {
			logger.info("Success");
			return true;
		}
		return false;
	}
	
	public boolean editLocation(Location location) {
		Location location2 = this.getLocationById(location.getLocationCode());
		location2.setLocationDecription(location.getLocationDecription());
		if(locationRepository.saveAndFlush(location2) != null) {
			logger.info("Success");
			return true;
		}
		return false;
	}
	
	public boolean deleteLocation(int id) {
		if(this.getLocationById(id) != null) {
			locationRepository.delete(id);
			logger.info("Success");
			return true;
		}
		return false;
	}
	
}
