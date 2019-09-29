package com.project0.Cars;

import java.io.Serializable;
import java.util.TreeMap;

@SuppressWarnings("serial")
public class Car implements Serializable  {
	
	private int carId;
	private String brand;
	private String make;
	private int price;
	private int year;
	private String owner;
	private TreeMap<String,Integer> offers=new TreeMap<>();
	private TreeMap<String,Float> payment=new TreeMap<>();

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public Car(String brand, String make, int year, int price) {
		super();
		this.price = price;
		this.brand = brand;
		this.make = make;
		this.year = year;
		this.owner="RevDealers";
	}

	public TreeMap<String,Float> getPayment() {
		return payment;
	}

	public void setPayment(TreeMap<String,Float> payment) {
		this.payment = payment;
	}
	
	public TreeMap<String,Integer> getOffers() {
		return offers;
	}

	public void setOffers(String email,int amount) {		
		this.offers.put(email, amount);
	}

	@Override
	public String toString() {
		return "\n\t\t\tCar [\n\t\t\t\t carId\t\t" + carId + "\n\t\t\t\t brand\t\t" + brand + "\n\t\t\t\t make\t\t" +
				make + "\n\t\t\t\t year\t\t" + year + "\n\t\t\t\t owner\t\t" + owner
				+ "\n\t\t\t\tpayment=" + payment + "\n\t\t\t\t]\n";		
		
	}

		
	
}
