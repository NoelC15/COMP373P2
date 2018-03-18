package com.comp373.service;

import java.util.Date;
import java.util.List;

import com.comp373.model.facility.Gym;

public interface FacilityUse {

	public void isInUseDuringInterval(Date dayOfUse);

	public void assignFacilityToUse(Gym gym, String use);

	public void vacateFacility(Gym gym);

	public List<Date> listActualUsage();

	public long calcUsageRate(Date openDate);
}
