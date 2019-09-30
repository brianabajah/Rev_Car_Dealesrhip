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
	private static HashMap<Integer, Car> allCars;
	private static File f = new File(locale);

//	private static HashMap<String,Object> allData= new HashMap<>();

	
	
//	public static void main(String[] args) {
//		Car car =new Car("Toyota","M2",2015, 16000);
//		Car car2 =new Car("Jeep","Hipstar",2020, 20000);
//		Car car3 =new Car("Mini","Cooper",1987, 7000);
//		obSerialer("car",car);
//		obSerialer("car",car2);
//		obSerialer("car",car3);
//		Employee employ= new Employee("Brian", "br@gm.c", "b", "tampa fl");
//		Employee employ2= new Employee("Bae", "vest@gm.c", "k", "tampa fl");
//		obSerialer("employee",employ);
//		obSerialer("employee",employ2);
//		Customer cus= new Customer("Brenda", "b@gm.c", "b", "tampa fl");
//		Customer cus2= new Customer("Brick", "vest@gm.c", "k", "tampa fl");
//		obSerialer("customer",cus);
//		obSerialer("customer",cus2);
////		allEmployees = (HashMap<String, Employee>) readObjectList().get("employee");
////		
//////		System.out.println(readObjectList().get("customer"));
//		readObjectList().forEach((key,val)->System.out.println("\n"+key+"\t" + val.toString().replace(",", "\t\t") +"\n"));
//////		String s = ((Customer)((HashMap<String, Customer>)readObjectList().get("customer")).get("j@g.c")).getPassWord();
//////		System.out.println(s);
//////		System.out.println(correctPass("customer", "j@g.c", "1234"));
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
					cus.setCustomerID(customerId());
					allCustomers.put(cus.getEmail(), cus);
					allData.put("customer", allCustomers);
				}
			}
			else if (dataType == "car") {
				Car car = (Car) hash;
				allCars = (HashMap<Integer, Car>)allData.get("cars");
				if(allCars!=null) {
					if (allCars.containsKey(car.getCarId())) {
						System.out.println("The vehicle of Id: " + car.getCarId() + " already Exists!");
					} else {
						car.setCarId(carId());
						allCars.put(car.getCarId(), car);
						allData.put("car", allCars);
					}
				}else {
					car.setCarId(carId());
					allCars.put(car.getCarId(), car);
					allData.put("car", allCars);
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
	protected static HashMap<String, Object> readObjectList() {

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

	protected static void writeObjectList(HashMap<String, Object> o) {

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
			Employee spEm=new Employee("Super User", "s@r.c", "0", "main");//create and set superUser
			allEmployees= new HashMap<String, Employee>();
			allEmployees.put(spEm.getEmail(), spEm);
			try {
				f.createNewFile();
				allData = new HashMap<String, Object>();
				allData.put("employee", allEmployees);
				allData.put("customer", new HashMap<String, Customer>());
				allData.put("car", new HashMap<Integer, Car>());
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
	private static int customerId() {
		allCustomers = (HashMap<String, Customer>) readObjectList().get("customer");
		return allCustomers.size();
	}
	@SuppressWarnings("unchecked")
	protected static int carId() {
		allCars = (HashMap<Integer, Car>) readObjectList().get("car");
		return allCars.size();
	} 
}
