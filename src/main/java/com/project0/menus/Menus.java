package com.project0.menus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.project0.Cars.Car;
import com.project0.db.DataAcessor;
import com.project0.logicalControllers.UserInput;
import com.project0.users.Customer;
import com.project0.users.Employee;

public class Menus {

	final static Logger logger = Logger.getLogger(Menus.class);

//	private Menus menus = new Menus();
	private DataAcessor dAccesor = new DataAcessor();
	private UserInput userInput = new UserInput();

	public void mainMenu() {
		userInput.divider("===============");
		System.out.println("            Welcome to RevDelers.\n        Revolutionizing The Motor Industry\n");

		System.out.println("-------------------------------------------------------");
		System.out.println("||      1         ||      2         ||       3        ||");
		System.out.println("|| Customer Login || Employee Login || Create Account ||");
		System.out.println("-------------------------------------------------------");
		System.out.println("\n Press 0 to exit app");
	}

	public void customerMenu(Scanner sc, String email) {

		Customer custm = dAccesor.readCustomers(email).get(email);
		userInput.divider(custm.getName());
		String menu = "";
		while (true) {
			System.out.println("Select:\t 1:\t View All Available Cars");
			System.out.println("Select:\t 2:\t View My Cars");
			System.out.println("Select:\t 3:\t View My Pending Offers");
			System.out.println("Select:\t 4:\t Back to Main Menu");
			menu = sc.next();
			if (menu.equals("1")) {
				offerPage(sc, email);
			} else if (menu.equals("2")) {
				myCarsMenu(custm, sc);
			
			} else if (menu.equals("3")) {
				userInput.divider("=Pending Offers=");
				System.out.println("\n\n");
				TreeMap<String, Integer[]> offers = dAccesor.getOffers(0,custm.getCustomerID());
				System.out.println("\n\n\n");
				offers.forEach((a, b) -> {
					System.out.print("Email : " + a + "\t\t\t");
					System.out.println("CarId : " + b[0] + "\t\tAmount :" + b[1] +"\n\n\n");
				});
				System.out.println("\n\n");
				userInput.divider("===============");
			
			} else if (menu.equals("4")) {
				logger.info(email + "Logged Out");
				break;
			}
		}

	}

	private void offerPage(Scanner sc, String email) {

		viewCars("Revdealers");
		int menu;
		while (true) {
			System.out.println("Select:\t 1:\t Make An Offer");
			System.out.println("Select:\t 2:\t Go Back");
			menu = sc.nextInt();
			if (menu == 1) {
				makeOffer(sc, email);
			} else if (menu == 2)
				break;
		}

	}

	private void myCarsMenu(Customer cus, Scanner sc) {

		System.out.println("\n\n\t\tMy Cars");
		ArrayList<String> mycars = viewCars(cus.getEmail());
		int menu;
		while (true) {
			System.out.println("Select 1 to make payment:\nSelect 2 to go back tp previous menu:");
			menu = sc.nextInt();
			if (menu == 1) {
				makePayment(sc, mycars, cus.getCustomerID());
				System.out.println("Making Payment");
				break;
			} else if (menu == 2) {
				break;
			}

		}

	}

	public void employeeMenu(Scanner sc, String email) {

		Employee emply = dAccesor.readEmployee(email).get(email);
		userInput.divider(emply.getName());
		String menu = "";
		while (true) {
			System.out.println("Select:\t 1:\t View All Available Cars");
			System.out.println("Select:\t 2:\t View Car Payments");
			System.out.println("Select:\t 3:\t Add new Car");
			System.out.println("Select:\t 4:\t Remove Car from lot");
			System.out.println("Select:\t 5:\t Back to Main Menu");
			menu = sc.next();
			if (menu.equals("1")) {
				carlotPage(sc);
			} else if (menu.equals("2")) {
				paymentsMenu(sc);
			} else if (menu.equals("3")) {
				addCar(sc);
			} else if (menu.equals("4")) {
				removeCar(sc);
			} else if (menu.equals("5")) {
				break;
			}
		}

	}

	private void removeCar(Scanner sc) {
		userInput.divider("===============");
		HashMap<Integer,Car> lotCars= dAccesor.readCar("Revdealers");		
		hushprint(lotCars);
		while(true) {
		System.out.println("Select Car by Id To delete");
		System.out.println("Select:\t E:\t for previous Menu");
		int carId;
		String x=sc.next();
		if (x.toUpperCase().equals("E")) {
			break;
		}else {
		try {
			carId = Integer.parseInt(x);
			dAccesor.deleteCars(carId);			

		} catch (NumberFormatException e) {
			System.out.println("\t\tWRONG INPUT\n\n");
			logger.error(e);
		}
		
		}}
	}

	private void carlotPage(Scanner sc) {
		ArrayList<String> indexes=viewCars("Revdealers");
		String menu = "";
		int y = 0;
		while (true) {
			System.out.println("Select car by ID to View Offers");
			System.out.println("Select:\t E:\t for previous Menu");
			menu = sc.next();
			if (menu.toUpperCase().equals("E")) {
				break;
			} else {
				try {
					if(indexes.contains(menu)) {
					y = Integer.parseInt(menu);
					acceptDenieOffers(y, sc);
					}else {
						System.out.println("choose among the followig keys: "+indexes.toString());
					}

				} catch (NumberFormatException e) {
					System.out.println("\t\tWRONG INPUT\n\n");
					logger.error(e);
				}
			}
		}

	}

