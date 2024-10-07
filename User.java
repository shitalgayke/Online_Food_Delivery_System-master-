package com.mypackage.fooddeliverysystem.entities;

public class User {
	
	private int userId;
	private String userName;
	private long contactNo;
	
	public User() {
		super();
	}

	public User(int userId, String userName, long contactNo) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.contactNo = contactNo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", contactNo=" + contactNo + "]";
	}
	
	
	
	
	
	

}
