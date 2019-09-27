package com.project0.users;

@SuppressWarnings("serial")
public class Employee extends User {

	private boolean administrator;


	@Override
	public String toString() {
		return "Employee [administrator=" + administrator + ", employeeID=" + employeeID + ", getName()=" + getName()
				+ ", getEmail()=" + getEmail() + ", getPassWord()=" + getPassWord() + ", getAddress()=" + getAddress()
				+ "]";
	}

	private int employeeID;

	public Employee() {
		super();
	}

	public Employee(String name, String email, String passWord, String address) {
		super(name, email, passWord, address);
		// TODO Auto-generated constructor stub
	}

	public boolean isAdministrator() {
		return administrator;
	}

	public void setAdministrator(boolean administrator) {
		this.administrator = administrator;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

}
