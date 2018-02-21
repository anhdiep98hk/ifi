package com.ifi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifi.model.Project;
import com.ifi.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public List<Project> getAllProject() {
		return projectRepository.findAll();
	}

	public Project getProjectById(int id) {
		return projectRepository.findOne(id);
	}

	public boolean addProject(Project project) {
		if (projectRepository.save(project) != null) {
			return true;
		}
		return false;
	}

	public boolean editProject(Project project) throws Exception {
		Project project2 = this.getProjectById(project.getProjectId());

		if (project2 != null) {
			project2.setEmployee(project.getEmployee());
			project2.setLocation(project.getLocation());
			project2.setEndDate(project.getEndDate());
			project2.setOtherDetails(project.getOtherDetails());
			project2.setStartDate(project.getStartDate());

			if (projectRepository.saveAndFlush(project2) != null) {
				return true;
			}
		}
		return false;
	}

	public boolean deleteProject(int id) {
		if (this.getProjectById(id) != null) {
			projectRepository.delete(id);
			System.out.println("ok");
			return true;
		}
		System.out.println("false");
		return false;
	}

}
