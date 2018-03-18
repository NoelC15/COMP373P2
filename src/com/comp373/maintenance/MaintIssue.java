package com.comp373.maintenance;

import java.util.Date;

import com.comp373.constants.ApplicationConstants;
import com.comp373.model.facility.Gym;

public class MaintIssue {

	private String[] damageTypes; // there can be multiple types of damage for each request
	private String maintProblem; // each request has a singular 'maintenance problem' descriptor
	private Date timeRequested;
	private Gym facilityRequesting;

	public MaintIssue() {

	}

	public MaintIssue(String[] damageType, String maintProblem, Gym gym, Date requestDate) {
		this.damageTypes = damageType;
		this.maintProblem = maintProblem;
		this.facilityRequesting = gym;
		this.timeRequested = requestDate;
		// as soon as MaintIssue is created add it to facility's list
		gym.addGymProblem(maintProblem);
		gym.setCurrentMaintIssue(this);
		gym.setGymState(ApplicationConstants.IN_MAINT);
	}

	public String[] getDamageTypes() {
		return damageTypes;
	}

	public void setDamageTypes(String[] damageTypes) {
		this.damageTypes = damageTypes;
	}

	public String getMaintProblem() {
		return maintProblem;
	}

	public void setMaintProblem(String maintProblem) {
		this.maintProblem = maintProblem;
	}

	public Date getTimeRequested() {
		return timeRequested;
	}

	public void setTimeRequested(Date timeRequested) {
		this.timeRequested = timeRequested;
	}

	public Gym getFacilityRequesting() {
		return facilityRequesting;
	}

	public void setFacilityRequesting(Gym facilityRequesting) {
		this.facilityRequesting = facilityRequesting;
	}

	public void resolveMaintIssue(Gym facility) {
		facility.setGymState(ApplicationConstants.VACANT);
		facility.setCurrentMaintIssue(null);
	}
}
