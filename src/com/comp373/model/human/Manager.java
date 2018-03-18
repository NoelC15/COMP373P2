package com.comp373.model.human;

import com.comp373.model.bankaccount.BankAccount;
import com.comp373.model.building.BattleDome;

public class Manager extends Human {

	private BattleDome battleDome;
	// manager's have one battledome which contains multiple facilities

	public Manager() {
		super();
		// TODO: finish this constructor
	}

	public Manager(String fName, String lName, BankAccount accountNumber, BattleDome Dome, long id) {
		super(fName, lName, accountNumber, id);
		battleDome = Dome;
	}

	public void setBattleDome(BattleDome newDome) {
		battleDome = newDome;
	}

	public BattleDome getBattleDome() {
		return battleDome;
	}
}
