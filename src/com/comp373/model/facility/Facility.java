//package com.comp373.model.facility;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import com.comp373.maintenance.MaintIssue;
//import com.comp373.service.FacilityMaintenance;
//import com.comp373.service.FacilityUse;
//import com.comp373.service.impl.FacilityMaintImpl;
//import com.comp373.service.impl.FacilityUseImpl;
//
////superclass
//public class Facility {
//	
//	private int capacity;
//	private Date openDate;
//	private String facilityName;
//	private String facilityState;
//	private String facilityDetail;
//	private List<String> facilityProblems = new ArrayList<String>();
//	/*List of the full sentence issues describing problems occuring from damage*/
//	private MaintIssue currentMaintIssue; //make this null when curr issue is resolved
//	
//	//interfaces
//	//trying to do this using DIP slides as reference
//	//probably will end up refactoring when switching to Spring
//	private FacilityUse facilityUses = new FacilityUseImpl();
//	private FacilityMaintenance facilityMaint = new FacilityMaintImpl();
//	
//	public Facility() {
//		
//	}
//	
//	public Facility(int capacity, Date openDate, String name) {
//		this.capacity = capacity;
//		this.openDate = openDate;
//		this.setFacilityName(name);
//	}
//
//	public int requestAvailableCapacity() {
//		return capacity;
//	}
//
//	public void setCapacity(int capacity) {
//		this.capacity = capacity;
//	}
//	
//	public Date getOpenDate() {
//		return this.openDate;
//	}
//	
//	public void setOpenDate(int year, int month, int day) throws ParseException {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//		this.openDate = dateFormat.parse(Integer.toString(year)+"/"+Integer.toString(month)+"/"+Integer.toString(day));
//	}
//
//	public String getFacilityName() {
//		return facilityName;
//	}
//
//	public void setFacilityName(String facilityName) {
//		this.facilityName = facilityName;
//	}
//
//	public FacilityUse getFacilityUses() {
//		return facilityUses;
//	}
//
//	public void setFacilityUses(FacilityUse facilityUses) {
//		this.facilityUses = facilityUses;
//	}
//
//	public FacilityMaintenance getFacilityMaint() {
//		return facilityMaint;
//	}
//
//	public void setFacilityMaint(FacilityMaintenance facilityMaint) {
//		this.facilityMaint = facilityMaint;
//	}
//	
//	public List<String> listFacilityProblems() {
//		return facilityProblems;
//	}
//	
//	public void addFacilityProblem(String facilityProblem) {
//		this.facilityProblems.add(facilityProblem);
//	}
//
//	public MaintIssue listMaintenance() {
//		return currentMaintIssue;
//	}
//
//	public void setCurrentMaintIssue(MaintIssue currentMaintIssue) {
//		this.currentMaintIssue = currentMaintIssue;
//	}
//
//	public String getFacilityState() {
//		return facilityState;
//	}
//
//	public void setFacilityState(String facilityState) {
//		this.facilityState = facilityState;
//	}
//
//	public String getFacilityDetail() {
//		return facilityDetail;
//	}
//
//	public void addFacilityDetail(String facilityDetail) {
//		this.facilityDetail = facilityDetail;
//	}
//	
//	public String getFacilityInformation() {
//		return this.facilityDetail;
//	}
//}
