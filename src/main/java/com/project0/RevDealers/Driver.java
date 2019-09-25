package com.project0.RevDealers;

import java.util.HashMap;
import java.util.Scanner;

public class Driver {

	static UserInput userInput;
	static UserAccounts userAccounts;
	static HashMap<String,String> details;
	static Scanner sc;
	private static String menuSelect = "9";//main menu

	public static void main(String[] args) {
				
		userInput = new UserInput();
		userInput.loginRequirements();// create hashmap to store variables
		sc= new Scanner(System.in);
		
		systemOs();
		
		sc.close();
		
	}

	private static void systemOs() {
		boolean exit = true;
		while (exit) {		
			
				
				try {
				switch (menuSelect) {

				case "0":
					System.out.println("Program Closed");
					exit = false;
					break;
				case "1":
					details = userInput.login("customer", sc);
					menuSelect = details.get("nxtMenu");
					break;
				case "2":
					details=userInput.login("employee", sc);
					menuSelect=details.get("nxtMenu");
					break;
				case "3":
					accCreateOptions();
					break;
				case "4":
					details=userInput.createAccount("employee", sc);
					userAccounts.creatEmployeeAcc(details);
					menuSelect=details.get("nxtMenu");
					break;
				case "5":
					details=userInput.createAccount("customer", sc);	
					menuSelect=details.get("nxtMenu");
					break;
				case "9":
					mainMenu();
					break;
				default:
					mainMenu();
					
				}
				}catch(Exception e) {
					e.printStackTrace();
					menuSelect="0";
				}

		}

	}

	private static void mainMenu() {
		userInput.divider("========");
		System.out.println("            Welcome to RevDelers.\n        Revolutionizing The Motor Industry\n");

		System.out.println("-------------------------------------------------------");
		System.out.println("||      1         ||      2         ||       3        ||");
		System.out.println("|| Customer Login || Employee Login || Create Account ||");
		System.out.println("-------------------------------------------------------");
		System.out.println("\n Press 0 to exit app");
		
		menuselector("12309");
		
	}
	
	private static void accCreateOptions() {
		System.out.println("\n \n");
		System.out.println("CREATE ACCOUNT");
		System.out.println("SELECT 4 FOR EMPLOYEE. \nSELECT 5 FOR CUSTOMERS \nSELECT 9 FOR Main Menu.");
		menuselector("459");
	}
	
	private static void menuselector(String expected) {
		//expected should contain zero to exit
		System.out.println("\n \n");
		String outpt= "";	
		
		while(true) {
			outpt=sc.next();
			if(expected.contains(outpt)){
				menuSelect=outpt;
				break;
			}
			else{
				System.out.print("Please Choose Between   ");
				for(int x=0; x<expected.length();x++) {
					System.out.print(expected.charAt(x) + "    ");
				}
			}
		}		
		
	}
}
