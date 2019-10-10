package com.tester.revCarTest;


import com.project0.Cars.Car;
import com.project0.users.Employee;
import com.project0.users.Customer;
import com.project0.db.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;


import org.junit.Test;

public class revCarTest {
	Car car;
	Employee employ;
	Customer customer;
	HashMap<Integer, Car> retC;
	DataAcessor ds = new DataAcessor();
	
//	@Test
//	public void testDatabase() {
//		
//		employ= new Employee("Testname ", "test@email.com", "testpassword", "TestCity TestState");
//		customer =  new  Customer("Testname", "test@email.com", "testpassword", "TestCity TestState");
//		String[] carasserts= {car.getBrand(),car.getMake(),car.getOwner(),""+car.getPrice(),""+car.getYear()};
//		String[] carValues = {"Testbrand", "Testmake","RevDealers","1111","1111"};
//		for(int x=0;x<carasserts.length;x++) {
//			assertEquals(carValues[x],carasserts[x]);
//		}
////		assertEquals(carValues[x],car.getOffers());
//	}
	@Test
	public void testcreatecar() {
		car =new Car("Testbrand","Testmake",1111, 1111);
		DataAcessor ds = new DataAcessor();
		assertEquals(ds.writeCars(car),1);
	}
	
	@Test
	public void testReadCar() {
		retC=ds.readCar("Revdealers");
		assertTrue(retC.size()>0);
	}
	
	
	@Test
	public void testCreateEmployee() {
		employ= new Employee("Testname ", "test@email.com", "testpassword", "TestCity TestState");
		assertTrue(ds.writeUsers(employ)>=0);
	}
	
	@Test
	public void testCreateCustomer() {
		customer =  new  Customer("Testname", "test@email.com", "testpassword", "TestCity TestState");
		assertTrue(ds.writeUsers(customer)>=0);
	}
}
