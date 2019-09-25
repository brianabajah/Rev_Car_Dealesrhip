package com.project0.RevDealers;

import java.util.HashMap;
import java.util.List;

public class UserAccounts {
	private List<Employee> EmAccounts;
	
	public void creatEmployeeAcc(HashMap<String, String> details) {
		Employee newEmployee = new Employee(details.get("name"),  details.get("email"), details.get("passWord"),
				details.get("dateOfBirth"),details.get("address"),
				details.get("position"), Integer.parseInt(details.get("employeeID")));
		EmAccounts.add(newEmployee);
		System.out.println(EmAccounts);
	}

}
