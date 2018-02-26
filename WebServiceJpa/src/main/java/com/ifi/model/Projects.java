package com.ifi.model;
// Generated Feb 24, 2018 2:22:47 AM by Hibernate Tools 5.2.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Projects generated by hbm2java
 */
@Entity
@Table(name = "projects", catalog = "assigment")
public class Projects implements java.io.Serializable {

	private Integer projectId;
	private Employees employees;
	private Location location;
	private Date endDate;
	private String otherDetails;
	private Date startDate;
	private Set<Activities> activitieses = new HashSet<Activities>(0);

	public Projects() {
	}

	public Projects(Employees employees, Location location, Date endDate, String otherDetails, Date startDate,
			Set<Activities> activitieses) {
		this.employees = employees;
		this.location = location;
		this.endDate = endDate;
		this.otherDetails = otherDetails;
		this.startDate = startDate;
		this.activitieses = activitieses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "project_id", unique = true, nullable = false)
	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Employees.class)
	@JoinColumn(name = "project_mgr_employee_id")
	public Employees getEmployees() {
		return this.employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Location.class)
	@JoinColumn(name = "location_code")
	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date", length = 19)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "other_details")
	public String getOtherDetails() {
		return this.otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date", length = 19)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "projects")
	@JsonBackReference
	public Set<Activities> getActivitieses() {
		return this.activitieses;
	}

	public void setActivitieses(Set<Activities> activitieses) {
		this.activitieses = activitieses;
	}

}