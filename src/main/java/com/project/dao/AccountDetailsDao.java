package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.model.AccountDetails;

public class AccountDetailsDao {

	public String saveAccount(AccountDetails accountDetails) {
		try (Connection con = DatabaseConnectivity.getConnection()) {
			if (con != null) {
				try (PreparedStatement ps = con.prepareStatement(
						"INSERT INTO account_details(full_name,dob,gender,username,email,sin,street,building,postal_code,account_type,initial_deposit,source_of_funds) VALUES (?, ?, ?, ?,?,?,?,?,?,?,?,?)")) {
					ps.setString(1, accountDetails.getFullName());
					ps.setDate(2, accountDetails.getDob());
					ps.setString(3, accountDetails.getGender());
					ps.setString(4, accountDetails.getUserName());
					ps.setString(5, accountDetails.getEmail());
					ps.setString(6, accountDetails.getSin());
					ps.setString(7, accountDetails.getStreet());
					ps.setString(8, accountDetails.getBuilding());
					ps.setString(9, accountDetails.getPostalCode());
					ps.setString(10, accountDetails.getAccountType());
					ps.setFloat(11, accountDetails.getInitalDeposit());
					ps.setString(12, accountDetails.getSourceOfFunds());

					int rowsAffected = ps.executeUpdate();
					if (rowsAffected > 0) {
						return "Success";
					} else {
						return "Failed";
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Failed";

	}

	public float getAccountBalance(String username) throws SQLException {
		float amount = 0.0f;
		try (Connection con = DatabaseConnectivity.getConnection()) {
			if (con != null) {
				try (PreparedStatement ps = con.prepareStatement(
						"SELECT initial_deposit FROM account_details WHERE account_type='checking' AND username = ?")) {
					ps.setString(1, username);
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						amount = rs.getFloat("initial_deposit");
					} else {
						System.out.println("No record is found");
					}
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return amount;
	}

	public String increaseReceiverAmount(String username, String email, float amount) {
		System.out.println(username);
		System.out.println(email);
		try (Connection con = DatabaseConnectivity.getConnection()) {
			if (con != null) {
				try (PreparedStatement ps = con.prepareStatement(
						"SELECT initial_deposit FROM account_details WHERE account_type='checking' AND username = ? AND email = ?")) {
					ps.setString(1, username);
					ps.setString(2, email);
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						float depositAmount = rs.getFloat("initial_deposit");
						float newAmount = amount + depositAmount;
						try (PreparedStatement updatePs = con.prepareStatement(
								"UPDATE account_details SET initial_deposit = ? WHERE account_type='checking' AND username = ? AND email = ?")) {
							updatePs.setFloat(1, newAmount);
							updatePs.setString(2, username);
							updatePs.setString(3, email);
							int rowsUpdated = updatePs.executeUpdate();
							if (rowsUpdated > 0) {
								return "Success";
							} else {
								return "Failed";
							}
						}
					} else {
						System.out.println("No record is found");
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "Failed";
	}

	public String decreaseSenderAmount(String username, float amount) {
		try (Connection con = DatabaseConnectivity.getConnection()) {
			if (con != null) {
				try (PreparedStatement ps = con.prepareStatement(
						"SELECT initial_deposit FROM account_details WHERE account_type='checking' AND username = ? ")) {
					ps.setString(1, username);
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						float depositAmount = rs.getFloat("initial_deposit");
						float newAmount = depositAmount - amount;
						try (PreparedStatement updatePs = con.prepareStatement(
								"UPDATE account_details SET initial_deposit = ? WHERE account_type='checking' AND username = ?")) {
							updatePs.setFloat(1, newAmount);
							updatePs.setString(2, username);
							int rowsUpdated = updatePs.executeUpdate();
							if (rowsUpdated > 0) {
								return "Success";
							} else {
								return "Failed";
							}
						}
					} else {
						System.out.println("No record is found");
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "Failed";
	}

	public List<String> getAccountType(String username) {
		List<String> accountTypes = new ArrayList<>();
		try (Connection con = DatabaseConnectivity.getConnection()) {
			if (con != null) {
				try (PreparedStatement ps = con
						.prepareStatement("SELECT account_type FROM account_details WHERE username = ? ")) {
					ps.setString(1, username);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						String account = rs.getString("account_type");
						accountTypes.add(account);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Username: " + username);
		System.out.println("Account types: " + accountTypes);
		return accountTypes;
	}

	public String increaseAccountTypeAmount(String username, String accountType, float amount) {
		try (Connection con = DatabaseConnectivity.getConnection()) {
			if (con != null) {
				try (PreparedStatement ps = con.prepareStatement(
						"SELECT initial_deposit FROM account_details WHERE account_type = ? AND username = ? ")) {
					ps.setString(1, accountType);
					ps.setString(2, username);
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						float depositAmount = rs.getFloat("initial_deposit");
						float newAmount = depositAmount + amount;
						try (PreparedStatement updatePs = con.prepareStatement(
								"UPDATE account_details SET initial_deposit = ? WHERE account_type = ? AND username = ?")) {
							updatePs.setFloat(1, newAmount);
							updatePs.setString(2, accountType);
							updatePs.setString(3, username);
							int rowsUpdated = updatePs.executeUpdate();
							if (rowsUpdated > 0) {
								return "Success";
							} else {
								return "Failed";
							}
						}
					} else {
						System.out.println("No record is found");
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "Failed";
	}

	public String decreaseAccountTypeAmount(String username, String accountType, float amount) {
		try (Connection con = DatabaseConnectivity.getConnection()) {
			if (con != null) {
				try (PreparedStatement ps = con.prepareStatement(
						"SELECT initial_deposit FROM account_details WHERE account_type = ? AND username = ? ")) {
					ps.setString(1, accountType);
					ps.setString(2, username);
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						float depositAmount = rs.getFloat("initial_deposit");
						float newAmount = depositAmount - amount;
						System.out.println(newAmount);
						try (PreparedStatement updatePs = con.prepareStatement(
								"UPDATE account_details SET initial_deposit = ? WHERE account_type = ? AND username = ?")) {
							updatePs.setFloat(1, newAmount);
							updatePs.setString(2, accountType);
							updatePs.setString(3, username);
							int rowsUpdated = updatePs.executeUpdate();
							if (rowsUpdated > 0) {
								return "Success";
							} else {
								return "Failed";
							}
						}
					} else {
						System.out.println("No record is found");
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "Failed";
	}
	
	public HashMap<String,Float> getAccountTypeAndBalance(String username) {
		HashMap<String,Float> accountTypes = new HashMap();
		try (Connection con = DatabaseConnectivity.getConnection()) {
			if (con != null) {
				try (PreparedStatement ps = con
						.prepareStatement("SELECT account_type,initial_deposit FROM account_details WHERE username = ? ")) {
					ps.setString(1, username);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						String account = rs.getString("account_type");
						Float amount = rs.getFloat("initial_deposit");
						accountTypes.put(account,amount);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountTypes;
	}

}
