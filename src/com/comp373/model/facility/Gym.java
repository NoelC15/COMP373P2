package com.comp373.model.facility;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.comp373.maintenance.MaintIssue;
import com.comp373.maintenance.MaintIssueImpl;
import com.comp373.service.FacilityMaintenance;
import com.comp373.service.FacilityUse;

//	Facility
public interface Gym {

	public int requestAvailableCapacity();

	public void setCapacity(int capacity);

	public Date getOpenDate();

	public void setOpenDate(int year, int month, int day) throws ParseException;

	// getFacilityName
	public String getGymName();

	// setFacilityName
	public void setGymName(String gymName);

	// getFacilityUses
	public FacilityUse getGymUses();

	// setFacilityUses
	public void setGymUses(FacilityUse facilityUses);

	// getFacilityMaint
	public FacilityMaintenance getGymMaint();

	// setFacilityMaint
	public void setGymMaint(FacilityMaintenance facilityMaint);

	// listFacilityProblems
	public List<String> listGymProblems();

	// addFacilityProblem
	public void addGymProblem(String facilityProblem);

	// listMaintenance
	public MaintIssue listMaintenance();

	public void setCurrentMaintIssue(MaintIssueImpl currentMaintIssue);

	// getFacilityState
	public String getGymState();

	// setFacilityState
	public void setGymState(String facilityState);

	// getFacilityDetail
	public String getGymDetail();

	// addFacilityDetail
	public void addGymDetail(String facilityDetail);

	// getFacilityInformation
	public String getGymInformation();

	public double getPriceToBattle();

	public void setPriceToBattle(double priceToBattle);
}
