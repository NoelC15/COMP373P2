package com.comp373.constants;

import java.util.Map;

public class ApplicationConstants {
	public static Map<String, Integer> damageEvaluationDays;
	public static Map<String, Double> maintCost;
	// Various statuses
	public static final String GYM_BATTLE = "Gym battle";
	public static final String IN_MAINT = "In maintenance";
	public static final String IN_INSPECTION = "In inspection";
	public static final String VACANT = "Vacant";
	public static final String FAILURE = "Failed inspection";
	public static final String SUCCESS = "Passed inspection";

	// not aware of how to initialize maps in a one liner in Java
	public static void setDownTimeDays() {
		damageEvaluationDays.put("electrical", 2);
		damageEvaluationDays.put("structural", 5); // nothing ducktape can't fix
		damageEvaluationDays.put("water damage", 3);
		damageEvaluationDays.put("poisonous gas", 1); // just air it out
	}

	public static void setMaintCost() {
		maintCost.put("electrical", 20.75);
		maintCost.put("structural", 50.50);
		maintCost.put("water damage", 30.00);
		maintCost.put("poisonous gas", 10.99);
	}
	
	public static void setDamageEvaluationDays(Map<String, Integer> damageEvaluationDays) {
		ApplicationConstants.damageEvaluationDays = damageEvaluationDays;
	}

	public static void setMaintCost(Map<String, Double> maintCost) {
		ApplicationConstants.maintCost = maintCost;
	}
}
