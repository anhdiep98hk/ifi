package com.ifi.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ifi.model.Location;
import com.ifi.service.LocationService;

@RestController
@RequestMapping(value = "/api")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	
	@GetMapping(value = "/location")
	public ResponseEntity<List<Location>> getAllLocation(){
		List<Location> lstLocation = locationService.getAllLocation();
		if(lstLocation.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Location>>(lstLocation, HttpStatus.OK);
	}
	
	@GetMapping(value = "/location/{id}")
	public ResponseEntity<?> getLocation(@PathVariable("id") int id){
		Location location = locationService.getLocationById(id);
		return new ResponseEntity<Location>(location, HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/location", produces = { MediaType.ALL_VALUE, MediaType.ALL_VALUE })
	public ResponseEntity<?> addLocation(Location location, UriComponentsBuilder builder){
		boolean flag = locationService.addLocation(location);
		if(flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/api/location/{id}").buildAndExpand(location.getLocationCode()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/location")
	public ResponseEntity<Location> updateLocation(@RequestBody Location location){
		locationService.editLocation(location);
		return new ResponseEntity<Location>(location, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/location/{id}")
	public ResponseEntity<?> deleteLocation(@PathVariable("id") int id){
		locationService.deleteLocation(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
			
}
