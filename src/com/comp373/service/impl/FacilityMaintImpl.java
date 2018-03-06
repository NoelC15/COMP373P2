package com.comp373.service.impl;

import com.comp373.service.FacilityMaintenance;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.comp373.model.facility.*;
import com.comp373.maintenance.*;
import com.comp373.constants.*;

public class FacilityMaintImpl implements FacilityMaintenance {
	//maintenance interacts with building manager's expense account
	private List<Date> maintDays = new ArrayList<Date>();

	
	@Override
	public void makeFacilityMaintRequest(String[] damageType, String maintProblem, int daysOut, Facility facility) {
		
		//Java dates are a bit messy...
        Date currentDate = new Date();
        // convert date to calendar
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);

        // increment desired number of days...
        calendar.add(Calendar.DATE, daysOut);

        // convert calendar object back to Date object
        Date requestedDay = calendar.getTime();
        
		//specify maintIssue
		MaintIssue issue = new MaintIssue(damageType, maintProblem, facility, requestedDay);
        
		//schedule maintenance
		scheduleMaintenance(issue);
	}
	


	@Override
	public double calcMaintenanceCostForFacility(MaintIssue issue) {
		//diff damage types = diff cost
		double cost = 0;
		if(ApplicationConstants.DAMAGEEVALUTIONDAYS.isEmpty()) {
			ApplicationConstants.setDownTimeDays(); //is there a better way to do this? seems silly
		}
		String[] damages = issue.getDamageTypes();
		if(ApplicationConstants.MAINTCOST.isEmpty()) {
			ApplicationConstants.setMaintCost(); //is there a better way to do this? seems silly
		}
		for(int i = 0; i<damages.length; i++) {
			cost += ApplicationConstants.MAINTCOST.get(damages[i]); //add up damage days
		}
		return cost;
	}

	@Override
	public double calcProblemRateForFacility(Facility facility) {
		//calculate problem rate: problem days/days open
		double numOfProblemDays = this.maintDays.size();
		Date today = new Date();
		double difference = today.getTime() - facility.getOpenDate().getTime(); //how long has been open
		double probRate = numOfProblemDays/difference;
		return probRate;
	}

	@Override
	public int calcDownTimeForFacilitiy(MaintIssue issue) {
		//diff damage types = diff down times. Returns # of days
		int downTime = 0;
		if(ApplicationConstants.DAMAGEEVALUTIONDAYS.isEmpty()) {
			ApplicationConstants.setDownTimeDays(); //is there a better way to do this? seems silly
		}
		String[] damages = issue.getDamageTypes();
		for(int i = 0; i<damages.length; i++) {
			downTime += ApplicationConstants.DAMAGEEVALUTIONDAYS.get(damages[i]); //add up damage days
		}
		return downTime;
	}

	@Override
	public List<String> listMaintRequests(Facility facility) {
		//list maintenance requests for specific facility
		return facility.listFacilityProblems();
	}
	
	@Override
	public Map<Facility, Inspection> listInspections() {
		//lists all inspections. Only tracks most recent result.
		Inspection inspect = new Inspection();
		return inspect.getAllInspections();
	}
	
	public void scheduleMaintenance(MaintIssue request) {
		//set time of maintenance
		Date timeRequested = request.getTimeRequested();
		this.maintDays.add(timeRequested);
	}

	public List<Date> getMaintDays() {
		return maintDays;
	}

	public void setMaintDays(List<Date> maintDays) {
		this.maintDays = maintDays;
	}

	public Map<String, Integer> getDamageEvaluationDays() {
		return ApplicationConstants.DAMAGEEVALUTIONDAYS;
	}
}
