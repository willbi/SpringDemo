package com.blog.entity;

public class BlogUserEntity {

	private int userID;
	private String userCode;
	private String userName;
	private String userPassword;

	public int getUserID() {
		return this.userID;
	}
	public String getUserCode() {
		return this.userCode;
	}
	public String getUserName() {
		return this.userName;
	}
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
