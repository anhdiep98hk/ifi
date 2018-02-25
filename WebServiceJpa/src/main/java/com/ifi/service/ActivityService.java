package com.ifi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifi.model.Activities;
import com.ifi.repository.ActivitiesRepository;

@Service
public class ActivityService {

	@Autowired
	private ActivitiesRepository activitiesRepository;

	public List<Activities> getAllActivity() {
		return activitiesRepository.findAll();
	}

	public Activities getActivityById(int id) {
		return activitiesRepository.findOne(id);
	}

	public boolean addActivity(Activities activity) {
		if (activitiesRepository.save(activity) != null) {
			return true;
		}
		return false;
	}

	public boolean editProject(Activities activity) throws Exception {
		Activities activity2 = this.getActivityById(activity.getActivityId());

		if (activity2 != null) {
			activity2.setProjects(activity.getProjects());
			activity2.setEndDate(activity.getEndDate());
			activity2.setOtherDetails(activity.getOtherDetails());
			activity2.setStartDate(activity.getStartDate());
			activity2.setActivityCodes(activity.getActivityCodes());

			if (activitiesRepository.saveAndFlush(activity2) != null) {
				return true;
			}
		}
		return false;
	}

	public boolean deleteProject(int id) {
		if (this.getActivityById(id) != null) {
			activitiesRepository.delete(id);
			return true;
		}
		return false;
	}

}
