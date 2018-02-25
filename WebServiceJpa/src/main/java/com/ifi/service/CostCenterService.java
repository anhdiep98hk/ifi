package com.ifi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifi.model.CostCenters;
import com.ifi.repository.CostCenterRepository;


@Service
public class CostCenterService {
	
	@Autowired
	private CostCenterRepository costCenterRepository;
	
	public List<CostCenters> getAllCost(){
		return costCenterRepository.findAll();
	}
	
	public CostCenters getCostById(int id) {
		return costCenterRepository.findOne(id);
	}
	
	public boolean addCost(CostCenters costCenter) {
		if(costCenterRepository.save(costCenter) != null) {
			return true;
		}
		return false;
	}
	
	public boolean editCost(CostCenters costCenter) {
		
		CostCenters costCenter2 = this.getCostById(costCenter.getCostCenterId());
		
		costCenter2.setCostCenterName(costCenter.getCostCenterName());
		costCenter2.setCostCenterDecription(costCenter.getCostCenterDecription());
		costCenter2.setOtherDetails(costCenter.getOtherDetails());
		
		if(costCenterRepository.saveAndFlush(costCenter2) != null) {
			return true;
		}
		return false;
	}
	
	public boolean deleteCost(int id) {
		if(this.getCostById(id) != null) {
			costCenterRepository.delete(id);
			return true;
		}
		return false;
	}
	
}
