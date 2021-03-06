package com.ifi.model;
// Generated Feb 24, 2018 2:22:47 AM by Hibernate Tools 5.2.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * CostCenters generated by hbm2java
 */
@Entity
@Table(name = "cost_centers", catalog = "assigment")
public class CostCenters implements java.io.Serializable {

	private Integer costCenterId;
	private String costCenterDecription;
	private String costCenterName;
	private String otherDetails;
	private Set<Timesheets> timesheetses = new HashSet<Timesheets>(0);

	public CostCenters() {
	}

	public CostCenters(String costCenterDecription, String costCenterName, String otherDetails,
			Set<Timesheets> timesheetses) {
		this.costCenterDecription = costCenterDecription;
		this.costCenterName = costCenterName;
		this.otherDetails = otherDetails;
		this.timesheetses = timesheetses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "cost_center_id", unique = true, nullable = false)
	public Integer getCostCenterId() {
		return this.costCenterId;
	}

	public void setCostCenterId(Integer costCenterId) {
		this.costCenterId = costCenterId;
	}

	@Column(name = "cost_center_decription")
	public String getCostCenterDecription() {
		return this.costCenterDecription;
	}

	public void setCostCenterDecription(String costCenterDecription) {
		this.costCenterDecription = costCenterDecription;
	}

	@Column(name = "cost_center_name")
	public String getCostCenterName() {
		return this.costCenterName;
	}

	public void setCostCenterName(String costCenterName) {
		this.costCenterName = costCenterName;
	}

	@Column(name = "other_details")
	public String getOtherDetails() {
		return this.otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "costCenters")
	@JsonBackReference
	public Set<Timesheets> getTimesheetses() {
		return this.timesheetses;
	}

	public void setTimesheetses(Set<Timesheets> timesheetses) {
		this.timesheetses = timesheetses;
	}

}
