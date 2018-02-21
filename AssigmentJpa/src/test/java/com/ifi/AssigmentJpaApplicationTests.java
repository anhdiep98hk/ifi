package com.ifi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ifi.model.Activity;
import com.ifi.model.ActivityCode;
import com.ifi.model.Employee;
import com.ifi.model.Location;
import com.ifi.model.Project;
import com.ifi.service.ActivityCodeService;
import com.ifi.service.ActivityService;
import com.ifi.service.CostCenterService;
import com.ifi.service.EmployeesService;
import com.ifi.service.LocationService;
import com.ifi.service.ProjectService;
import com.ifi.service.TimesheetsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssigmentJpaApplicationTests {

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

	@Test
	public void contextLoads() {

	}

	@Test
	public void testProject() throws Exception {
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
		
		assertNotNull(project);

//		boolean projectTest = projectService.addProject(project);
//		
//		assertEquals(true, projectTest);

		int idPj = 5;

		Project project2 = new Project();
		project2.setProjectId(idPj);
		project2.setEmployee(employee);
		project2.setLocation(location);
		project2.setEndDate(sdf.parse("01/12/2012"));
		project2.setOtherDetails("Others details for project 2 update");
		project2.setStartDate(sdf.parse("12/01/2013"));
		boolean projectUpdateTest = projectService.editProject(project2);
		assertEquals(false, projectUpdateTest);

		boolean projectDeleteTest = projectService.deleteProject(idPj);
		assertEquals(false, projectDeleteTest);

	}
	
//	@Test
//	public void testActivity() {
//		assertEquals(false, activityService.deleteProject(4));
//	}
//	
//	@Test
//	public void testTimesheet() {
//		assertEquals(false, timesheetsService.deleteProject(2));
//	}
	

}
