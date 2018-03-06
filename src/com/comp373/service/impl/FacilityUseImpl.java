package com.comp373.service.impl;

import com.comp373.constants.ApplicationConstants;
import com.comp373.model.facility.Facility;
import com.comp373.service.FacilityUse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FacilityUseImpl implements FacilityUse {
	private List<Date> usageDays = new ArrayList<Date>();

	@Override
	public void isInUseDuringInterval(Date dayOfUse) {
		//track days when facility is used
		usageDays.add(dayOfUse);
	}

	@Override
	public void assignFacilityToUse(Facility facility, String use) {
		facility.setFacilityState(use); //this would be using the relevant application constant
		this.isInUseDuringInterval(new Date()); //store date
	}

	@Override
	public void vacateFacility(Facility facility) {
		facility.setFacilityState(ApplicationConstants.VACANT);
	}

	@Override
	public List<Date> listActualUsage() {
		return this.usageDays;
	}

	@Override
	public long calcUsageRate(Date openDate) {
		//Usage rate = days scheduled/days since open
		int numberOfDaysUsed = this.usageDays.size(); //how many days has facility been used
		Date today = new Date();
		long difference = today.getTime() - openDate.getTime(); //how many days facility has been open
		long usage = numberOfDaysUsed/difference;
		return usage;
	}



}
