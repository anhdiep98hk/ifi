package com.ifi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifi.model.ActivityCode;
import com.ifi.repository.ActivitieCodeRepository;

@Service
public class ActivityCodeService {
	
	@Autowired
	private ActivitieCodeRepository activitieCodeRepository;
	
	public List<ActivityCode> getAllActivityCode(){
		return activitieCodeRepository.findAll();
	}
	
	public ActivityCode getActivityCodeById(int id) {
		return activitieCodeRepository.findOne(id);
	}
	
	public boolean addActivityCode(ActivityCode activityCode) {
		if(activitieCodeRepository.save(activityCode) != null) {
			return true;
		}
		return false;
	}
	
	public boolean editActivityCode(ActivityCode activityCode){
		ActivityCode activityCode2 = this.getActivityCodeById(activityCode.getActivityCode());
		
		
		activityCode2.setActivityDescription(activityCode.getActivityDescription());
		
		
		if(activitieCodeRepository.saveAndFlush(activityCode2) != null) {
			return true;
		}
		return false;
	}
	
	public boolean deleteActivityCode(int id) {
		if(this.getActivityCodeById(id) != null) {
			activitieCodeRepository.delete(id);
			return true;
		}
		return false;
	}
	
}
