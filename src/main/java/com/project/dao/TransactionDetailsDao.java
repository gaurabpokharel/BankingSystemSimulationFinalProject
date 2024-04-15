package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.model.TransactionDetails;

public class TransactionDetailsDao {
	//Method to save transaction details in the database
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
	
	//Method to get all transaction details
	public List<TransactionDetails> getAllTransactionDetails(String userName) {
        List<TransactionDetails> transactionList = new ArrayList<>();
        try (Connection con = DatabaseConnectivity.getConnection()) {
            if (con != null) {
                try (PreparedStatement ps = con.prepareStatement(
                        "SELECT * FROM transaction_details where to_username = ?")) {
                	ps.setString(1, userName);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        TransactionDetails transaction = new TransactionDetails();
                        transaction.setFromUserName(rs.getString("from_username"));
                        transaction.setToUserName(rs.getString("to_username"));
                        transaction.setAmount(rs.getFloat("amount"));
                        transaction.setTransactionDate(rs.getDate("transaction_date"));
                        transactionList.add(transaction);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactionList;
    }
	
	public List<TransactionDetails> getAllToTransactionDetails(String userName) {
        List<TransactionDetails> transactionList = new ArrayList<>();
        try (Connection con = DatabaseConnectivity.getConnection()) {
            if (con != null) {
                try (PreparedStatement ps = con.prepareStatement(
                        "SELECT * FROM transaction_details where from_username = ?")) {
                	ps.setString(1, userName);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        TransactionDetails transaction = new TransactionDetails();
                        transaction.setFromUserName(rs.getString("from_username"));
                        transaction.setToUserName(rs.getString("to_username"));
                        transaction.setAmount(rs.getFloat("amount"));
                        transaction.setTransactionDate(rs.getDate("transaction_date"));
                        transactionList.add(transaction);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactionList;
    }
}
