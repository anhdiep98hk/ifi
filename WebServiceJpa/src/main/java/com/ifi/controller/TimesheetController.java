package com.ifi.controller;

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

import com.ifi.model.Timesheets;
import com.ifi.service.TimesheetsService;

@RestController
@RequestMapping(value = "/api")
public class TimesheetController {
	
	@Autowired
	TimesheetsService timesheetService;
	
	@GetMapping(value = "/timesheet")
	public ResponseEntity<List<Timesheets>> getAllTimesheet(){
		List<Timesheets> lst = timesheetService.getAllTimesheet();
		if(lst.isEmpty()) {
			return new ResponseEntity<List<Timesheets>>(lst,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Timesheets>>(lst, HttpStatus.OK);
	}
	@GetMapping(value = "/timesheet/{id}")
	public ResponseEntity<Timesheets> getTimesheetById(@PathVariable("id") int id){
		Timesheets timesheets = timesheetService.getTimesheetById(id);
		return new ResponseEntity<Timesheets>(timesheets, HttpStatus.OK);
	}
	@PostMapping(value = "/timesheet" , produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> createTimesheet(@RequestBody Timesheets timesheets, UriComponentsBuilder builder){
		boolean flag = timesheetService.addTimesheet(timesheets);
		if(flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/api/timesheet/{id}").buildAndExpand(timesheets.getTimesheetId()).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/timesheet")
	public ResponseEntity<?> updateTimesheet(@RequestBody Timesheets timesheet){
		try {
			timesheetService.editProject(timesheet);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Timesheets>(timesheet, HttpStatus.OK);
	}
	@DeleteMapping(value="/timesheet/{id}")
	public ResponseEntity<?> deleteTimesheet(@PathVariable("id") int id){
		timesheetService.deleteProject(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
