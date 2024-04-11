package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.project.model.AccountDetails;
import com.project.model.TransactionDetails;

public class TransactionDetailsDao {
	public String saveTransctionDetails(TransactionDetails transactionDetails) {
		try (Connection con = DatabaseConnectivity.getConnection()) {
			if (con != null) {
				try (PreparedStatement ps = con.prepareStatement(
						"INSERT INTO transaction_details(from_username,to_username,amount,transaction_date) VALUES (?, ?, ?, ?)")) {
					ps.setString(1, transactionDetails.getFromUserName());
					ps.setString(2, transactionDetails.getToUserName());
					ps.setFloat(3, transactionDetails.getAmount());
					ps.setDate(4, transactionDetails.getTransactionDate());
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
}
