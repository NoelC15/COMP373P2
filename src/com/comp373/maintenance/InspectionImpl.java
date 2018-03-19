package com.comp373.maintenance;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import com.comp373.model.facility.Gym;

//	TODO create Inspection interface
public class InspectionImpl implements Inspection {
	private Date timeOfInspection;
	private String inspectionResult;
	// TODO DI
	private Map<Gym, Inspection> allInspections = new HashMap<Gym, Inspection>();

	public InspectionImpl() {
	}

	public InspectionImpl(GregorianCalendar time, String result) {
		this.timeOfInspection = new GregorianCalendar().getTime();
		this.inspectionResult = result;
	}

	public Date getTimeOfInspection() {
		return this.timeOfInspection;
	}

	public void setTimeOfInspection(Date timeOfInspection) {
		this.timeOfInspection = timeOfInspection;
	}

	public String getInspectionResult() {
		return this.inspectionResult;
	}

	public void setInspectionResult(String inspectionResult) {
		this.inspectionResult = inspectionResult;
	}

	public Map<Gym, Inspection> getAllInspections() {
		return allInspections;
	}

	public void setAllInspections(Map<Gym, Inspection> allInspections) {
		this.allInspections = allInspections;
	}
}
