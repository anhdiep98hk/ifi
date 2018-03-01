package com.ifi.controller;

import java.util.Date;
import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ifi.model.Activities;
import com.ifi.model.ActivityCodes;
import com.ifi.model.Projects;
import com.ifi.service.ActivityCodeService;
import com.ifi.service.ActivityService;
import com.ifi.service.ProjectService;

@RestController
@RequestMapping(value = "/api")
public class ActivityController {
	
	@Autowired
	ActivityService activityService;
	@Autowired
	ActivityCodeService activityCodeService;
	@Autowired
	ProjectService projectService;
	
	@GetMapping(value = "/activity")
	public ResponseEntity<List<Activities>> getAllActivity(){
		List<Activities> lst = activityService.getAllActivity();
		if(lst.isEmpty()) {
			return new ResponseEntity<List<Activities>>(lst,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Activities>>(lst, HttpStatus.OK);
	}
	@GetMapping(value = "/activity/{id}")
	public ResponseEntity<Activities> getActivityById(@PathVariable("id") int id){
		Activities activities = activityService.getActivityById(id);
		return new ResponseEntity<Activities>(activities, HttpStatus.OK);
	}
	@PostMapping(value = "/activity")
	public ResponseEntity<?> createActivity(int activityCodes, int projects, long endDate, long startDate, String otherDetails, UriComponentsBuilder builder){
		
		ActivityCodes codes = activityCodeService.getActivityCodeById(activityCodes);
		Projects projects2 = projectService.getProjectById(projects);
		
		Date dEnd = new Date(endDate);
		Date dStart = new Date(startDate);
		
		Activities activities = new Activities(codes, projects2, dEnd, otherDetails, dStart);
		
		boolean flag = activityService.addActivity(activities);
		if(flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/api/activity/{id}").buildAndExpand(activities.getActivityId()).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/activity")
	public ResponseEntity<?> updateActivity(int activityId,int activityCodes, int projects, long endDate, long startDate, String otherDetails){
		
		ActivityCodes codes = activityCodeService.getActivityCodeById(activityCodes);
		Projects projects2 = projectService.getProjectById(projects);
		Date dEnd = new Date(endDate);
		Date dStart = new Date(startDate);
		
		Activities activities = new Activities(activityId, codes, projects2, dEnd, otherDetails, dStart);
		
		try {
			activityService.editProject(activities);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Activities>(activities, HttpStatus.OK);
	}
	@DeleteMapping(value="/activity/{id}")
	public ResponseEntity<?> deleteProject(@PathVariable("id") int id){
		activityService.deleteProject(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
