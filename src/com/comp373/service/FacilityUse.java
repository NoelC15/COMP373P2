package com.comp373.service;

import java.util.Date;
import java.util.List;

import com.comp373.model.facility.Facility;

public interface FacilityUse {
	
	public void isInUseDuringInterval(Date dayOfUse);
	
	public void assignFacilityToUse(Facility facility, String use);
	
	public void vacateFacility(Facility facility);
	
	public List<Date> listActualUsage(); 
	
	public long calcUsageRate(Date openDate); 
}
