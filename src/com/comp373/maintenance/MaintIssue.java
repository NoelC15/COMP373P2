package com.comp373.maintenance;

import java.util.Date;

import com.comp373.model.facility.Gym;

public interface MaintIssue {

	public String[] getDamageTypes();

	public void setDamageTypes(String[] damageTypes);

	public String getMaintProblem();

	public void setMaintProblem(String maintProblem);

	public Date getTimeRequested();

	public void setTimeRequested(Date timeRequested);

	public Gym getFacilityRequesting();

	public void setFacilityRequesting(Gym facilityRequesting);

	public void resolveMaintIssue(Gym facility);
}
