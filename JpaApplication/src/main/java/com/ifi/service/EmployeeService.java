package com.ifi.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ifi.entity.Employee;

@Repository
@Transactional
public class EmployeeService {
	
	@PersistenceContext
	private EntityManager em;
	
	public long insert(Employee employee) {
		em.persist(employee);
		return employee.getId();
	}
	
	public Employee findEmployee(long id) {
		return em.find(Employee.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> findAll(){
		String hql = "FROM Employee";
		return em.createQuery(hql).getResultList();
	}
	
	public void update(Employee emp) {
		Employee e = this.findEmployee(emp.getId());
		e.setName(emp.getName());
		e.setEmail(emp.getEmail());
		e.setAddress(emp.getAddress());
		e.setPhone(emp.getPhone());
		e.setGender(emp.isGender());
		em.flush();
	}
	
	public long delete(long id) {
		em.remove(findEmployee(id));
		return id;
	}
}
