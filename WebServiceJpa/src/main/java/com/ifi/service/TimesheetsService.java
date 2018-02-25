package com.ifi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifi.model.Timesheets;
import com.ifi.repository.TimesheetRepository;

@Service
public class TimesheetsService {

	@Autowired
	private TimesheetRepository timesheetRepository;

	public List<Timesheets> getAllTimesheet() {
		return timesheetRepository.findAll();
	}

	public Timesheets getTimesheetById(int id) {
		return timesheetRepository.findOne(id);
	}

	public boolean addTimesheet(Timesheets timesheet) {
		if (timesheetRepository.save(timesheet) != null) {
			return true;
		}
		return false;
	}

	public boolean editProject(Timesheets timesheet) throws Exception {

		Timesheets timesheet2 = this.getTimesheetById(timesheet.getTimesheetId());

		if (timesheet2 != null) {
			timesheet2.setCostCenters(timesheet.getCostCenters());
			timesheet2.setEmployees(timesheet.getEmployees());
			timesheet2.setEndDate(timesheet.getEndDate());
			timesheet2.setOtherDetails(timesheet.getOtherDetails());
			timesheet2.setStartDate(timesheet.getStartDate());
			timesheet2.setSubmittedDate(timesheet.getSubmittedDate());
			timesheet2.setActivities(timesheet.getActivities());

			if (timesheetRepository.saveAndFlush(timesheet2) != null) {
				return true;
			}
		}
		return false;
	}

	public boolean deleteProject(int id) {
		if (this.getTimesheetById(id) != null) {
			timesheetRepository.delete(id);
			return true;
		}
		return false;
	}

}
