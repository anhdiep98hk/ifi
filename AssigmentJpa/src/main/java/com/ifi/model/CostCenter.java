package com.ifi.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the cost_centers database table.
 * 
 */
@Entity
@Table(name="cost_centers")
@NamedQuery(name="CostCenter.findAll", query="SELECT c FROM CostCenter c")
public class CostCenter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cost_center_id")
	private int costCenterId;

	@Column(name="cost_center_decription")
	private String costCenterDecription;

	@Column(name="cost_center_name")
	private String costCenterName;

	@Column(name="other_details")
	private String otherDetails;

	//bi-directional many-to-one association to Timesheet
	@OneToMany(mappedBy="costCenter", fetch=FetchType.EAGER)
	private Set<Timesheet> timesheets;

	public CostCenter() {
	}
	
	

	public CostCenter(String costCenterDecription, String costCenterName, String otherDetails) {
		super();
		this.costCenterDecription = costCenterDecription;
		this.costCenterName = costCenterName;
		this.otherDetails = otherDetails;
	}



	public int getCostCenterId() {
		return this.costCenterId;
	}

	public void setCostCenterId(int costCenterId) {
		this.costCenterId = costCenterId;
	}

	public String getCostCenterDecription() {
		return this.costCenterDecription;
	}

	public void setCostCenterDecription(String costCenterDecription) {
		this.costCenterDecription = costCenterDecription;
	}

	public String getCostCenterName() {
		return this.costCenterName;
	}

	public void setCostCenterName(String costCenterName) {
		this.costCenterName = costCenterName;
	}

	public String getOtherDetails() {
		return this.otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

	public Set<Timesheet> getTimesheets() {
		return this.timesheets;
	}

	public void setTimesheets(Set<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}

	public Timesheet addTimesheet(Timesheet timesheet) {
		getTimesheets().add(timesheet);
		timesheet.setCostCenter(this);

		return timesheet;
	}

	public Timesheet removeTimesheet(Timesheet timesheet) {
		getTimesheets().remove(timesheet);
		timesheet.setCostCenter(null);

		return timesheet;
	}

}