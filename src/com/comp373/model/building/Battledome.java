package com.comp373.model.building;

import java.util.ArrayList;
import java.util.List;
import com.comp373.model.facility.Facility;

public class Battledome {
	//a building contains facilities
	//a battledome contains gyms
	private String buildingId;
	private List<Facility> facilities =  new ArrayList<Facility>();
	
	public Battledome() {}
	
	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	public List<Facility> listFacilities(){
		return this.facilities;
	}
	
	public void addNewFacility(Facility facility) {
		this.facilities.add(facility);
	}
	
	public void removeFacility(Facility facility) {
		int index = this.facilities.indexOf(facility);
		this.facilities.remove(index);
		System.gc(); //get rid of unreferenced facility object
	}

}
