package com.comp373.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.comp373.constants.ApplicationConstants;
import com.comp373.model.facility.Gym;
import com.comp373.service.FacilityUse;

public class FacilityUseImpl implements FacilityUse {
	private List<Date> usageDays;
	private Calendar date;

	public void setDate(Calendar date) {
		this.date = date;
	}

	public void setUsageDays(List<Date> usageDays) {
		this.usageDays = usageDays;
	}

	public void isInUseDuringInterval(Date dayOfUse) {
		// track days when facility is used
		usageDays.add(dayOfUse);
	}

	public void assignFacilityToUse(Gym gym, String use) {
		gym.setGymState(use); // this would be using the relevant application constant
		this.isInUseDuringInterval(date.getTime()); // store date
	}

	public void vacateFacility(Gym gym) {
		gym.setGymState(ApplicationConstants.VACANT);
	}

	public List<Date> listActualUsage() {
		return this.usageDays;
	}

	public long calcUsageRate(Calendar openDate) {
		// Usage rate = days scheduled/days since open
		int numberOfDaysUsed = this.usageDays.size(); // how many days has facility been used
		long difference = date.getTimeInMillis() - openDate.getTimeInMillis(); // how many days facility has been open
		long usage = numberOfDaysUsed / difference;
		return usage;
	}
}
