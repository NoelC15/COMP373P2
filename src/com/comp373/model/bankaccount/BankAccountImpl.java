package com.comp373.model.bankaccount;

import java.util.Random;

import com.comp373.model.human.Human;

public class BankAccountImpl implements BankAccount {
	private String accountNumber;
	private double totalFunds;
	private static Random Randomgenerator = new Random(System.currentTimeMillis()); 
	
	public BankAccountImpl (){
		accountNumber =  Integer.toString(Randomgenerator.nextInt(1000) + 9999);
		totalFunds = 0.0;
	}
	
	public BankAccountImpl (String account){
		this.accountNumber = account;
	}
	
	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public static Random getRandomgenerator() {
		return Randomgenerator;
	}

	public static void setRandomgenerator(Random randomgenerator) {
		Randomgenerator = randomgenerator;
	}

	
	
	public void setTotalFunds(double fund){
		totalFunds = fund;
	}
	
	public double getTotalFunds(){
		return totalFunds;
	}
	
	public void payMaintance(double withdraw){
		totalFunds = totalFunds - withdraw;
	}
	
	public boolean transferFunds(double payment, Human userToPay){
		//totalFunds = totalFunds + increment;
		//TODO : CALLING ON BANK ACCOUNT ON WHICH USER IS PAYING I AM GETTING THERE ACCOUNT BALCANCE TO SEE IF THEY HAVE ENOUGH MONEY
		/*
		 * IF THEY HAVE ENOUGH THEN YOU SET THEIR ACCOUNT BALANCE MINUS WHAT THEY RE PAYING 
		 * GET OTHER USERS THEIR BACK ACCOUNT BALANCE AND THEN ADD MONEY TO THAT ACCOUNT
		 */
		boolean enoughMoney = false;
		if(payment > totalFunds){
			return enoughMoney;
		}else{
			totalFunds -= payment;
			BankAccount user = userToPay.getAccount();
			user.setTotalFunds(user.getTotalFunds() + payment);
			enoughMoney = true;
		}
		return enoughMoney;
		
	}
	
	//TODO: increment funds to user 
	
	public void approvePayment(){
		
	}
}
