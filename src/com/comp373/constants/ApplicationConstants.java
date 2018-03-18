package com.comp373.constants;

import java.util.HashMap;
import java.util.Map;

public class ApplicationConstants {
	// TODO DI
	public static Map<String, Integer> DAMAGEEVALUTIONDAYS = new HashMap<String, Integer>();
	public static Map<String, Double> MAINTCOST = new HashMap<String, Double>();
	// Various statuses
	public static final String GYM_BATTLE = "Gym battle";
	public static final String IN_MAINT = "In maintenance";
	public static final String IN_INSPECTION = "In inspection";
	public static final String VACANT = "Vacant";
	public static final String FAILURE = "Failed inspection";
	public static final String SUCCESS = "Passed inspection";

	// not aware of how to initialize maps in a one liner in Java
	public static void setDownTimeDays() {
		DAMAGEEVALUTIONDAYS.put("electrical", 2);
		DAMAGEEVALUTIONDAYS.put("structural", 5); // nothing ducktape can't fix
		DAMAGEEVALUTIONDAYS.put("water damage", 3);
		DAMAGEEVALUTIONDAYS.put("poisonous gas", 1); // just air it out
	}

	public static void setMaintCost() {
		MAINTCOST.put("electrical", 20.75);
		MAINTCOST.put("structural", 50.50);
		MAINTCOST.put("water damage", 30.00);
		MAINTCOST.put("poisonous gas", 10.99);
	}
}
