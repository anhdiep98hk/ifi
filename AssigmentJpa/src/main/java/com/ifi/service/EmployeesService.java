package com.ifi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifi.model.Employee;
import com.ifi.repository.EmployeesRepository;

@Service
public class EmployeesService {

	@Autowired
	private EmployeesRepository employeesRepository;

	public List<Employee> getAllEmployee() {
		return employeesRepository.findAll();
	}

	public Employee getEmployeeById(int id) {
		return employeesRepository.findOne(id);
	}

	public boolean addEmployee(Employee employee) {
		if (employeesRepository.save(employee) != null) {
			return true;
		}
		return false;
	}

	public boolean editEmployee(Employee employee) {
		Employee employee2 = this.getEmployeeById(employee.getEmployeeId());
		if (employee2 != null) {
			employee2.setEndDate(employee.getEndDate());
			employee2.setOtherDetails(employee.getOtherDetails());
			employee2.setStartDate(employee.getStartDate());

			if (employeesRepository.saveAndFlush(employee2) != null) {
				return true;
			}
		}
		return false;
	}

	public boolean deleteEmployee(int id) {
		if (this.getEmployeeById(id) != null) {
			employeesRepository.delete(id);
			return true;
		}
		return false;
	}

}
