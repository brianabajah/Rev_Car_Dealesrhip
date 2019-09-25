package com.project0.RevDealers;

import java.util.HashMap;
import java.util.Scanner;

public class UserInput extends ValueValidater {

	private HashMap<String, String> loginDetails;

	private ValueValidater vava = new ValueValidater();

	private String[] fields = { "name", "email", "password", "dateOfBirth", "address", "employeeID", "position",
			"address", "customerID", "nxtMenu" };
	private String[] addresss= {"Address Line One:","Address Line Two:","City:","State / Province / Region:","Zip / Postal Code:"};

	public void loginRequirements() {
		loginDetails = new HashMap<String, String>();
		for (String va : fields) {
			loginDetails.put(va, "");
		}

	}

	public HashMap<String, String> login(String user, Scanner sci) {
		divider("LOG IN");
		loginDetails.clear();

		if (user == "customer") {
			System.out.println("ENTER NAME BELOW");

			loginDetails.put("name", sci.next());

		} else if (user == "employee") {
			System.out.println("ENTER EMPLOYEE ID");
			loginDetails.put("employeeID", sci.next());
		}

		System.out.println("ENTER PASSWORD BELOW");
		loginDetails.put("password", sci.next());

		loginDetails.put("nxtMenu", "9");
		
		return loginDetails;

	}

	public void divider(String div) {
		System.out.println("=======================================================\n====================" + div
				+ "====================\n");

	}

	public HashMap<String, String> createAccount(String user, Scanner sc) {
		loginRequirements();
		divider("CREATE ACCOUNT");
		for (String va : fields) {
			if (va == "email") {
				while (!vava.emailValidater(loginDetails.get("email"))) {
					System.out.println("ENTER " + va.toUpperCase() + " BELOW");
					loginDetails.put(va, sc.next());
				}
			} else if (va == "employeeID" || va == "position") {
				if (user == "employee") {
					System.out.println("ENTER " + va.toUpperCase() + " BELOW");
					loginDetails.put(va, sc.next());
				}

			} else if (va == "customerID") {
				if (user == "customer") {
					System.out.println("ENTER " + va.toUpperCase() + " BELOW");///System generated later on
					loginDetails.put(va, sc.next());
				}
			} else if (va == "address") {	

				System.out.println("ENTER ADDRESS BELOW");
				String[] scv = new String[5];
				for(int m=0;m<addresss.length;m++) {
					System.out.println(addresss[m]);
					scv[m] = sc.next();
				}
				
				// loop through some value
				loginDetails.put("address", String.join(" ", scv));
			}
			else {
				System.out.println("ENTER " + va.toUpperCase() + " BELOW");
				loginDetails.put(va, sc.next());
			}
		}
		System.out.println("\n\nPress 1 to finish and 0 to go back to start");
		String fin =sc.next();
		if(fin=="0") {loginRequirements(); loginDetails.put("nxtMenu","9");}
		else if (fin =="1") { loginDetails.put("nxtMenu","10");}	
		
		return loginDetails;
	}

}
