package com.ifi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ifi.model.CostCenters;
import com.ifi.service.CostCenterService;


@RestController
@RequestMapping(value = "/api")
public class CostController {
	
	@Autowired
	private CostCenterService costCenterService;
	
	
	@GetMapping(value = "/cost")
	public ResponseEntity<List<CostCenters>> getAllCost(){
		List<CostCenters> lst = costCenterService.getAllCost();
		if(lst.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CostCenters>>(lst, HttpStatus.OK);
	}
	
	@GetMapping(value = "/cost/{id}")
	public ResponseEntity<?> getCost(@PathVariable("id") int id){
		CostCenters costCenters = costCenterService.getCostById(id);
		return new ResponseEntity<CostCenters>(costCenters, HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/cost")
	public ResponseEntity<?> addCost(@RequestBody CostCenters costCenters, UriComponentsBuilder builder){
		boolean flag = costCenterService.addCost(costCenters);
		if(flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/api/cost/{id}").buildAndExpand(costCenters.getCostCenterId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/cost")
	public ResponseEntity<CostCenters> updateCost(@RequestBody CostCenters costCenters){
		costCenterService.editCost(costCenters);
		return new ResponseEntity<CostCenters>(costCenters, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/cost/{id}")
	public ResponseEntity<?> deleteCost(@PathVariable("id") int id){
		costCenterService.deleteCost(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
			
}
