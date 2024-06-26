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
//Author:Ajay Shrestha (C0885384) Gaurab Pokharel (C0886046) Nirajan Karki (C0885390) Sakar Thapa (C0890972)
public class AccountDetailsDao {

	//Method to save account details in database
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

	//Method to get account balance according with the username
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
	
	//Method to get account balance according to account type
	public float getAccountBalanceInAccountType(String username, String accountType) throws SQLException {
		float amount = 0.0f;
		try (Connection con = DatabaseConnectivity.getConnection()) {
			if (con != null) {
				try (PreparedStatement ps = con.prepareStatement(
						"SELECT initial_deposit FROM account_details WHERE account_type=? AND username = ?")) {
					ps.setString(1, accountType);
					ps.setString(2, username);
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

	//Method to increase the amount in receiver account in checking account type
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

	//Method to decrease  the amount in sender account in checking account type
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

	//Method to reterieve all the account type list according to the username
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

	//Method to increase balance in account type
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

	//Method to decrease balance in account type 
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
	
	//Method to get account type with it's balance
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
	
	//Method to get total balance of the user
	public static String getTotalBalance(String username) {
        AccountDetailsDao dao = new AccountDetailsDao();
        HashMap<String, Float> accountTypesAndBalances = dao.getAccountTypeAndBalance(username);
        float totalBalance = 0.0f;
        for (Map.Entry<String, Float> entry : accountTypesAndBalances.entrySet()) {
            totalBalance += entry.getValue();
        }
        return String.format("%.2f", totalBalance); 
    }
	
		public Boolean isUserNameEmailExist(String username, String email) {
			try (Connection con = DatabaseConnectivity.getConnection()) {
				if (con != null) {
					try (PreparedStatement ps = con.prepareStatement(
							"SELECT * FROM account_details WHERE username = ? AND email = ? AND account_type = 'checking' ")) {
						ps.setString(1, username);
						ps.setString(2, email);
						ResultSet rs = ps.executeQuery();
						if (rs.next()) {
							return true;
						} else {
							System.out.println("No record is found");
						}
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
			return false;
		}
	
}
