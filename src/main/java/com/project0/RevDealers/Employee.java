package com.project0.RevDealers;


@SuppressWarnings("serial")
public class Employee extends User {

private String position;
private boolean administrator;
private boolean superUser;
private int employeeID;

public Employee() {
	super();
}
public Employee(String name, String email, String passWord, String dateOfBirth, String address, String position, int employeeID) {
	super(name, email, passWord, dateOfBirth, address);
	this.employeeID=employeeID;
	this.position = position;	
	// TODO Auto-generated constructor stub
}
public String getPosition() {
	return position;
}
public void setPosition(String position) {
	this.position = position;
}
public boolean isAdministrator() {
	return administrator;
}
public void setAdministrator(boolean administrator) {
	this.administrator = administrator;
}
public boolean isSuperUser() {
	return superUser;
}
public void setSuperUser(boolean superUser) {
	this.superUser = superUser;
}
public int getEmployeeID() {
	return employeeID;
}
public void setEmployeeID(int employeeID) {
	this.employeeID = employeeID;
}

}
