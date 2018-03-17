package com.comp373.model.bankaccount;

import com.comp373.model.human.Human;

public interface BankAccount {

	public String getAccountNumber();
	
	public void setAccountNumber(String accountNumber);
	
	public void setTotalFunds(double fund);

	public double getTotalFunds();

	public void payMaintance(double withdraw);

	public boolean transferFunds(double payment, Human userToPay);

	// TODO: increment funds to user

	public void approvePayment();


}
