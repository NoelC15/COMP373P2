package com.comp373.model.bankaccount;

import com.comp373.model.human.HumanImpl;

public interface BankAccount {
	public String getAccountNumber();
	public void setAccountNumber(String accountNumber);
	public void setTotalFunds(double fund);
	public double getTotalFunds();
	public void payMaintance(double withdraw);
	public boolean transferFunds(double payment, HumanImpl userToPay);
	// TODO: increment funds to user
	public void approvePayment();

}
