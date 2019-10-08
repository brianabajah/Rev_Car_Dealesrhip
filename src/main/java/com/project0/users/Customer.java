package com.project0.users;

import java.util.TreeMap;

public class Customer extends User  {
	private int customerID;
	
	@Override
	public String toString() {
		return "\n\t\t\tCustomer [\n\t\t\t\t customerID\t\t" + customerID
				+ ",\n\t\t\t\t Name\t\t" + getName()+ "\n\t\t\t\t Email\t\t" + getEmail() + "\n\t\t\t\tAddress\t\t" + getAddress()
				+ "n\t\t\t\t]\n";
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
