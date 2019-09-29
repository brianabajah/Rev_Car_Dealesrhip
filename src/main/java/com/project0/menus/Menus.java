package com.project0.menus;

import java.util.HashMap;
import java.util.Scanner;
import com.project0.Cars.Car;
import com.project0.logicalControllers.UserInput;
import com.project0.serialClass.ObjSerializer;
import com.project0.users.Customer;

public class Menus extends ObjSerializer {
//	viewCars("RevDealers"); use to view all cars in the lot
	private static HashMap<String, Object> everything = readObjectList();
	@SuppressWarnings("unchecked")
	private static HashMap<Integer, Car> allLotCars = (HashMap<Integer, Car>) everything.get("car");
	@SuppressWarnings("unchecked")
	private static HashMap<String, Customer> allCustomers= (HashMap<String, Customer>) everything.get("customer");
	private static UserInput userInput = new UserInput();

	public static void mainMenu() {
		userInput.divider("===============");
		System.out.println("            Welcome to RevDelers.\n        Revolutionizing The Motor Industry\n");

		System.out.println("-------------------------------------------------------");
		System.out.println("||      1         ||      2         ||       3        ||");
		System.out.println("|| Customer Login || Employee Login || Create Account ||");
		System.out.println("-------------------------------------------------------");
		System.out.println("\n Press 0 to exit app");
	}

	public static void customerMenu(Scanner sc, String email) {
		Customer custm = (Customer)allCustomers.get(email);
		userInput.divider(custm.getName());
		System.out.print("Select:\t 1:\t View All Available Cars");
		System.out.print("Select:\t 1:\t View All Available Cars");
		System.out.print("Select:\t 1:\t View All Available Cars");
		// view all cars
		//make offer
		//view my cars display with view remaining payment
		//

	}

	public static void employeeMenu(Scanner sc, String email) {
		// View Cars --viewCars
		// View Car Offers
		// view Payment
		// Admin Tools----Get employee from list and make Admin

	}

	public static void viewCars(String who) {
		userInput.divider("===============");
		allLotCars.forEach((key, val) -> {

			if (((Car) val).getOwner().equals(who)) {
				System.out.println("Select\t" + key + "\t to choose:\t\t" + val);
			}
		});
		userInput.divider("===============");

	}

	protected static void makeOffer(Scanner sc, String email) {
		System.out.println("What is your Car Selection:");
		int x, amount = 0;
		Car offerCar = null;
		while (true) {
			x = sc.nextInt();
			if (x != 909) {
				System.out.println("Enter Offer Amount:");
				amount = sc.nextInt();
			} else {
				break;
			}
			if (allLotCars.keySet().contains(x)) {
				offerCar = allLotCars.get(x);
				offerCar.setOffers(email, amount);
				break;
			} else {
				System.out.println("The Car Integer Selection does not exist. Choose Again:\nChoose 909 to exit");
			}
			if (x != 909) {
				allLotCars.put(x, offerCar);
				everything.put("car", allLotCars);
				writeObjectList(everything);
			}
		}
	}

	private static void makePayment(Scanner sc, int x) {//loop throough and select car by owner 
		userInput.divider("Make Payment");
		float amount = 0; int card = 0 ;
		while(true) {
			System.out.println("Enter Payment Card Number Below:");
			card=sc.nextInt();
			System.out.println("Enter Amount Blow:");
			amount = sc.nextFloat();
			System.out.println("Select 0 to Finish:");
			if(sc.nextInt()==0) {
				break;
			}
			
		}
	}	

	private static void addCar(Scanner sc) {
		String brand = "", make = "";
		int year = 0, price = 0, scrap = 0;
		while (scrap != 3) {
			System.out.println("Enter Brand Below:");
			brand = sc.next();
			System.out.println("Enter Make Below:");
			make = sc.next();
			System.out.println("Enter Year Below:");
			year = sc.nextInt();
			System.out.println("Enter Price Below:");
			price = sc.nextInt();
			System.out.println("Press:\t 1 to Submit\t 3 to Exit\t 2 to StartOver");
			scrap = sc.nextInt();
		}
		Car car = new Car(brand, make, year, price);
		car.setCarId(carId());
		obSerialer("car", car);
	}

}
