package com.project0.db;

public class LoginDetails {
//	private String url=System.getenv("URL");
//	private String password=System.getenv("PASSWORD");
//	private String name=System.getenv("NAME");
	
	private String url="jdbc:postgresql://postgressclass.cbenkxucrkvd.us-east-2.rds.amazonaws.com:5432/revdealers_db";
	private String password="1234";
	private String name="briana";
	
	public String getUrl() {
		return url;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}	
}
