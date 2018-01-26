package com.ifi.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ifi.entity.Employee;
import com.ifi.service.EmployeeService;

@Component
public class EmployeeComponent implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(EmployeeComponent.class);

	@Autowired
	private EmployeeService employeeSercice;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		log.info("====================================");
		log.info("====================Adding new employee====================");
		Employee emp = new Employee("diep", "anhdiep98hk@gmail.com", "Nam dinh", "01646518080", true);
		employeeSercice.insert(emp);
		log.info("Inserted " + emp);

		log.info("====================================");
		log.info("====================Find employee with id 1====================");
		Employee empFind = employeeSercice.findEmployee(1);
		log.info(empFind.toString());
		log.info("====================================");
		log.info("====================Display all employee====================");
		for (Employee e : employeeSercice.findAll()) {
			log.info(e.toString());
		}
		log.info("====================================");
		log.info("====================Update====================");
		if (employeeSercice.findEmployee(4) != null) {
			Employee empFindUpdate = employeeSercice.findEmployee(4);
			log.info("Update for " + empFindUpdate.toString());

			Employee empUpdate = new Employee(empFindUpdate.getId(), "name", "email", "address", "phone", true);
			employeeSercice.update(empUpdate);
			log.info("updated " + empUpdate.toString());
		}else {
			log.error("not exists");
		}

		log.info("====================================");
		log.info("====================Delete====================");
		if (employeeSercice.findEmployee(5) != null) {
			long idDel = employeeSercice.delete(5);
			log.info("Deleted " + idDel);
		}else {
			log.error("not exists");
		}
	}

}
