package com.ifi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifi.model.Activity;
import com.ifi.repository.ActivitiesRepository;

@Service
public class ActivityService {

	@Autowired
	private ActivitiesRepository activitiesRepository;

	public List<Activity> getAllActivity() {
		return activitiesRepository.findAll();
	}

	public Activity getActivityById(int id) {
		return activitiesRepository.findOne(id);
	}

	public boolean addActivity(Activity activity) {
		if (activitiesRepository.save(activity) != null) {
			return true;
		}
		return false;
	}

	public boolean editProject(Activity activity) throws Exception {
		Activity activity2 = this.getActivityById(activity.getActivityId());

		if (activity2 != null) {
			activity2.setProject(activity.getProject());
			activity2.setEndDate(activity.getEndDate());
			activity2.setOtherDetails(activity.getOtherDetails());
			activity2.setStartDate(activity.getStartDate());
			activity2.setActivityCode(activity.getActivityCode());

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
