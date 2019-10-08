package com.project0.logicalControllers;

//import java.util.ArrayList;
import java.util.HashMap;
//import java.util.List;

import com.project0.db.DataAcessor;
import com.project0.users.Customer;
import com.project0.users.Employee;

public  class UserAccounts extends DataAcessor{
	
	public void creatEmployeeAcc(HashMap<String, String> details) {
		Employee newEmployee = new Employee(details.get("name"),  details.get("email"), details.get("password")
				,details.get("address"));
		if(writeUsers(newEmployee)>0) {
			System.out.println("\n\n\t\t\t Accouunt Created !!!\n\n\n ");
			}else {
				System.out.println("Sorry Account Already Exists");
			}
	}
	public void creatCustomerAcc(HashMap<String, String> details) {
		Customer newCustomer= new Customer (details.get("name"), 
				details.get("email"), details.get("password"), details.get("address"));
		
		if(writeUsers(newCustomer)>0) {
		System.out.println("\n\n\t\t\t Accouunt Created !!!\n\n\n ");
		}else {
			System.out.println("Sorry Account Already Exists");
		}
	}
	public boolean loginEmployee (HashMap<String, String> details){
		return correctPass("employee", details.get("email").trim(), details.get("password").trim());		
	}
	private boolean correctPass(String dataType, String email, String password) {
		
		boolean outVal = false;
		if (dataType == "employee") {
				Employee emp = readEmployee(email).get(email);
				if(emp!=null) {
				if (emp.getPassWord().equals(password)) {
					outVal = true;
				} 
				else {outVal = false;}
				}else {
					outVal=false;
				}
		} else if (dataType == "customer") {			
				Customer emp =readCustomers(email).get(email);
				if(emp!=null) {
				if (emp.getPassWord().equals(password)) {
					outVal = true;
				} else
					outVal = false;
				}else {
					outVal=false;
				}
			} 
		return outVal;
	}
	public boolean loginCustomer (HashMap<String, String> details){
		return correctPass("customer", details.get("email").trim(), details.get("password").trim());		
	}

}