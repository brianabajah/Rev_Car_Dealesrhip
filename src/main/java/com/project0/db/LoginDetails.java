package com.project0.db;

public class LoginDetails {
	private String url=System.getenv("URL");
	private String password=System.getenv("PASSWORD");
	private String name=System.getenv("NAME");
	
	
	
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
