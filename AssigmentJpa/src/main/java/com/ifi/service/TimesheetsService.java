package com.ifi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifi.model.Timesheet;
import com.ifi.repository.TimesheetRepository;

@Service
public class TimesheetsService {

	@Autowired
	private TimesheetRepository timesheetRepository;

	public List<Timesheet> getAllTimesheet() {
		return timesheetRepository.findAll();
	}

	public Timesheet getTimesheetById(int id) {
		return timesheetRepository.findOne(id);
	}

	public boolean addTimesheet(Timesheet timesheet) {
		if (timesheetRepository.save(timesheet) != null) {
			return true;
		}
		return false;
	}

	public boolean editProject(Timesheet timesheet) throws Exception {

		Timesheet timesheet2 = this.getTimesheetById(timesheet.getTimesheetId());

		if (timesheet2 != null) {
			timesheet.setCostCenter(timesheet.getCostCenter());
			timesheet.setEmployee(timesheet.getEmployee());
			timesheet.setEndDate(timesheet.getEndDate());
			timesheet.setOtherDetails(timesheet.getOtherDetails());
			timesheet.setStartDate(timesheet.getStartDate());
			timesheet.setSubmittedDate(timesheet.getSubmittedDate());
			timesheet.setActivity(timesheet.getActivity());

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
