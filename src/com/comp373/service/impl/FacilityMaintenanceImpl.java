package com.comp373.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.comp373.constants.ApplicationConstants;
import com.comp373.maintenance.Inspection;
import com.comp373.maintenance.InspectionImpl;
import com.comp373.maintenance.MaintIssue;
import com.comp373.maintenance.MaintIssueImpl;
import com.comp373.model.facility.Gym;
import com.comp373.service.FacilityMaintenance;

public class FacilityMaintenanceImpl implements FacilityMaintenance {
//	TODO #DI #new
	// maintenance interacts with building manager's expense account
	private List<Date> maintDays = new ArrayList<Date>();

	@Override
	public void makeFacilityMaintRequest(String[] damageType, String maintProblem, int daysOut, Gym gym) {

		// Java dates are a bit messy...
		Date currentDate = new Date();
		// convert date to calendar
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);

		// increment desired number of days...
		calendar.add(Calendar.DATE, daysOut);

		// convert calendar object back to Date object
		Date requestedDay = calendar.getTime();

		// specify maintIssue
		MaintIssueImpl issue = new MaintIssueImpl(damageType, maintProblem, gym, requestedDay);

		// schedule maintenance
		scheduleMaintenance(issue);
	}

	@Override
	public double calcMaintenanceCostForFacility(MaintIssue issue) {
		// diff damage types = diff cost
		double cost = 0;
		if (ApplicationConstants.DAMAGEEVALUTIONDAYS.isEmpty()) {
			ApplicationConstants.setDownTimeDays(); // is there a better way to do this? seems silly
		}
		String[] damages = issue.getDamageTypes();
		if (ApplicationConstants.MAINTCOST.isEmpty()) {
			ApplicationConstants.setMaintCost(); // is there a better way to do this? seems silly
		}
		for (int i = 0; i < damages.length; i++) {
			cost += ApplicationConstants.MAINTCOST.get(damages[i]); // add up damage days
		}
		return cost;
	}

	@Override
	public double calcProblemRateForFacility(Gym gym) {
		// calculate problem rate: problem days/days open
		double numOfProblemDays = this.maintDays.size();
		Date today = new Date();
		double difference = today.getTime() - gym.getOpenDate().getTime(); // how long has been open
		double probRate = numOfProblemDays / difference;
		return probRate;
	}

	@Override
	public int calcDownTimeForFacilitiy(MaintIssue issue) {
		// diff damage types = diff down times. Returns # of days
		int downTime = 0;
		if (ApplicationConstants.DAMAGEEVALUTIONDAYS.isEmpty()) {
			ApplicationConstants.setDownTimeDays(); // is there a better way to do this? seems silly
		}
		String[] damages = issue.getDamageTypes();
		for (int i = 0; i < damages.length; i++) {
			downTime += ApplicationConstants.DAMAGEEVALUTIONDAYS.get(damages[i]); // add up damage days
		}
		return downTime;
	}

	@Override
	public List<String> listMaintRequests(Gym gym) {
		// list maintenance requests for specific facility
		return gym.listGymProblems();
	}

	@Override
	public Map<Gym, Inspection> listInspections() {
		// lists all inspections. Only tracks most recent result.
		Inspection inspect = new InspectionImpl();
		return inspect.getAllInspections();
	}

	public void scheduleMaintenance(MaintIssue request) {
		// set time of maintenance
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
