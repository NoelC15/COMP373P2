package com.comp373.service;

import java.util.List;
import java.util.Map;

import com.comp373.maintenance.Inspection;
import com.comp373.maintenance.MaintIssue;
import com.comp373.model.facility.Gym;

public interface FacilityMaintenance {

	public void makeFacilityMaintRequest(String[] damageType, String maintProblem, int daysOut, Gym gym);

	public double calcMaintenanceCostForFacility(MaintIssue issue);

	public double calcProblemRateForFacility(Gym gym);

	public int calcDownTimeForFacilitiy(MaintIssue issue);

	public List<String> listMaintRequests(Gym gym);

	public Map<Gym, Inspection> listInspections();

	public void scheduleMaintenance(MaintIssue request);
}
