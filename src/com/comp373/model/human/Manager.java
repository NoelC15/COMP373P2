package com.comp373.model.human;

import com.comp373.model.bankaccount.BankAccount;
import com.comp373.model.building.Battledome;

public class Manager extends HumanImpl {

	private Battledome battleDome;
	// manager's have one battledome which contains multiple facilities

	public Manager() {
		super();
		// TODO: finish this constructor
	}

	public Manager(String fName, String lName, BankAccount accountNumber, Battledome Dome, long id) {
		super(fName, lName, accountNumber, id);
		battleDome = Dome;
	}

	public void setBattleDome(Battledome newDome) {
		battleDome = newDome;
	}

	public Battledome getBattleDome() {
		return battleDome;
	}
}
