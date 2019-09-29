package com.project0.menus;

import java.util.HashMap;
import java.util.Scanner;
import com.project0.Cars.Car;
import com.project0.logicalControllers.UserInput;
import com.project0.serialClass.ObjSerializer;
import com.project0.users.Customer;
import com.project0.users.Employee;

public class Menus extends ObjSerializer {
//	viewCars("RevDealers"); use to view all cars in the lot
	private static HashMap<String, Object> everything = readObjectList();
	@SuppressWarnings("unchecked")
	private static HashMap<Integer, Car> allLotCars = (HashMap<Integer, Car>) everything.get("car");
	@SuppressWarnings("unchecked")
	private static HashMap<String, Customer> allCustomers= (HashMap<String, Customer>) everything.get("customer");
	@SuppressWarnings("unchecked")
	private static HashMap<String, Employee> allEmployees= (HashMap<String, Employee>) everything.get("employee");
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
		refresher();
		Customer custm = (Customer)allCustomers.get(email);
		userInput.divider(custm.getName());
		String menu = "";
		while(true) {
		System.out.println("Select:\t 1:\t View All Available Cars");
		System.out.println("Select:\t 2:\t View My Cars");
		System.out.println("Select:\t 3:\t Back to Main Menu");
		menu= sc.next();
		if(menu.equals("1")) {
			offerPage(sc,email);
		}
		else if(menu.equals("2")) {
			myCarsMenu(custm,sc);
		}
		else if(menu.equals("3")) {
			break;
		}
		}		
		// view all cars
		//make offer
		//view my cars display with view remaining payment
		//

	}
	private static void offerPage(Scanner sc, String email) {
		viewCars("RevDealers");
		int menu;
		while(true) {
		System.out.println("Select:\t 1:\t Make An Offer");
		System.out.println("Select:\t 2:\t Go Back");
		menu=sc.nextInt();
		if(menu==1) {
			makeOffer(sc,email);
		}else if(menu==2) break;
		}
	}
	
	private static void myCarsMenu(Customer cus,Scanner sc) {
		System.out.println("\n\n\t\tMy Cars");
		viewCars(cus.getEmail());
		int menu;
		while(true) {
			System.out.println("Select 1 to make payment:\nSelect 2 to go back tp previous menu:");
			menu = sc.nextInt();
			if(menu==1) {
				System.out.println("Making Payment");break;
			}else if(menu==2) {
				break;
			}
			
		}
		
	}
	public static void employeeMenu(Scanner sc, String email) {
		everything = readObjectList();
		Employee emply = (Employee)allEmployees.get(email);
		userInput.divider(emply.getName());
		String menu = "";
		while(true) {
		System.out.println("Select:\t 1:\t View All Available Cars");
		System.out.println("Select:\t 2:\t View Car Payments");
		System.out.println("Select:\t 3:\t Add new Car");
//		System.out.println("Select:\t 4:\t Admin tools");//get all employees//customers//make admin//take employee param
		System.out.println("Select:\t 5:\t Back to Main Menu");
		menu= sc.next();
		if(menu.equals("1")) {
			carlotPage(sc);
		}
		else if(menu.equals("2")) {
			paymentsMenu(sc);
		}
		else if(menu.equals("3")) {
			addCar(sc);
		}
//		else if(menu.equals("4")) {
//			
//		}
		else if(menu.equals("5")) {break;}
		}
		
		// View Cars --viewCars
		// View Car Offers
		// view Payment
		// Admin Tools----Get employee from list and make Admin

	}

	private static void carlotPage(Scanner sc) {
		viewCars("RevDealers");
		String menu = "";int y=0;
		while(true) {
		System.out.println("Select car by ID to View Offers");
		System.out.println("Select:\t E:\t for previous Menu");
		menu=sc.next();
		if(menu.toUpperCase().equals("E")) {
			break;
		}else {
			try {
				y=Integer.parseInt(menu);
				acceptDenieOffers(y,sc);
				
			}catch(NumberFormatException e){
				System.out.println("\t\tWRONG INPUT\n\n");
			}
		}
		}
		
	}

	private static void acceptDenieOffers(int y, Scanner sc) {
		refresher();
		Car ocar = (Car) allLotCars.get(y);
		String menu="";
		while(true) {
		System.out.println(ocar.getOffers()+"\n\n");
		System.out.println("Select Email to accept offer:");
		System.out.println("Select E to go back:");
		menu=sc.next();
		if(menu.toUpperCase().equals("E")) {
			break;
		}
		else if(ocar.getOffers().keySet().contains(menu)) {
			System.out.println("Offer by "+menu+" has been Accepted");
			ocar.setOwner(menu);
			allLotCars.put(y, ocar);
			everything.put("car", allLotCars);
			writeObjectList(everything);
			break;
			}else {
				System.out.println("Wrong Input! Try Again");
			}
		}
	}

	private static void paymentsMenu(Scanner sc) {
		viewBoughtCars("filt");
		String filt="filt";
		while (true) {
		System.out.println("\n To Filter: \t Selectn Car by ID \n Select E to exit");		
		filt=sc.next();
		if(filt.toUpperCase().equals("E")) {break;}
		else{
			try {
				int xy=Integer.parseInt(filt);
				viewBoughtCars(xy+"");
				
			}catch(NumberFormatException e) {
				System.out.println("Wrong Input");
			}
		}
		}
	}
	private static void viewBoughtCars(String filt) {
		userInput.divider("===============");
		refresher();
		if(filt == "filt") {
		allLotCars.forEach((key, val) -> {

			if (!((Car) val).getOwner().equals("RevDealers")) {
				System.out.println( key+ "\t" + val +"\t\tPayment \t" + ((Car)val).getPayment());
			}
		});
		}
		else {
			allLotCars.forEach((key, val) -> {
				if(key.equals(Integer.parseInt(filt))) {
				if (!((Car) val).getOwner().equals("RevDealers")) {
					System.out.println( key+ "\t" + val +"\t\tPayment \t" + ((Car)val).getPayment());
				}
			}});
			
		}
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
		refresher();
		int x, amount = 0;
		Car offerCar = null;
		while (true) {
			System.out.println("What is your Car Selection:\nSelect Car by number on the left:");
			x = sc.nextInt();			
			if (allLotCars.keySet().contains(x)) {
				System.out.println("Enter Offer Amount:");
				amount = sc.nextInt();				
				offerCar = allLotCars.get(x);
				offerCar.setOffers(email, amount);	
				System.out.println("\n\nOffer of "+amount+" made.\n");
				allLotCars.put(x, offerCar);
				everything.put("car", allLotCars);
				writeObjectList(everything);
				
				break;
			}
			else {
				System.out.println("The Car Integer Selection does not exist. Choose Again:\nChoose 909 to exit");
			}
			if(x == 909) {
				break;
			}
			
		}
	}

	private static void makePayment(Scanner sc, int x) {//loop through and select car by owner 
		userInput.divider("Make Payment");
		float amount = 0; int card = 0 ;
		while(true) {
			System.out.println("Enter Payment Card Number Below:");
			card=sc.nextInt();
			System.out.println("Enter Amount Below:");
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
			if(scrap==1) {
				break;
			}
		}
		Car car = new Car(brand, make, year, price);
		car.setCarId(carId());
		obSerialer("car", car);
		System.out.println("\n"+car.getBrand()+" has been added");
		
	}
	@SuppressWarnings("unchecked")
	private static void refresher() {
		everything = readObjectList();
		 allLotCars = (HashMap<Integer, Car>) everything.get("car");
		 allCustomers= (HashMap<String, Customer>) everything.get("customer");
		allEmployees= (HashMap<String, Employee>) everything.get("employee");
	}
}
