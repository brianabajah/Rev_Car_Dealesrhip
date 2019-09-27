package com.project0.users;

import java.util.TreeMap;

@SuppressWarnings("serial")
public class Customer extends User  {
	private int customerID;
	
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", PaymentDetails=" + PaymentDetails + ", getName()=" + getName()
				+ ", getEmail()=" + getEmail() + ", getPassWord()=" + getPassWord() + ", getAddress()=" + getAddress()
				+ "]";
	}

	
	
	private TreeMap<String, Integer> PaymentDetails;

	public Customer() {
		super();
	}

	public Customer(String name, String email, String passWord, String address) {
		super(name, email, passWord, address);
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
