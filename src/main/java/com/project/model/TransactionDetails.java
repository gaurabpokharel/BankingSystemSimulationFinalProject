package com.project.model;

import java.sql.Date;

//TransactionDetails bean with getter setter and constructor
//Author:Ajay Shrestha (C0885384) Gaurab Pokharel (C0886046) Nirajan Karki (C0885390) Sakar Thapa (C0890972)
public class TransactionDetails {

	private String fromUserName;
	private String toUserName;
	private float amount;
	private Date transactionDate;
	
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public TransactionDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransactionDetails(String fromUserName, String toUserName, float amount, Date transactionDate) {
		super();
		this.fromUserName = fromUserName;
		this.toUserName = toUserName;
		this.amount = amount;
		this.transactionDate = transactionDate;
	}
	
	
}
