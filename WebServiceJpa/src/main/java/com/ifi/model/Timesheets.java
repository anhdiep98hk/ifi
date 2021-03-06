package com.ifi.model;
// Generated Feb 24, 2018 2:22:47 AM by Hibernate Tools 5.2.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Timesheets generated by hbm2java
 */
@Entity
@Table(name = "timesheets", catalog = "assigment")
public class Timesheets implements java.io.Serializable {

	private Integer timesheetId;
	private Activities activities;
	private CostCenters costCenters;
	private Employees employees;
	private Date endDate;
	private String otherDetails;
	private Date startDate;
	private Date submittedDate;

	public Timesheets() {
	}

	public Timesheets(Activities activities, CostCenters costCenters, Employees employees, Date endDate,
			String otherDetails, Date startDate, Date submittedDate) {
		this.activities = activities;
		this.costCenters = costCenters;
		this.employees = employees;
		this.endDate = endDate;
		this.otherDetails = otherDetails;
		this.startDate = startDate;
		this.submittedDate = submittedDate;
	}
	
	

	public Timesheets(Integer timesheetId, Activities activities, CostCenters costCenters, Employees employees,
			Date endDate, String otherDetails, Date startDate, Date submittedDate) {
		super();
		this.timesheetId = timesheetId;
		this.activities = activities;
		this.costCenters = costCenters;
		this.employees = employees;
		this.endDate = endDate;
		this.otherDetails = otherDetails;
		this.startDate = startDate;
		this.submittedDate = submittedDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "timesheet_id", unique = true, nullable = false)
	public Integer getTimesheetId() {
		return this.timesheetId;
	}

	public void setTimesheetId(Integer timesheetId) {
		this.timesheetId = timesheetId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "activity_id")
	public Activities getActivities() {
		return this.activities;
	}

	public void setActivities(Activities activities) {
		this.activities = activities;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cost_center_id")
	public CostCenters getCostCenters() {
		return this.costCenters;
	}

	public void setCostCenters(CostCenters costCenters) {
		this.costCenters = costCenters;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "timesheet_for_employee_id")
	public Employees getEmployees() {
		return this.employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "submitted_date", length = 19)
	public Date getSubmittedDate() {
		return this.submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

}
