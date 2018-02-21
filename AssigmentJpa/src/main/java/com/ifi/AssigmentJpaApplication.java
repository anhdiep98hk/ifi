package com.ifi;

import java.text.SimpleDateFormat;

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
import com.ifi.service.ActivityCodeService;
import com.ifi.service.ActivityService;
import com.ifi.service.CostCenterService;
import com.ifi.service.EmployeesService;
import com.ifi.service.LocationService;
import com.ifi.service.ProjectService;
import com.ifi.service.TimesheetsService;

@SpringBootApplication
public class AssigmentJpaApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(AssigmentJpaApplication.class);

	@Autowired
	private EmployeesService employeesService;

	@Autowired
	private LocationService locationService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private ActivityService activityService;

	@Autowired
	private CostCenterService costCenterService;

	@Autowired
	private TimesheetsService timesheetsService;

	@Autowired
	private ActivityCodeService activityCodeService;

	public static void main(String[] args) {
		SpringApplication.run(AssigmentJpaApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		

		/* Project */
		Employee employee = new Employee(sdf.parse("12/02/2017"), "Other details for employee",
				sdf.parse("10/01/2017"));
		employeesService.addEmployee(employee);
		
		Location location = new Location("Airport");
		locationService.addLocation(location);

		Project project = new Project();
		project.setEmployee(employee);
		project.setLocation(location);
		project.setEndDate(sdf.parse("01/12/2012"));
		project.setOtherDetails("Others details for project 1");
		project.setStartDate(sdf.parse("12/01/2013"));
		
		
		projectService.addProject(project);

		int idPj = 5;
		
		
		Project project2 = new Project();
		project2.setProjectId(idPj);
		project2.setEmployee(employee);
		project2.setLocation(location);
		project2.setEndDate(sdf.parse("01/12/2012"));
		project2.setOtherDetails("Others details for project 2 update");
		project2.setStartDate(sdf.parse("12/01/2013"));
		projectService.editProject(project2);
		
		
		projectService.deleteProject(idPj);
		
		
		
		
		

		// Activities 
		
		ActivityCode activityCode = new ActivityCode("Vacation");
		activityCodeService.addActivityCode(activityCode);
		

		Activity activity = new Activity();
		activity.setProject(project);
		activity.setEndDate(sdf.parse("01/12/2012"));
		activity.setOtherDetails("Other details for activities 2");
		activity.setStartDate(sdf.parse("12/11/2012"));
		activity.setActivityCode(activityCode);
		
		activityService.addActivity(activity);
		
		int idActivity = 9;
		
		Activity activity2 = new Activity();
		activity2.setActivityId(idActivity);
		activity2.setProject(project);
		activity2.setEndDate(sdf.parse("01/12/2012"));
		activity2.setOtherDetails("Other details for activities 2 updATTE");
		activity2.setStartDate(sdf.parse("12/11/2012"));
		activity2.setActivityCode(activityCode);
		
		activityService.editProject(activity2);
		
		
		activityService.deleteProject(idActivity);
		
		
		
		
		
		//Timesheet
		
		CostCenter costCenter = new CostCenter("cost center decription 1","Cost center 1","Ohter details for costcenter 1");
		costCenterService.addCost(costCenter);
		
		
		
		Timesheet timesheet = new Timesheet();
		timesheet.setCostCenter(costCenter);
		timesheet.setEmployee(employee);
		timesheet.setEndDate(sdf.parse("20/12/2017"));
		timesheet.setOtherDetails("Other details for timesheet");
		timesheet.setStartDate(sdf.parse("10/11/2017"));
		timesheet.setSubmittedDate(sdf.parse("21/12/2017"));
		timesheet.setActivity(activity);
		costCenter.addTimesheet(timesheet);
		
		timesheetsService.addTimesheet(timesheet);
		
		
		
		int idTimesheet = 2;

		Timesheet timesheet2 = new Timesheet();
		timesheet2.setTimesheetId(idTimesheet);
		timesheet2.setCostCenter(costCenter);
		timesheet2.setEmployee(employee);
		timesheet2.setEndDate(sdf.parse("20/12/2017"));
		timesheet2.setOtherDetails("Other details for timesheet update");
		timesheet2.setStartDate(sdf.parse("10/11/2017"));
		timesheet2.setSubmittedDate(sdf.parse("21/12/2017"));
		timesheet2.setActivity(activity);
		
		timesheetsService.editProject(timesheet2);
		
		// delete
		timesheetsService.deleteProject(idTimesheet);

	}
}
