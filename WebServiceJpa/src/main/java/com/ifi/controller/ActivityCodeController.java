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

import com.ifi.model.ActivityCodes;
import com.ifi.service.ActivityCodeService;

@RestController
@RequestMapping(value = "/api")
public class ActivityCodeController {
	@Autowired
	private ActivityCodeService activityCodeService;
	
	@GetMapping(value = "/activitycode")
	public ResponseEntity<List<ActivityCodes>> getAllActivityCode(){
		List<ActivityCodes> lst = activityCodeService.getAllActivityCode();
		if(lst.isEmpty()) {
			return new ResponseEntity<List<ActivityCodes>>(lst, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ActivityCodes>>(lst, HttpStatus.OK);
	}
	
	@GetMapping(value = "/activitycode/{id}")
	public ResponseEntity<ActivityCodes> getActivityCodeById(@PathVariable("id") int id){
		ActivityCodes activityCodes =  activityCodeService.getActivityCodeById(id);
		return new ResponseEntity<ActivityCodes>(activityCodes, HttpStatus.OK);
	}
	
	@PostMapping(value = "/activitycode")
	public ResponseEntity<?> createActivityCode(@RequestBody ActivityCodes activityCodes, UriComponentsBuilder builder){
		boolean flag = activityCodeService.addActivityCode(activityCodes);
		if(flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/api/activitycode/{id}").buildAndExpand(activityCodes.getActivityCode()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/activitycode")
	public ResponseEntity<?> updateActivityCode(@RequestBody ActivityCodes activityCodes){
		activityCodeService.editActivityCode(activityCodes);
		return new ResponseEntity<ActivityCodes>(activityCodes,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/activitycode/{id}")
	public ResponseEntity<?> deleteActivityCode(@PathVariable("id") int id){
		activityCodeService.deleteActivityCode(id);
		return new  ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
