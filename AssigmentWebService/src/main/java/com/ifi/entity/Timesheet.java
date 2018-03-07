package com.ifi.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the timesheet database table.
 * 
 */
@Entity
@Table(name="timesheet")
@NamedQuery(name="Timesheet.findAll", query="SELECT t FROM Timesheet t")
public class Timesheet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_timesheet")
	private int idTimesheet;

	private String location;

	private String workday;

	//bi-directional many-to-one association to Personal
	@ManyToOne
	@JoinColumn(name="id_personal")
	private Personal personal;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="id_project")
	private Project project;

	public Timesheet() {
	}
	
	

	public Timesheet(String location, String workday, Personal personal, Project project) {
		super();
		this.location = location;
		this.workday = workday;
		this.personal = personal;
		this.project = project;
	}
	
	



	public Timesheet(int idTimesheet, String location, String workday, Personal personal, Project project) {
		super();
		this.idTimesheet = idTimesheet;
		this.location = location;
		this.workday = workday;
		this.personal = personal;
		this.project = project;
	}



	public int getIdTimesheet() {
		return this.idTimesheet;
	}

	public void setIdTimesheet(int idTimesheet) {
		this.idTimesheet = idTimesheet;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getWorkday() {
		return this.workday;
	}

	public void setWorkday(String workday) {
		this.workday = workday;
	}

	public Personal getPersonal() {
		return this.personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}