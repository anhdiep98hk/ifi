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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ifi.model.Employees;
import com.ifi.model.Location;
import com.ifi.model.Projects;
import com.ifi.service.EmployeesService;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {
	@Autowired
	private EmployeesService employeesService;

	@GetMapping(value = "/employee")
	public ResponseEntity<List<Employees>> getAllEmployee() {
		List<Employees> lst = employeesService.getAllEmployee();
		if (lst.isEmpty()) {
			return new ResponseEntity<List<Employees>>(lst, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Employees>>(lst, HttpStatus.OK);
	}

	@GetMapping(value = "/employee/{id}")
	public ResponseEntity<Employees> getEmployeeById(@PathVariable("id") int id) {
		Employees employees = employeesService.getEmployeeById(id);
		return new ResponseEntity<Employees>(employees, HttpStatus.OK);
	}

	// @PostMapping(value = "/employee",produces = { MediaType.ALL_VALUE,
	// MediaType.ALL_VALUE })
	@RequestMapping(method = RequestMethod.POST, value = "/employee")
	public ResponseEntity<?> createEmployee(long endDate, String otherDetails, long startDate,
			UriComponentsBuilder builder) {
		Date eD = new Date(endDate);
		Date sD = new Date(startDate);
		Employees employees = new Employees(eD, otherDetails, sD);
		boolean flag = employeesService.addEmployee(employees);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/api/employee/{id}").buildAndExpand(employees.getEmployeeId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	// @PostMapping(value = "/employee")
	// public ResponseEntity<?> createEmployee(Employees employees,
	// UriComponentsBuilder builder){
	// boolean flag = employeesService.addEmployee(employees);
	// if(flag == false) {
	// return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	// }
	// HttpHeaders headers = new HttpHeaders();
	// headers.setLocation(builder.path("/api/employee/{id}").buildAndExpand(employees.getEmployeeId()).toUri());
	// return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	// }

	@PutMapping(value = "/employee")
	public ResponseEntity<?> updateEmployee(@RequestParam(value = "employeeId") int employeeId,
			@RequestParam("endDate") long endDate,@RequestParam("otherDetails") String otherDetails,@RequestParam("startDate") long startDate) {
		Date eD = new Date(endDate);
		Date sD = new Date(startDate);
		Employees employees = new Employees(employeeId, eD, otherDetails, sD);
		employeesService.editEmployee(employees);
		return new ResponseEntity<Employees>(employees, HttpStatus.OK);
	}

	@DeleteMapping(value = "/employee/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id) {
		employeesService.deleteEmployee(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
