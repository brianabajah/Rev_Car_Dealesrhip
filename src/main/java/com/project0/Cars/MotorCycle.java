package com.project0.Cars;

import java.util.ArrayList;

public class MotorCycle extends Vehicle {
	private boolean dual_Channel_ABS;
//	Dual Channel basically means that each wheel is controlled indepently.
//	So the ABS system kicks in and reduces the brake pressure for the rear wheel as soon
//	as the rear wheel is going to lock up - although the front wheel may still be way off locking up.
	
	public MotorCycle() {
		super();
	}

	public MotorCycle(String brand, String vehicletype, String make, int year, boolean isKeyless, int vin, boolean dual_Channel_ABS ,
			ArrayList<String> extraFeatures) {
		super(brand, vehicletype, make, year, isKeyless, vin, extraFeatures);
		// TODO Auto-generated constructor stub
		this.dual_Channel_ABS=dual_Channel_ABS;
	}
	public void setdual_Channel_ABS( boolean dual_Channel_ABS) {
		this.dual_Channel_ABS=dual_Channel_ABS;
	}
	public boolean isdual_Channel_ABS() {
		return(dual_Channel_ABS);
	}
	
}
