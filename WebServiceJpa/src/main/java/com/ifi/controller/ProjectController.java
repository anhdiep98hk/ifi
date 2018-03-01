package com.ifi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ifi.model.Employees;
import com.ifi.model.Location;
import com.ifi.model.Projects;
import com.ifi.service.EmployeesService;
import com.ifi.service.LocationService;
import com.ifi.service.ProjectService;

@RestController
@RequestMapping(value = "/api")
public class ProjectController {

	private static final Logger log = LoggerFactory.getLogger(ProjectController.class);

	@Autowired
	ProjectService projectService;

	@Autowired
	EmployeesService employeeService;

	@Autowired
	LocationService locationService;

	@GetMapping(value = "/project")
	public ResponseEntity<List<Projects>> getAllProject() {
		List<Projects> lst = projectService.getAllProject();
		if (lst.isEmpty()) {
			return new ResponseEntity<List<Projects>>(lst, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Projects>>(lst, HttpStatus.OK);
	}

	@GetMapping(value = "/project/{id}")
	public ResponseEntity<Projects> getProjectById(@PathVariable("id") int id) {
		Projects projects = projectService.getProjectById(id);
		return new ResponseEntity<Projects>(projects, HttpStatus.OK);
	}

	// @PostMapping(value = "/project" , produces = { MediaType.ALL_VALUE,
	// MediaType.ALL_VALUE})
	// public ResponseEntity<?> createProject(@RequestParam(value = "employees") int
	// empId,@RequestParam(value = "location") int locationId,@RequestParam(value =
	// "endDate") long endDate,@RequestParam(value = "otherDetails") String
	// otherDetails,@RequestParam(value = "startDate") long startDate ,
	// UriComponentsBuilder builder) throws Exception{
	// @PostMapping(value = "/project" , produces = {
	// MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_VALUE })
	// public ResponseEntity<?> createProject(@RequestBody Projects projects,
	// UriComponentsBuilder builder){
	// boolean flag = projectService.addProject(projects);
	// if(flag == false) {
	// return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	// }
	// HttpHeaders headers = new HttpHeaders();
	// headers.setLocation(builder.path("/api/project/{id}").buildAndExpand(projects.getProjectId()).toUri());
	// return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	// }
	// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	//
	// Date dEnd = new Date(endDate);
	// Date dStart = new Date(startDate);
	//
	// Employees employees = employeeService.getEmployeeById(empId);
	// Location location = locationService.getLocationById(locationId);
	//
	//
	// Projects projects = new Projects(employees, location, dEnd, otherDetails,
	// dStart);
	//
	// boolean flag = projectService.addProject(projects);
	// if(flag == false) {
	// return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	// }
	// HttpHeaders headers = new HttpHeaders();
	// headers.setLocation(builder.path("/api/project/{id}").buildAndExpand(projects.getProjectId()).toUri());
	// return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	// }

	// @PostMapping(value = "/project")
	@RequestMapping(method = RequestMethod.POST, value = "/project")
	public ResponseEntity<?> createProject(@RequestParam(value = "employees") int empId,

			@RequestParam(value = "location") int locationId, @RequestParam(value = "endDate") long endDate,

			@RequestParam(value = "otherDetails") String otherDetails,

			@RequestParam(value = "startDate") long startDate, UriComponentsBuilder builder) {

		Date dEnd = new Date(endDate);
		Date dStart = new Date(startDate);

		Employees employees = employeeService.getEmployeeById(empId);
		Location location = locationService.getLocationById(locationId);

		Projects projects = new Projects(employees, location, dEnd, otherDetails, dStart);
		boolean flag = projectService.addProject(projects);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/api/project/{id}").buildAndExpand(projects.getProjectId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping(value = "/project")
	public ResponseEntity<?> updateProject(int projectId,
			int employees,

			 int location, long endDate,

			String otherDetails,

			 long startDate) {

		Date dEnd = new Date(endDate);
		Date dStart = new Date(startDate);

		Employees x = employeeService.getEmployeeById(employees);
		Location y = locationService.getLocationById(location);

		Projects projects = new Projects(projectId,x, y, dEnd, otherDetails, dStart);
		
		try {
			projectService.editProject(projects);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Projects>(projects, HttpStatus.OK);
	}

	@DeleteMapping(value = "/project/{id}")
	public ResponseEntity<?> deleteProject(@PathVariable("id") int id) {
		projectService.deleteProject(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
