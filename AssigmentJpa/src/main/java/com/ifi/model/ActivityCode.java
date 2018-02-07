package com.ifi.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the activity_codes database table.
 * 
 */
@Entity
@Table(name="activity_codes")
@NamedQuery(name="ActivityCode.findAll", query="SELECT a FROM ActivityCode a")
public class ActivityCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="activity_code")
	private int activityCode;

	@Column(name="activity_description")
	private String activityDescription;

	//bi-directional many-to-one association to Activity
	@OneToMany(mappedBy="activityCode", fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<Activity> activities;

	public ActivityCode() {
	}
	
	

	public ActivityCode(String activityDescription) {
		super();
		this.activityDescription = activityDescription;
	}



	public int getActivityCode() {
		return this.activityCode;
	}

	public void setActivityCode(int activityCode) {
		this.activityCode = activityCode;
	}

	public String getActivityDescription() {
		return this.activityDescription;
	}

	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}

	public Set<Activity> getActivities() {
		return this.activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}

	public Activity addActivity(Activity activity) {
		getActivities().add(activity);
		activity.setActivityCode(this);

		return activity;
	}

	public Activity removeActivity(Activity activity) {
		getActivities().remove(activity);
		activity.setActivityCode(null);

		return activity;
	}

}