package com.project0.logicalControllers;

//import java.util.ArrayList;
import java.util.HashMap;
//import java.util.List;

import com.project0.serialClass.ObjSerializer;
import com.project0.users.Customer;
import com.project0.users.Employee;

public  class UserAccounts extends ObjSerializer {
	
	public void creatEmployeeAcc(HashMap<String, String> details) {
		Employee newEmployee = new Employee(details.get("name"),  details.get("email"), details.get("password")
				,details.get("address"));
		obSerialer("employee",newEmployee);
	}
	public void creatCustomerAcc(HashMap<String, String> details) {
		Customer newCustomer= new Customer (details.get("name"), 
				details.get("email"), details.get("password"), details.get("address"));
		obSerialer("customer",newCustomer);
	}
	public boolean loginEmployee (HashMap<String, String> details){
		return correctPass("employee", details.get("email").trim(), details.get("password").trim());		
	}
	public boolean loginCustomer (HashMap<String, String> details){
		return correctPass("customer", details.get("email").trim(), details.get("password").trim());		
	}

}
