package com.project0.logicalControllers;

import java.util.HashMap;
import java.util.Scanner;

public class UserInput extends ValueValidater {

	private HashMap<String, String> loginDetails;

	private ValueValidater vava = new ValueValidater();

	private String[] fields = { "name", "email", "password", "address", "nxtMenu" };
	private String[] addresss= {"Address :","Zip / Postal Code:"};

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
			System.out.println("ENTER EMAIL BELOW");

			loginDetails.put("email", sci.next().trim());

		} else if (user == "employee") {
			System.out.println("ENTER EMAIL BELOW");
			loginDetails.put("email", sci.next().trim());
		}

		System.out.println("ENTER PASSWORD BELOW");
		loginDetails.put("password", sci.next().trim());

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
					loginDetails.put(va, sc.next().trim());
				}
			} else if (va == "address") {					
				System.out.println("ENTER ADDRESS BELOW");
				String[] scv = new String[2];				
				for(int m=0;m<addresss.length;m++) {
					System.out.println(addresss[m]);	
					scv[m] = sc.nextLine().trim();
				}
				
				// loop through some value
				loginDetails.put("address", String.join("\t1 ", scv));
			} else if (va == "nxtMenu") {}
			else {
				sc.nextLine();
				System.out.println("ENTER " + va.toUpperCase() + " BELOW");
				loginDetails.put(va, sc.nextLine().trim());
			}
		}		
		while(true) {
			System.out.println("\t\t\t\tReview");
			loginDetails.forEach((key,val)->System.out.println("\t\t"+key+":\t\t"+val));
			System.out.println("\n\nPress 1 to finish and 0 to go back to start");
			String fin =sc.next();
			if(fin.equals("0")) {loginDetails.put("nxtMenu","9"); break;}
			else if (fin.equals("1")) { loginDetails.put("nxtMenu","10"); break;}	
		}
		
		
		
		return loginDetails;
	}

}
