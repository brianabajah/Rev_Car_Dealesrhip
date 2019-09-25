package com.project0.RevDealers;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable  {
	private String name;
	private String email;
	private String passWord;
	private String dateOfBirth;
	private String address;
	
	public User() {
	}
	public User(String name, String email, String passWord, String dateOfBirth, String address) {
		this.name = name;
		this.email = email;
		this.passWord = passWord;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}	

}
