package com.comp373.model.facility;

import java.util.Date;

public class Gym extends Facility {
	private double priceToBattle;
	
	public Gym() {
		
	}
	
	public Gym(int capacity, double price, Date openDate, String gymName) {
		super(capacity, openDate, gymName);
		this.priceToBattle = price;
	}
	
	public double getPriceToBattle() {
		return priceToBattle;
	}

	public void setPriceToBattle(double priceToBattle) {
		this.priceToBattle = priceToBattle;
	}
}
