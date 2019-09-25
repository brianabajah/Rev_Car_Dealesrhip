package com.project0.Cars;
import java.util.ArrayList;

public class Vehicle {
	private String brand;
	private String vehicletype;
	private String make;
	private int year;
	private boolean isAvailable=false;
	private boolean isKeyless;
	private int vin;
	private ArrayList<String> extraFeatures;
	
	public Vehicle() {}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getVehicletype() {
		return vehicletype;
	}

	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
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

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getVin() {
		return vin;
	}

	public void setVin(int vin) {
		this.vin = vin;
	}

	public ArrayList<String> getExtraFeatures() {
		return extraFeatures;
	}

	public void setExtraFeatures(ArrayList<String> extraFeatures) {
		this.extraFeatures = extraFeatures;
	}

	public boolean isKeyless() {
		return isKeyless;
	}

	public void setKeyless(boolean isKeyless) {
		this.isKeyless = isKeyless;
	}

	public Vehicle(String brand, String vehicletype, String make, int year, boolean isKeyless,
			int vin, ArrayList<String> extraFeatures) {
		super();
		this.brand = brand;
		this.vehicletype = vehicletype;
		this.make = make;
		this.year = year;
		this.isKeyless = isKeyless;
		this.vin = vin;
		this.extraFeatures = extraFeatures;
	}

	@Override
	public String toString() {
		return "Vehicle [brand=" + brand + ", vehicletype=" + vehicletype + ", make=" + make + ", year=" + year
				+ ", isAvailable=" + isAvailable + ", isKeyless=" + isKeyless + ", vin=" + vin + ", extraFeatures="
				+ extraFeatures + "]";
	}
				

}
