package com.ifi.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the employees database table.
 * 
 */
@Entity
@Table(name="employees")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employee_id")
	private int employeeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_date")
	private Date endDate;

	@Column(name="other_details")
	private String otherDetails;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date")
	private Date startDate;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="employee", fetch=FetchType.EAGER)
	private Set<Project> projects;

	//bi-directional many-to-one association to Timesheet
	@OneToMany(mappedBy="employee1", fetch=FetchType.EAGER)
	private Set<Timesheet> timesheets1;

	//bi-directional many-to-one association to Timesheet
	@OneToMany(mappedBy="employee2", fetch=FetchType.EAGER)
	private Set<Timesheet> timesheets2;

	public Employee() {
	}

	
	public Employee(Date endDate, String otherDetails, Date startDate) {
		super();
		this.endDate = endDate;
		this.otherDetails = otherDetails;
		this.startDate = startDate;
	}


	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getOtherDetails() {
		return this.otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Set<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setEmployee(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setEmployee(null);

		return project;
	}

	public Set<Timesheet> getTimesheets1() {
		return this.timesheets1;
	}

	public void setTimesheets1(Set<Timesheet> timesheets1) {
		this.timesheets1 = timesheets1;
	}

	public Timesheet addTimesheets1(Timesheet timesheets1) {
		getTimesheets1().add(timesheets1);
		timesheets1.setEmployee1(this);

		return timesheets1;
	}

	public Timesheet removeTimesheets1(Timesheet timesheets1) {
		getTimesheets1().remove(timesheets1);
		timesheets1.setEmployee1(null);

		return timesheets1;
	}

	public Set<Timesheet> getTimesheets2() {
		return this.timesheets2;
	}

	public void setTimesheets2(Set<Timesheet> timesheets2) {
		this.timesheets2 = timesheets2;
	}

	public Timesheet addTimesheets2(Timesheet timesheets2) {
		getTimesheets2().add(timesheets2);
		timesheets2.setEmployee2(this);

		return timesheets2;
	}

	public Timesheet removeTimesheets2(Timesheet timesheets2) {
		getTimesheets2().remove(timesheets2);
		timesheets2.setEmployee2(null);

		return timesheets2;
	}

}