package com.comp373.maintenance;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import com.comp373.model.facility.Facility;

import java.util.Date;

public class Inspection {
	private Date timeOfInspection;
	private String inspectionResult;
	private Map<Facility, Inspection> allInspections = new HashMap<Facility, Inspection>();
	
	public Inspection() {
		
	}
	
	public Inspection(GregorianCalendar time, String result) {
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

	public Map<Facility, Inspection> getAllInspections() {
		return allInspections;
	}

	public void setAllInspections(Map<Facility, Inspection> allInspections) {
		this.allInspections = allInspections;
	}
}
