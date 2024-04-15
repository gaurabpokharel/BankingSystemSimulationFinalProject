package com.project.model;

import java.sql.Date;

//AccountDetails bean with getter setter and constructor
//Author:Ajay Shrestha (C0885384) Gaurab Pokharel (C0886046) Nirajan Karki (C0885390) Sakar Thapa (C0890972)
public class AccountDetails {

	private String fullName;
	private Date dob;
	private String gender;
	private String userName;
	private String email;
	private String sin;
	private String street;
	private String building;
	private String postalCode;
	private String accountType;
	private float initalDeposit;
	private String sourceOfFunds;
	
	
	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSin() {
		return sin;
	}


	public void setSin(String sin) {
		this.sin = sin;
	}


	public String getBuilding() {
		return building;
	}


	public void setBuilding(String building) {
		this.building = building;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public float getInitalDeposit() {
		return initalDeposit;
	}


	public void setInitalDeposit(float initalDeposit) {
		this.initalDeposit = initalDeposit;
	}


	public String getSourceOfFunds() {
		return sourceOfFunds;
	}


	public void setSourceOfFunds(String sourceOfFunds) {
		this.sourceOfFunds = sourceOfFunds;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public AccountDetails(String fullName, Date dob, String gender, String userName, String email, String sin,
			String street, String building, String postalCode, String accountType, float initalDeposit,
			String sourceOfFunds) {
		super();
		this.fullName = fullName;
		this.dob = dob;
		this.gender = gender;
		this.userName = userName;
		this.email = email;
		this.sin = sin;
		this.street = street;
		this.building = building;
		this.postalCode = postalCode;
		this.accountType = accountType;
		this.initalDeposit = initalDeposit;
		this.sourceOfFunds = sourceOfFunds;
	}


	public AccountDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
