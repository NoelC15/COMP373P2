package com.comp373.maintenance;

import java.util.Date;
import java.util.Map;

import com.comp373.model.facility.Gym;

public interface Inspection {

	public Date getTimeOfInspection();

	public String getInspectionResult();

	public void setInspectionResult(String inspectionResult);

	public Map<Gym, Inspection> getAllInspections();

	public void setAllInspections(Map<Gym, Inspection> allInspections);

}
