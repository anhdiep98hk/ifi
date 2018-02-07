package com.ifi.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the location database table.
 * 
 */
@Entity
@Table(name="location")
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="location_code")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int locationCode;

	@Column(name="location_decription")
	private String locationDecription;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="location", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Project> projects;

	public Location() {
	}
	
	

	public Location(String locationDecription) {
		super();
		this.locationDecription = locationDecription;
	}



	public int getLocationCode() {
		return this.locationCode;
	}

	public void setLocationCode(int locationCode) {
		this.locationCode = locationCode;
	}

	public String getLocationDecription() {
		return this.locationDecription;
	}

	public void setLocationDecription(String locationDecription) {
		this.locationDecription = locationDecription;
	}

	public Set<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setLocation(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setLocation(null);

		return project;
	}

}