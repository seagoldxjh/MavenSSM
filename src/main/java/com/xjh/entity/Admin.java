package com.xjh.entity;

public class Admin {
	private int admNo;
	private String admName;
	private String passWord;
	public Admin() {
	}
	public Admin(int admNo, String admName, String passWord) {
		this.admNo = admNo;
		this.admName = admName;
		this.passWord = passWord;
	}

	public int getAdmNo() {
		return admNo;
	}

	public void setAdmNo(int admNo) {
		this.admNo = admNo;
	}

	public String getAdmName() {
		return admName;
	}

	public void setAdmName(String admName) {
		this.admName = admName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "Admin [admNo=" + admNo + ", admName=" + admName + ", passWord=" + passWord + "]";
	}
	
}
