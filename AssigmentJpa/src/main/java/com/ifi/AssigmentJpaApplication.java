package com.ifi;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.ifi.model.Activity;
import com.ifi.model.ActivityCode;
import com.ifi.model.CostCenter;
import com.ifi.model.Employee;
import com.ifi.model.Location;
import com.ifi.model.Project;
import com.ifi.model.Timesheet;
import com.ifi.repository.ActivitieCodeRepository;
import com.ifi.repository.ActivitiesRepository;
import com.ifi.repository.CostCenterRepository;
import com.ifi.repository.EmployeesRepository;
import com.ifi.repository.LocationRepository;
import com.ifi.repository.ProjectRepository;
import com.ifi.repository.TimesheetRepository;

@SpringBootApplication
public class AssigmentJpaApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(AssigmentJpaApplication.class);

	@Autowired
	private EmployeesRepository employeesRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ActivitiesRepository activitiesRepository;

	@Autowired
	private CostCenterRepository costCenterRepository;

	@Autowired
	private TimesheetRepository timesheetRepository;

	@Autowired
	private ActivitieCodeRepository activitieCodeRepository;

	public static void main(String[] args) {
		SpringApplication.run(AssigmentJpaApplication.class, args);
	}

	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		// CostCenter costCenter = new CostCenter("cost center decription 1","Cost
		// center 1","Ohter details for costcenter 1");
		//
		// Activity activity = new Activity(sdf.parse("12/02/2017"),"Other details for
		// activity",sdf.parse("10/01/2017"));
		//

		//
		//
		// Timesheet timesheet = new Timesheet();
		// timesheet.setCostCenter(costCenter);
		// timesheet.setEmployee(employee);
		// timesheet.setEndDate(sdf.parse("20/12/2017"));
		// timesheet.setOtherDetails("Other details for timesheet");
		// timesheet.setStartDate(sdf.parse("10/11/2017"));
		// timesheet.setSubmittedDate(sdf.parse("21/12/2017"));
		// timesheet.setActivity(activity);
		//
		// activitiesRepository.save(activity);
		// costCenterRepository.save(costCenter);
		// employeesRepository.save(employee);
		//
		// timesheetRepository.save(timesheet);
		//

		/* Project */
		
		Employee employee = new Employee(sdf.parse("12/02/2017"), "Other details for employee",sdf.parse("10/01/2017"));
		Location location = new Location("Airport");
		
		
		Project project = new Project();
		project.setEmployee(employee);
		project.setLocation(location);
		project.setEndDate(sdf.parse("01/12/2012"));
		project.setOtherDetails("Others details for project update");
		project.setStartDate(sdf.parse("12/01/2013"));

		
		employeesRepository.save(employee);
		locationRepository.save(location);

		projectRepository.save(project);
/*		
//		employeesRepository.delete(20);
		locationRepository.delete(29);
		System.out.println("Deleted");

		// update
		
		if (projectRepository.findOne(2) != null) {
			Project projectUpdate = projectRepository.findOne(2);
			projectUpdate.setEmployee(employee);
			projectUpdate.setLocation(location);
			projectUpdate.setEndDate(sdf.parse("01/12/2012"));
			projectUpdate.setOtherDetails("Others details for project update");
			projectUpdate.setStartDate(sdf.parse("12/01/2013"));
			projectRepository.flush();
		}

		// delete
		if (projectRepository.findOne(2) != null) {
			projectRepository.delete(2);
		}
		*/

		/* Activities */

		ActivityCode activityCode = new ActivityCode("Project");
		
		Activity activity = new Activity();
		activity.setActivityCode(activityCode);
		activity.setProject(project);
		activity.setEndDate(sdf.parse("01/12/2012"));
		activity.setOtherDetails("Other details for activities");
		activity.setStartDate(sdf.parse("12/11/2012"));

		activitieCodeRepository.save(activityCode);
//		projectRepository.save(project);

		activitiesRepository.save(activity);

		// update
		if (activitiesRepository.findOne(2) != null) {
			Activity activityUpdate = activitiesRepository.findOne(2);
			activityUpdate.setActivityCode(activityCode);
			activityUpdate.setEndDate(sdf.parse("01/12/2012"));
			activityUpdate.setOtherDetails("Other details for activities update");
			activityUpdate.setProject(project);
			activityUpdate.setStartDate(sdf.parse("12/11/2012"));
			activitiesRepository.flush();
		}

		// delete
		if (activitiesRepository.findOne(2) != null) {
			activitiesRepository.delete(2);
		}

	}
}
