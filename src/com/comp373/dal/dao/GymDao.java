package com.comp373.dal.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.comp373.dal.DBHelper;
import com.comp373.model.facility.Gym;

public class GymDao {

	private Gym gym;

	public GymDao() {
	}

	public Gym getGym(String gymName) {

		try {
			// Get Gym
			Statement st = DBHelper.getConnection().createStatement();
			String selectManagerQuery = "SELECT facilityName, capacity, openDate, inUse, priceToBatte FROM Gym WHERE gymName = '"
					+ gymName + "'";

			ResultSet custRS = st.executeQuery(selectManagerQuery);
			System.out.println("GymDAO: *************** Query " + selectManagerQuery);

			// Get Gym
			while (custRS.next()) {
				gym.setCapacity(custRS.getInt("capacity"));
				gym.setGymName(custRS.getString("facilityName"));
				gym.setPriceToBattle(custRS.getDouble("priceToBattle"));
			}
			// close to manage resources
			custRS.close();
			st.close();

			return gym;
		} catch (SQLException se) {
			System.err.println("GymDAO: Threw a SQLException retrieving the Gym object.");
			System.err.println(se.getMessage());
			se.printStackTrace();
		}

		return null;
	}

	public void addGym(Gym gym) {
		Connection con = DBHelper.getConnection();
		PreparedStatement custPst = null;
		PreparedStatement addPst = null;

		try {
			// Insert the Gym object
			String custStm = "INSERT INTO Gym(facilityName, capacity, inUse, priceToBattle, openDate) VALUES(?, ?, ?, ?, ?)";
			custPst = con.prepareStatement(custStm);
			custPst.setString(1, gym.getGymName());
			custPst.setInt(2, gym.requestAvailableCapacity());
			custPst.setDouble(3, gym.getPriceToBattle());
			custPst.setDate(5, (Date) gym.getOpenDate());
			custPst.executeUpdate();
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
				System.err.println("ManagerDAO: Threw a SQLException saving the Gym object.");
				System.err.println(ex.getMessage());
			}
		}
	}

	public Gym getGym() {
		return this.gym;
	}

	public void setGym(Gym gym) {
		this.gym = gym;
	}
}
