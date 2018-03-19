package com.comp373.model.building;

import java.util.ArrayList;
import java.util.List;

import com.comp373.model.facility.Gym;

public class BattleDomeImpl implements BattleDome {
	// a building contains facilities
	// a battledome contains gyms
	private String buildingId;
	private List<Gym> facilities;

	public BattleDomeImpl() {
	}

	public List<Gym> getFacilities() {
		return facilities;
	}

	public void setFacilities(List<Gym> facilities) {
		this.facilities = facilities;
	}

	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	public List<Gym> listFacilities() {
		return this.facilities;
	}

	public void addNewFacility(Gym facility) {
		this.facilities.add(facility);
	}

	public void removeFacility(Gym facility) {
		int index = this.facilities.indexOf(facility);
		this.facilities.remove(index);
		System.gc(); // get rid of unreferenced facility object
	}

}
