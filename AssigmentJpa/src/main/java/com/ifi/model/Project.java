package com.ifi.model;

import java.io.Serializable;
import javax.persistence.*;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the projects database table.
 * 
 */
@Entity
@Table(name="projects")
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="project_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int projectId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_date")
	private Date endDate;

	@Column(name="other_details")
	private String otherDetails;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date")
	private Date startDate;

	//bi-directional many-to-one association to Activity
	@OneToMany(mappedBy="project", fetch=FetchType.EAGER)
	private Set<Activity> activities = new HashSet<>();

	//bi-directional many-to-one association to Location
	@ManyToOne
	@JoinColumn(name="location_code")
	private Location location;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="project_mgr_employee_id")
	private Employee employee;

	public Project() {
	}
	
	

	



	public Project(Date endDate, String otherDetails, Date startDate, Location location, Employee employee) {
		super();
		this.endDate = endDate;
		this.otherDetails = otherDetails;
		this.startDate = startDate;
		this.location = location;
		this.employee = employee;
	}







	public int getProjectId() {
		return this.projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
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

	public Set<Activity> getActivities() {
		return this.activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}

	public Activity addActivity(Activity activity) {
		getActivities().add(activity);
		activity.setProject(this);

		return activity;
	}

	public Activity removeActivity(Activity activity) {
		getActivities().remove(activity);
		activity.setProject(null);

		return activity;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", endDate=" + endDate + ", otherDetails=" + otherDetails
				+ ", startDate=" + startDate  + ", location=" + location.getLocationCode() + ", employee="
				+ employee.getEmployeeId() + "]";
	}

	
}