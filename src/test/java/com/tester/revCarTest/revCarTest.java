package com.tester.revCarTest;


import com.project0.Cars.Car;
import com.project0.users.Employee;
import com.project0.users.Customer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class revCarTest {
	Car car;
	Employee employ;
	Customer customer;

//	obSerialer("car",car);
//	obSerialer("car",car2);
//	obSerialer("car",car3);
	
	@Test
	public void testObjectCreation() {
		car =new Car("Testbrand","Testmake",1111, 1111);
		employ= new Employee("Testname ", "test@email.com", "testpassword", "TestCity TestState");
		customer =  new  Customer("Testname", "test@email.com", "testpassword", "TestCity TestState");
		String[] carasserts= {car.getBrand(),car.getMake(),car.getOwner(),""+car.getPrice(),""+car.getYear()};
		String[] carValues = {"Testbrand", "Testmake","RevDealers","1111","1111"};
		for(int x=0;x<carasserts.length;x++) {
			assertEquals(carValues[x],carasserts[x]);
		}
//		assertEquals(carValues[x],car.getOffers());
	}
	@Test
	public void createAccount() {
		
	}
	
	
	@Test
	public void loginTest() {
		
	}
}
