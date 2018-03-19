package com.comp373.model.human;

import com.comp373.model.bankaccount.BankAccount;

public class HumanImpl implements Human {
	private String firstName;
	private String lastName;
	private BankAccount account;
	private long humanId;

	public HumanImpl() {

	}

	public HumanImpl(String fName, String lName, BankAccount account, long id) {
		this.firstName = fName;
		this.lastName = lName;
		this.account = account;
		this.humanId = id;
	}

	public long getHumanId() {
		return humanId;
	}

	public void setHumanId(long humanId) {
		this.humanId = humanId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}

	public BankAccount getAccount() {
		return this.account;
	}

}
