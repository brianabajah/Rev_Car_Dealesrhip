package com.project0.serialClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import com.project0.Cars.Car;
import com.project0.users.Customer;
import com.project0.users.Employee;

public class ObjSerializer implements FileLocation {
	private static HashMap<String, Object> allData;
	private static HashMap<String, Employee> allEmployees;
	private static HashMap<String, Customer> allCustomers;
	private static File f = new File(locale);

//	private static HashMap<String,Object> allData= new HashMap<>();

//	public static void main(String[] args) {
////		Employee employ= new Employee("Brian", "test@gm.c", "random", "tampa fl");
////		Employee employ= new Employee("Ken", "vest@gm.c", "random", "tampa fl");
////		obSerialer("employee",employ);
////		allEmployees = (HashMap<String, Employee>) readObjectList().get("employee");
////		
////		System.out.println(readObjectList().get("employee"));
//		
////		System.out.println(correctPass("employee", "test@gm.c", "rrt"));
//	}

	@SuppressWarnings("unchecked")
	public static void obSerialer(String dataType, Object hash) {
		/**
		 * Use to add new Objects to file
		 */

		if (fileCheck(dataType, hash)) {
			allData = readObjectList();
			// writing new data
			if (dataType == "employee") {
				Employee em = (Employee) hash;
				allEmployees = (HashMap<String, Employee>) allData.get("employee");
				// key of allEmmployees is Employee email

				if (allEmployees.containsKey(em.getEmail())) {
					System.out.println("An account under the email " + em.getEmail() + " already Exists!");
				} else {
					allEmployees.put(em.getEmail(), (Employee) hash);
					allData.put("employee", allEmployees);
				}
			} else if (dataType == "customer") {
				Customer cus = (Customer) hash;
				// get hash of cust data
				allCustomers = (HashMap<String, Customer>) allData.get("customer");
				// key of allEmmployees is Employee email
				if (allCustomers.containsKey(cus.getEmail())) {
					System.out.println("An account under the email " + cus.getEmail() + " already Exists!");
				} else {
					Customer inCus = (Customer) hash;
					inCus.setCustomerID(customerId());
					allCustomers.put(cus.getEmail(), inCus);
					allData.put("customer", allCustomers);
				}
			}
			writeObjectList(allData);
		}

	}

	@SuppressWarnings("unchecked")
	public static boolean correctPass(String dataType, String email, String password) {
		/**
		 * Use for Password Authentication
		 */
		boolean outVal = false;
		if (!fileCheck("", null)) {
			outVal = false;
		} else {
			if (dataType == "employee") {
				allEmployees = (HashMap<String, Employee>) readObjectList().get("employee");
				// key of allEmmployees is Employee email
				if (allEmployees.containsKey(email)) {
					Employee emp = allEmployees.get(email);
					if (emp.getPassWord().equals(password)) {
						outVal = true;
					} else
						outVal = false;
				} else {
					outVal = false;
				}
			} else if (dataType == "customer") {
				allCustomers = (HashMap<String, Customer>) readObjectList().get("customer");
				// key of allEmmployees is Employee email
				if (allCustomers.containsKey(email)) {
					Customer emp = allCustomers.get(email);
					if (emp.getPassWord().equals(password)) {
						outVal = true;
					} else
						outVal = false;
				} else {
					outVal = false;
				}
			}

		}
		return outVal;

	}

	@SuppressWarnings("unchecked")
	private static HashMap<String, Object> readObjectList() {

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(locale))) {
			HashMap<String, Object> retData = (HashMap<String, Object>) ois.readObject();
			return retData;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}

	}

	private static void writeObjectList(HashMap<String, Object> o) {

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(locale))) {

			oos.writeObject(o);

		} catch (FileNotFoundException e) {
			// e.printStackTrace();
		} catch (IOException e) {
			// e.printStackTrace();
		}
	}

	private static boolean fileCheck(String dataType, Object hash) {
		boolean out = f.exists();
		if (!out) {// first time app run so that there will always be a file
			try {
				f.createNewFile();
				allData = new HashMap<String, Object>();
				allData.put("employee", new HashMap<String, Employee>());
				allData.put("customer", new HashMap<String, Customer>());
				allData.put("cars", new HashMap<String, Car>());
				writeObjectList(allData);// or EofError
				if (hash != null) {
					obSerialer(dataType, hash);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return (out);
	}
	
	@SuppressWarnings("unchecked")
	public static int customerId() {
		allCustomers = (HashMap<String, Customer>) readObjectList().get("customer");
		return allCustomers.size();
	}
}
