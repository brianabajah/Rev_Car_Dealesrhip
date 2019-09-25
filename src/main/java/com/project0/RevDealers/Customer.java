package com.project0.RevDealers;

import java.io.Serializable;
import java.util.TreeMap;

public class Customer extends User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3153249876519607827L;
	private int customerID;
	
	private TreeMap<String, Integer> PaymentDetails;

	public Customer() {
		super();
	}

	public Customer(String name, String email, String passWord, String dateOfBirth, String address, int customerID) {
		super(name, email, passWord, dateOfBirth, address);
		this.setCustomerID(customerID);
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public TreeMap<String, Integer> getPaymentDetails() {
		return PaymentDetails;
	}

	public void setPaymentDetails(TreeMap<String, Integer> paymentDetails) {
		PaymentDetails = paymentDetails;
	}
	 

}
