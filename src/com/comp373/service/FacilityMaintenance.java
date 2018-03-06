package com.comp373.service;

import java.util.List;
import java.util.Map;

import com.comp373.maintenance.Inspection;
import com.comp373.maintenance.MaintIssue;
import com.comp373.model.facility.Facility;

public interface FacilityMaintenance {
	
	public void makeFacilityMaintRequest(String[] damageType, String maintProblem, int daysOut, Facility facility); 
	
	public double calcMaintenanceCostForFacility(MaintIssue issue); 
	
	public double calcProblemRateForFacility(Facility facility); 
	
	public int calcDownTimeForFacilitiy(MaintIssue issue); 
	
	public List<String> listMaintRequests(Facility facility);
	
	public Map<Facility, Inspection> listInspections();
	
	public void scheduleMaintenance(MaintIssue request);
}
