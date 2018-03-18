package com.comp373.model.building;

import java.util.List;

import com.comp373.model.facility.Gym;

public interface BattleDome {

	public List<Gym> getFacilities();

	public void setFacilities(List<Gym> facilities);

	public String getBuildingId();

	public void setBuildingId(String buildingId);

	public List<Gym> listFacilities();

	public void addNewFacility(Gym facility);

	public void removeFacility(Gym facility);
}
