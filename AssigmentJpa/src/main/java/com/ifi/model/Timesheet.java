package com.ifi.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the timesheets database table.
 * 
 */
@Entity
@Table(name="timesheets")
@NamedQuery(name="Timesheet.findAll", query="SELECT t FROM Timesheet t")
public class Timesheet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="timesheet_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int timesheetId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_date")
	private Date endDate;

	@Column(name="other_details")
	private String otherDetails;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date")
	private Date startDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="submitted_date")
	private Date submittedDate;

	//bi-directional many-to-one association to Activity
	@ManyToOne
	@JoinColumn(name="activity_id")
	private Activity activity;

	//bi-directional many-to-one association to CostCenter
	@ManyToOne
	@JoinColumn(name="cost_center_id")
	private CostCenter costCenter;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="timesheet_for_employee_id")
	private Employee employee;

	public Timesheet() {
	}

	public int getTimesheetId() {
		return this.timesheetId;
	}

	public void setTimesheetId(int timesheetId) {
		this.timesheetId = timesheetId;
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

	public Date getSubmittedDate() {
		return this.submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	public Activity getActivity() {
		return this.activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public CostCenter getCostCenter() {
		return this.costCenter;
	}

	public void setCostCenter(CostCenter costCenter) {
		this.costCenter = costCenter;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}