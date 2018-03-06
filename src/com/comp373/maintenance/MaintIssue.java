package com.comp373.maintenance;

import java.util.Date;
import java.util.Map;

import com.comp373.constants.ApplicationConstants;
import com.comp373.model.facility.*;

public class MaintIssue {
	
	private String[] damageTypes; //there can be multiple types of damage for each request
	private String maintProblem; //each request has a singular 'maintenance problem' descriptor
	private Date timeRequested;
	private Facility facilityRequesting;
	
	public MaintIssue() {
		
	}
	
	public MaintIssue(String[] damageType, String maintProblem, Facility facility, Date requestDate) {
		this.damageTypes = damageType;
		this.maintProblem = maintProblem;
		this.facilityRequesting = facility;
		this.timeRequested = requestDate;
		//as soon as MaintIssue is created add it to facility's list
		facility.addFacilityProblem(maintProblem);
		facility.setCurrentMaintIssue(this);
		facility.setFacilityState(ApplicationConstants.IN_MAINT);
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

	public Facility getFacilityRequesting() {
		return facilityRequesting;
	}

	public void setFacilityRequesting(Facility facilityRequesting) {
		this.facilityRequesting = facilityRequesting;
	}
	
	public void resolveMaintIssue(Facility facility) {
		facility.setFacilityState(ApplicationConstants.VACANT);
		facility.setCurrentMaintIssue(null);
	}
}