	private void acceptDenieOffers(int y, Scanner sc) {
		TreeMap<String, Integer[]> offers = dAccesor.getOffers(y,0);
		System.out.println("\n\n\n");
		offers.forEach((a, b) -> {
			System.out.print("Email : " + a + "\t\t\t");
			System.out.println("CarId : " + b[0] + "\t\tAmount :" + b[1] +"\n\n\n");
		});
		String menu = "";
		while (true) {
			System.out.println("Type Email to accept offer:");
			System.out.println("Select E to go back:");
			menu = sc.next();
			if (menu.toUpperCase().equals("E")) {
				break;
			} else if (offers.keySet().contains(menu)) {
				dAccesor.setOwnerInOffers(y, menu);
				System.out.println("Offer by " + menu + " has been Accepted");
				break;
			} else {
				System.out.println("Wrong Input! Try Again");
			}
		}
	}

	private void paymentsMenu(Scanner sc) {

		viewBoughtCars("filt");
		String filt = "filt";
		while (true) {
			System.out.println("\n To Filter: \t Selectn Car by ID \n Select E to exit");
			filt = sc.next();
			if (filt.toUpperCase().equals("E")) {
				break;
			} else {
				try {
					int xy = Integer.parseInt(filt);
					viewBoughtCars(xy + "");

				} catch (NumberFormatException e) {
					System.out.println("Wrong Input");
					logger.error(e);
				}
			}
		}
	}

	private void viewBoughtCars(String filt) {
		userInput.divider("===============");
		
		HashMap<Integer, Car> allLotCars=dAccesor.readCar("");
		if (filt == "filt") {
			allLotCars.forEach((key, val) -> {
				TreeMap<String ,Integer> getpays= dAccesor.getpayments(val.getOwner(), key);
				if (!((Car) val).getOwner().equals("Revdealers")) {
					System.out.println(key + "\t" + val + "\n\tPayment \t" + getpays);
				}
			});
		} else {
			allLotCars.forEach((key, val) -> {
				if (key.equals(Integer.parseInt(filt))) {
				TreeMap<String ,Integer>  getpays= dAccesor.getpayments(val.getOwner(), key);
				getpays.forEach((k,v)->{
					System.out.println("\t\t"+ k+"\t\t\t"+ v);
				});
				}
			});

		}
	}

	public ArrayList<String> viewCars(String who) {

		ArrayList<String> out = new ArrayList<>();
		userInput.divider("===============");
		dAccesor.readCar(who).forEach((key, val) -> {
			out.add(key.toString());
			System.out.println("Select\t" + key + "\t to choose:\t\t" + val);
			System.out.println("\n\n Total Car Offers: "+dAccesor.getTotalOffersPerCar(key)+"\n");
		});
		userInput.divider("===============");
		return out;
	}

	protected void makeOffer(Scanner sc, String email) {

		int x, amount = 0;
		while (true) {
			System.out.println("What is your Car Selection:\nSelect Car by number on the left:");
			x = sc.nextInt();
			if (dAccesor.readCar("Revdealers").keySet().contains(x)) {
				System.out.println("Enter Offer Amount:");
				amount = sc.nextInt();
				dAccesor.addOffers(x, dAccesor.readCustomers(email).get(email).getCustomerID(), amount);
				System.out.println("\n\nOffer of " + amount + " made.\n");
				break;
			} else {
				System.out.println("The Car Integer Selection does not exist. Choose Again:\nChoose 909 to exit");
			}
			if (x == 909) {
				break;
			}

		}

	}

	private void makePayment(Scanner sc, ArrayList<String> mycars, int cusId) {

		userInput.divider("Make Payment");
		System.out.println("Select Car By CAR_ID to make payment");
		String car = "";
		while (!mycars.contains(car = sc.next())) {
			System.out.println("Select Between " + mycars.toString());
		}
		int amount = 0;
		int exiter = 100;
		while (true) {
			try {
				System.out.println("Enter Amount Below:");
				amount = sc.nextInt();
				System.out.println(" Select 0 to Clear and EXIT:\n Select 1 to Submit and EXIT");
				exiter = sc.nextInt();
				if (exiter == 0 || exiter == 1) {
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Please Type Numbers Only");
			}
		}
		if (exiter == 1) {
			LocalDate localDate = LocalDate.now();
			String timedate = DateTimeFormatter.ofPattern("MM/dd/yyyy").format(localDate);
			int carid =Integer.parseInt(car);
			dAccesor.makePayment(cusId, carid, amount, timedate);
			
			logger.info("Payment of: " + amount + "made for CarId: " + carid + "By customerId: "+cusId);

		}

	}

	private void addCar(Scanner sc) {

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
			if (scrap == 1) {
				break;
			}
		}
		Car car = new Car(brand, make, year, price);
		dAccesor.writeCars(car);
		logger.info(car.getBrand() + " has been added to Database");
		System.out.println("\n" + car.getBrand() + " has been added");

	}

	private <T,M> void hushprint(HashMap<T,M> hsh) {

		hsh.forEach((a, b) -> {
			System.out.println(a+"\t\t\t"+b);
		});

	}
}
