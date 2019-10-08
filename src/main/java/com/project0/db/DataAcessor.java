package com.project0.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.TreeMap;

import com.project0.Cars.Car;
import com.project0.users.Customer;
import com.project0.users.Employee;
import com.project0.users.User;

public class DataAcessor {
	
	public HashMap<String, Customer> readCustomers(String email) {
		try {
			Connector conects = new Connector();
			boolean justOne = (email != "");
			Connection con = conects.connection();
			String sql = "select * from customer ";
			if (justOne) {
				sql = "select * from customer where email= ? ";
			}
			PreparedStatement ps = con.prepareStatement(sql);
			if (justOne) {
				ps.setString(1, email);
			}
			ResultSet rs = ps.executeQuery();
			HashMap<String, Customer> cus = new HashMap<>();
			while (rs.next()) {
				cus.put(rs.getString(3),
						new Customer(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
				cus.get(rs.getString(3)).setCustomerID(rs.getInt(1));
			}
			ps.close();
			con.close();

			return cus;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public HashMap<String, Employee> readEmployee(String email) {
		try {
			Connector conects = new Connector();
			boolean justOne = (email != "");
			Connection con = conects.connection();
			String sql = "select * from employees ";
			if (justOne) {
				sql = "select * from employees where email= ? ";
			}
			PreparedStatement ps = con.prepareStatement(sql);
			if (justOne) {
				ps.setString(1, email);
			}
			ResultSet rs = ps.executeQuery();
			HashMap<String, Employee> cus = new HashMap<>();
			while (rs.next()) {
				cus.put(rs.getString(3),
						new Employee(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
				cus.get(rs.getString(3)).setEmployeeId(rs.getInt(1));
			}
			ps.close();
			con.close();

			return cus;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public int writeUsers(User u) {
		Connector conects = new Connector();
		String sql="";
		if(u instanceof Employee) {
			sql="insert into employees(\"name\",email,password,address) values(?,?,?,?)";
		}else if (u instanceof Customer) {
			sql="insert into customer(\"name\",email,password,address) values(?,?,?,?)";
		}
		Connection con = conects.connection();
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassWord());
			ps.setString(4, u.getAddress());
			int x=ps.executeUpdate();
			ps.close();
			con.close();
			return x;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		
		
	}
	
	
	public HashMap<Integer, Car> readCar(String owner) {
		try {
			Connector conects = new Connector();
			boolean justOne = (owner != "");
			Connection con = conects.connection();
			String sql = "select * from cars ";
			if (justOne) {
				sql = "select * from cars where \"carOwner\"= ? ";
			}
			PreparedStatement ps = con.prepareStatement(sql);
			if (justOne) {
				ps.setString(1, owner);
			}
			ResultSet rs = ps.executeQuery();
			HashMap<Integer, Car> cus = new HashMap<>();
			while (rs.next()) {
				cus.put(rs.getInt(1),
						new Car(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
				cus.get(rs.getInt(1)).setOwner(rs.getString(6));
			}
			ps.close();
			con.close();

			return cus;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public int writeCars(Car car) {
		Connector connect= new Connector();
		Connection con= connect.connection();
		String sql="insert into cars(brand,make,year,price) values(?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, car.getBrand());
			ps.setString(2, car.getMake());
			ps.setInt(3, car.getYear());
			ps.setInt(4, car.getPrice());
			int x=ps.executeUpdate();
			ps.close();
			con.close();
			return x;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}		
	}

	public int addOffers(int carId, int userid, int offeramount) {
		Connector conects = new Connector();
		Connection con = conects.connection();
		String sql= "insert into offers(userid,carid,amount) values(?,?,?)";
		try {
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setInt(2, carId);
			ps.setInt(3, offeramount);
			int x=ps.executeUpdate();
			ps.close();
			con.close();
			return x;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}		
		
	}
	
	public TreeMap<String, Integer[]> getOffers(int carid){   //email  amount
		Connector conect= new Connector();
		Connection con= conect.connection();
		String sql ="select * from (select email, carid,amount, boughtby from \"customer\"a,\"offers\"b where a.customerId=b.userid) as billynare where carid=? and \"boughtby\" is null ;";
		try {
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setInt(1, carid);
			ResultSet rs = ps.executeQuery();
			TreeMap<String, Integer[]> out = new TreeMap<>();
			while(rs.next()) {
				out.put(rs.getString(1), new Integer[] {rs.getInt(2),rs.getInt(3)}); 
			}
			return out;
			
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}				
	}
	
	public int setOwnerInOffers(int carId ,String email) {
		Connector connect= new Connector();
		Connection con= connect.connection();
		String sql="update cars set carowner='?' where carid=? and carowner='Revdealers';"
				+ "update offers set boughtby='?' where carid=? and boughtby is null;";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setInt(2, carId);
			ps.setString(3, email);
			ps.setInt(4, carId);
			
			int x=ps.executeUpdate();
			ps.close();
			con.close();
			return x;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}	
		
	}
}