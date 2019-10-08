package com.project0.Cars;


public class Car  {
	
	private int carId;
	private String brand;
	private String make;
	private int price;
	private int year;
	private String owner;

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
		this.setPrice(price);
		this.brand = brand;
		this.make = make;
		this.year = year;
		this.owner="RevDealers";
	}

	@Override
	public String toString() {
		return "\n\t\t\tCar [\n\t\t\t\t carId\t\t" + carId + "\n\t\t\t\t brand\t\t" + brand + "\n\t\t\t\t make\t\t" +
				make + "\n\t\t\t\t year\t\t" + year + "\n\t\t\t\t owner\t\t" + owner+ "\n\t\t\t\t price\t\t" + price
				+ "\n\t\t\t\t]\n";		
		
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

		
	
}
