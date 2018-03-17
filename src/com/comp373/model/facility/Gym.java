package com.comp373.model.facility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.comp373.maintenance.MaintIssue;
import com.comp373.service.FacilityMaintenance;
import com.comp373.service.FacilityUse;
import com.comp373.service.impl.FacilityMaintImpl;
import com.comp373.service.impl.FacilityUseImpl;

public interface Gym {

	public int requestAvailableCapacity();

	public void setCapacity(int capacity);

	public Date getOpenDate();

	public void setOpenDate(int year, int month, int day) throws ParseException;

	public String getFacilityName();

	public void setFacilityName(String facilityName);

	public FacilityUse getFacilityUses();

	public void setFacilityUses(FacilityUse facilityUses);

	public FacilityMaintenance getFacilityMaint();

	public void setFacilityMaint(FacilityMaintenance facilityMaint);

	public List<String> listFacilityProblems();

	public void addFacilityProblem(String facilityProblem);

	public MaintIssue listMaintenance();

	public void setCurrentMaintIssue(MaintIssue currentMaintIssue);

	public String getFacilityState();

	public void setFacilityState(String facilityState);

	public String getFacilityDetail();

	public void addFacilityDetail(String facilityDetail);

	public String getFacilityInformation();

	public double getPriceToBattle();

	public void setPriceToBattle(double priceToBattle);
}
