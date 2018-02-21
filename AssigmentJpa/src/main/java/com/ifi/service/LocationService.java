package com.ifi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifi.model.Location;
import com.ifi.repository.LocationRepository;

@Service
public class LocationService {
	
	@Autowired
	private LocationRepository locationRepository;
	
	public List<Location> getAllLocation(){
		return locationRepository.findAll();
	}
	
	public Location getLocationById(int id) {
		return locationRepository.findOne(id);
	}
	
	public boolean addLocation(Location location) {
		if(locationRepository.save(location) != null) {
			return true;
		}
		return false;
	}
	
	public boolean editLocation(Location location) {
		Location location2 = this.getLocationById(location.getLocationCode());
		location2.setLocationDecription(location.getLocationDecription());
		if(locationRepository.saveAndFlush(location2) != null) {
			return true;
		}
		return false;
	}
	
	public boolean deleteLocation(int id) {
		if(this.getLocationById(id) != null) {
			locationRepository.delete(id);
			return true;
		}
		return false;
	}
	
}
