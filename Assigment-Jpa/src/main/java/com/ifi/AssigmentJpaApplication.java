package com.ifi;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.ifi.model.Activity;
import com.ifi.model.Employee;
import com.ifi.model.Location;
import com.ifi.model.Project;
import com.ifi.repository.LocationRepository;
import com.ifi.repository.ActivityRepository;
import com.ifi.repository.EmployeeRepository;

@SpringBootApplication
public class AssigmentJpaApplication implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(AssigmentJpaApplication.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	private ActivityRepository activityRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AssigmentJpaApplication.class, args);
	}

	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Location location = new Location("Airport");
		Employee employee = new Employee(new Date("12/10/2017"),"other details 1 is first", new Date("11/09/2017"));
		
//		Project project = new Project(new Date(2017/12/11),"other details of project", new Date(2017/10/02),location,employee);
		Project project = new Project();
		project.setEmployee(employee);
		project.setEndDate(new Date("13/12/2017"));
		project.setLocation(location);
		project.setOtherDetails("Ohter details for project");
		project.setStartDate(new Date("02/14/2017"));
		Set<Activity> activityAs = new HashSet<Activity>() {{
			add(new Activity(new Date("12/10/2017"),"ohter details for activity",new Date("02/01/2017"),project));
			add(new Activity(new Date("12/10/2017"),"ohter details for activity",new Date("02/01/2017"),project));
		}};
		project.setActivities(activityAs);
		

		
		
		
		employeeRepository.save(employee);
		locationRepository.save(location);
		activityRepository.save(activityAs);
		
		System.out.println(project.toString());
	}
}
