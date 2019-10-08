package com.project0.users;

public class Employee extends User {
	private int employeeId;
	private boolean administrator;

	public Employee() {
		super();
	}

	public Employee(String name, String email, String passWord, String address) {
		super(name, email, passWord, address);
		// TODO Auto-generated constructor stub
		if(email.equals("super")) {administrator=true;}
	}

	public boolean isAdministrator() {
		return administrator;
	}

	public void setAdministrator(boolean administrator, Employee e) {
		if(e.isAdministrator()==true) {
		this.administrator = administrator;
		}
	}

	@Override
	public String toString() {
		return "\n\t\t\tEmployee [\n\t\t\t\t administrator\t\t" + administrator + "\n\t\t\t\t Name\t\t" + getName() + "\n\t\t\t\t 	EmployeeId\t\t" + employeeId + "\n\t\t\t\t Email\t\t" + getEmail()
				+ "\n\t\t\t\t Address\t\t" + getAddress() + "\n\t\t\t\t]\n";
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	


}
