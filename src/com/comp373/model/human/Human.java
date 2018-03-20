package com.comp373.model.human;

import com.comp373.model.bankaccount.BankAccount;

public interface Human {

	public long getHumanId();

	public void setHumanId(long humanId);

	public void setFirstName(String firstName);

	public String getFirstName();

	public void setLastName(String lastName);

	public String getLastName();

	public void setAccount(BankAccount account);

	public BankAccount getAccount();

}
