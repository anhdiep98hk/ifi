package com.ifi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifi.model.Projects;
import com.ifi.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public List<Projects> getAllProject() {
		return projectRepository.findAll();
	}

	public Projects getProjectById(int id) {
		return projectRepository.findOne(id);
	}

	public boolean addProject(Projects project) {
		if (projectRepository.save(project) != null) {
			return true;
		}
		return false;
	}

	public boolean editProject(Projects project) throws Exception {
		Projects project2 = this.getProjectById(project.getProjectId());

		if (project2 != null) {
			project2.setEmployees(project.getEmployees());
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
