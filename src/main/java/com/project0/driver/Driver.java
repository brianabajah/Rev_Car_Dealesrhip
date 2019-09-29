package com.project0.driver;

import java.util.HashMap;
import java.util.Scanner;

import com.project0.logicalControllers.UserAccounts;
import com.project0.logicalControllers.UserInput;
import com.project0.menus.Menus;

public class Driver extends Menus {

	static UserInput userInput;
	static UserAccounts userAccounts;
	static HashMap<String, String> details;
	static Scanner sc;
	private static String menuSelect = "9";// main menu

	public static void main(String[] args) {
		userAccounts = new UserAccounts();
		userInput = new UserInput();
		userInput.loginRequirements();// create hashmap to store variables
		sc = new Scanner(System.in);
		
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
					if (userAccounts.loginCustomer(details)) {
						// go to customer
						customerMenu(sc,details.get("email"));
					} else {
						System.out.println("\n\n\t\tWrong PassWord/Email\n\n");						
					}
					menuSelect = details.get("nxtMenu");
					break;
				case "2":
					details = userInput.login("employee", sc);
					if (userAccounts.loginEmployee(details)) {
						// go to customer						
						employeeMenu(sc,details.get("email"));
					} else {
						System.out.println("\n\n\t\tWrong PassWord/Email\n\n");						
					}
					menuSelect = details.get("nxtMenu");
					break;
				case "3":
					accCreateOptions();
					break;
				case "4":
					details = userInput.createAccount("employee", sc);
					userAccounts.creatEmployeeAcc(details);
					menuSelect = details.get("nxtMenu");
					break;
				case "5":
					details = userInput.createAccount("customer", sc);
					userAccounts.creatCustomerAcc(details);
					menuSelect = details.get("nxtMenu");
					break;
				case "9":
					mMenu();
					break;
				default:
					mMenu();

				}
			} catch (Exception e) {
				e.printStackTrace();
				menuSelect = "0";
			}

		}

	}

	private static void mMenu() {
		mainMenu();
		menuselector("12309");

	}

	private static void accCreateOptions() {
		System.out.println("\n \n");
		System.out.println("CREATE ACCOUNT");
		System.out.println("SELECT 4 FOR EMPLOYEE. \nSELECT 5 FOR CUSTOMERS \nSELECT 9 FOR Main Menu.");
		menuselector("459");
	}

	private static void menuselector(String expected) {
		// expected should contain zero to exit
		System.out.println("\n \n");
		String outpt = "";

		while (true) {
			outpt = sc.next();
			if (expected.contains(outpt)) {
				menuSelect = outpt;
				break;
			} else {
				System.out.print("Please Choose Between   ");
				for (int x = 0; x < expected.length(); x++) {
					System.out.print(expected.charAt(x) + "    ");
				}
			}
		}

	}
}
