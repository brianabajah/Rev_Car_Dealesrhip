package com.project0.users;

@SuppressWarnings("serial")
public class Employee extends User {

	private boolean administrator;

	public Employee() {
		super();
	}

	public Employee(String name, String email, String passWord, String address) {
		super(name, email, passWord, address);
		// TODO Auto-generated constructor stub
		if(email.equals("s@r.c")) {administrator=true;}
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
		return "\n\t\t\tEmployee [\n\t\t\t\t administrator\t\t" + administrator + "\n\t\t\t\t Name\t\t" + getName() + "\n\t\t\t\t Email\t\t" + getEmail()
				+ "\n\t\t\t\t Address\t\t" + getAddress() + "\n\t\t\t\t]\n";
	}
	


}
