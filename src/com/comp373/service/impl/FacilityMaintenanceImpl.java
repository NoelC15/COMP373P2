package com.comp373.service.impl;

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
	// maintenance interacts with building manager's expense account
	private List<Date> maintDays;
	private Calendar date;
	private MaintIssue issue;
	private Inspection inspections;

	
	public Inspection getInspections() {
		return inspections;
	}

	public void setInspections(Inspection inspections) {
		this.inspections = inspections;
	}

	public MaintIssue getIssue() {
		return issue;
	}

	public void setIssue(MaintIssue issue) {
		this.issue = issue;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	@Override
	public void makeFacilityMaintRequest(String[] damageType, String maintProblem, int daysOut, Gym gym) {
		Date currentDate = date.getTime();
		// convert date to calendar
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);

		// increment desired number of days...
		calendar.add(Calendar.DATE, daysOut);

		// convert calendar object back to Date object
		Date requestedDay = calendar.getTime();

		// specify maintIssue
		issue.setDamageTypes(damageType);
		issue.setMaintProblem(maintProblem);
		issue.setFacilityRequesting(gym);
		issue.setTimeRequested(requestedDay);
		// schedule maintenance
		scheduleMaintenance(issue);
	}

	@Override
	public double calcMaintenanceCostForFacility(MaintIssue issue) {
		// diff damage types = diff cost
		double cost = 0;
		if (ApplicationConstants.damageEvaluationDays.isEmpty()) {
			ApplicationConstants.setDownTimeDays(); // is there a better way to do this? seems silly
		}
		String[] damages = issue.getDamageTypes();
		if (ApplicationConstants.maintCost.isEmpty()) {
			ApplicationConstants.setMaintCost(); // is there a better way to do this? seems silly
		}
		for (int i = 0; i < damages.length; i++) {
			cost += ApplicationConstants.maintCost.get(damages[i]); // add up damage days
		}
		return cost;
	}

	public double calcProblemRateForFacility(Gym gym) {
		// calculate problem rate: problem days/days open
		double numOfProblemDays = this.maintDays.size();
		Date today = date.getTime();
		double difference = today.getTime() - gym.getOpenDate().getTime(); // how long has been open
		double probRate = numOfProblemDays / difference;
		return probRate;
	}

	public int calcDownTimeForFacilitiy(MaintIssue issue) {
		// diff damage types = diff down times. Returns # of days
		int downTime = 0;
		if (ApplicationConstants.damageEvaluationDays.isEmpty()) {
			ApplicationConstants.setDownTimeDays(); // is there a better way to do this? seems silly
		}
		String[] damages = issue.getDamageTypes();
		for (int i = 0; i < damages.length; i++) {
			downTime += ApplicationConstants.damageEvaluationDays.get(damages[i]); // add up damage days
		}
		return downTime;
	}

	public List<String> listMaintRequests(Gym gym) {
		// list maintenance requests for specific facility
		return gym.listGymProblems();
	}

	public Map<Gym, Inspection> listInspections() {
		// lists all inspections. Only tracks most recent result.
		return inspections.getAllInspections();
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
		return ApplicationConstants.damageEvaluationDays;
	}
}
