package com.comp373.model.facility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.comp373.maintenance.MaintIssue;
import com.comp373.service.FacilityMaintenance;
import com.comp373.service.FacilityUse;
import com.comp373.service.impl.FacilityMaintenanceImpl;
import com.comp373.service.impl.FacilityUseImpl;

public class GymImpl implements Gym {
	private double priceToBattle;
	private int capacity;
	private Date openDate;
	private String facilityName;
	private String facilityState;
	private String facilityDetail;
	private List<String> facilityProblems = new ArrayList<String>();
	/* List of the full sentence issues describing problems occuring from damage */
	private MaintIssue currentMaintIssue; // make this null when curr issue is resolved

	// interfaces
	// trying to do this using DIP slides as reference
	// probably will end up refactoring when switching to Spring
	// TODO DI
	private FacilityUse facilityUses = new FacilityUseImpl();
	private FacilityMaintenance facilityMaint = new FacilityMaintenanceImpl();

	public GymImpl() {

	}

	public GymImpl(int capacity, double price, Date openDate, String gymName) {
		this.capacity = capacity;
		this.openDate = openDate;
		this.setGymName(gymName);
		// super(capacity, openDate, gymName);
		this.priceToBattle = price;
	}

	public int requestAvailableCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Date getOpenDate() {
		return this.openDate;
	}

	public void setOpenDate(int year, int month, int day) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		this.openDate = dateFormat
				.parse(Integer.toString(year) + "/" + Integer.toString(month) + "/" + Integer.toString(day));
	}

	public String getGymName() {
		return facilityName;
	}

	public void setGymName(String facilityName) {
		this.facilityName = facilityName;
	}

	public FacilityUse getGymUses() {
		return facilityUses;
	}

	public void setGymUses(FacilityUse facilityUses) {
		this.facilityUses = facilityUses;
	}

	public FacilityMaintenance getGymMaint() {
		return facilityMaint;
	}

	public void setGymMaint(FacilityMaintenance facilityMaint) {
		this.facilityMaint = facilityMaint;
	}

	public List<String> listGymProblems() {
		return facilityProblems;
	}

	public void addGymProblem(String facilityProblem) {
		this.facilityProblems.add(facilityProblem);
	}

	public MaintIssue listMaintenance() {
		return currentMaintIssue;
	}

	public void setCurrentMaintIssue(MaintIssue currentMaintIssue) {
		this.currentMaintIssue = currentMaintIssue;
	}

	public String getGymState() {
		return facilityState;
	}

	public void setGymState(String facilityState) {
		this.facilityState = facilityState;
	}

	public String getGymDetail() {
		return facilityDetail;
	}

	public void addGymDetail(String facilityDetail) {
		this.facilityDetail = facilityDetail;
	}

	public String getGymInformation() {
		return this.facilityDetail;
	}

	public double getPriceToBattle() {
		return priceToBattle;
	}

	public void setPriceToBattle(double priceToBattle) {
		this.priceToBattle = priceToBattle;
	}
}
