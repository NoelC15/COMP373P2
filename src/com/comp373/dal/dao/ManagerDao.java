package com.comp373.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.comp373.dal.DBHelper;
import com.comp373.model.bankaccount.BankAccount;
import com.comp373.model.bankaccount.BankAccountImpl;
import com.comp373.model.human.Manager;

public class ManagerDao {

	Manager manager;

	public ManagerDao() {
	}

	public Manager getManager(Long humanId) {

		try {
			// Get Manager
			Statement st = DBHelper.getConnection().createStatement();
			String selectManagerQuery = "SELECT humanId, lastName, firstName FROM Manager WHERE humanId = '" + humanId
					+ "'";

			ResultSet custRS = st.executeQuery(selectManagerQuery);
			System.out.println("ManagerDAO: *************** Query " + selectManagerQuery);
//			TODO DI for manager
			// Get Manager
//			Manager manager = new Manager();
			while (custRS.next()) {
				manager.setHumanId(custRS.getLong("humanId"));
				manager.setLastName(custRS.getString("lname"));
				manager.setFirstName(custRS.getString("fname"));
			}
			// close to manage resources
			custRS.close();

			// Get Expense Account
			String selectBankAccountQuery = "SELECT accountNumber, totalFunds FROM BankAccount WHERE humanId = '"
					+ humanId + "'";
			ResultSet addRS = st.executeQuery(selectBankAccountQuery);
//			TODO DI
			BankAccount bankAccount = new BankAccountImpl();

			System.out.println("ManagerDAO: *************** Query " + selectBankAccountQuery);

			manager.setAccount(bankAccount);
			// close to manage resources
			addRS.close();
			st.close();

			return manager;
		} catch (SQLException se) {
			System.err.println("ManagerDAO: Threw a SQLException retrieving the Manager object.");
			System.err.println(se.getMessage());
			se.printStackTrace();
		}

		return null;
	}

	public void addManager(Manager cust) {
		Connection con = DBHelper.getConnection();
<<<<<<< HEAD
        PreparedStatement custPst = null;
        PreparedStatement addPst = null;

        try {
        	//Insert the Manager object
            String custStm = "INSERT INTO Manager(humanId, lname, fname) VALUES(?, ?, ?)";
            custPst = con.prepareStatement(custStm);
            custPst.setLong(1, cust.getHumanId());
            custPst.setString(2, cust.getLastName());       
            custPst.setString(3, cust.getFirstName()); 
            custPst.executeUpdate();

        	//Insert the Manager bankAccount object
            String addStm = "INSERT INTO BankAccount(humanId, accountNumber) VALUES(?, ?)";
            addPst = con.prepareStatement(addStm);
            addPst.setLong(1, cust.getHumanId());
            addPst.setString(2, cust.getAccount().getAccountNumber());
            addPst.executeUpdate();
        } catch (SQLException ex) {

        } finally {

            try {
                if (addPst != null) {
                	addPst.close();
                	custPst.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
      	      System.err.println("ManagerDAO: Threw a SQLException saving the Manager object.");
    	      System.err.println(ex.getMessage());
            }
        }
    }
=======
		PreparedStatement custPst = null;
		PreparedStatement addPst = null;

		try {
			// Insert the Manager object
			String custStm = "INSERT INTO Manager(humanId, lname, fname) VALUES(?, ?, ?)";
			custPst = con.prepareStatement(custStm);
			custPst.setLong(1, cust.getHumanId());
			custPst.setString(2, cust.getLastName());
			custPst.setString(3, cust.getFirstName());
			custPst.executeUpdate();

			// Insert the Manager bankAccount object
			String addStm = "INSERT INTO BankAccount(humanId, accountNumber) VALUES(?, ?)";
			addPst = con.prepareStatement(addStm);
			addPst.setLong(1, cust.getHumanId());
			addPst.setString(2, cust.getAccount().getAccountNumber());
			addPst.executeUpdate();
		} catch (SQLException ex) {

		} finally {

			try {
				if (addPst != null) {
					addPst.close();
					custPst.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException ex) {
				System.err.println("ManagerDAO: Threw a SQLException saving the Manager object.");
				System.err.println(ex.getMessage());
			}
		}
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
>>>>>>> 7f6fb1b343fb1870d4b7f0f7f605472537e3ade3
}
