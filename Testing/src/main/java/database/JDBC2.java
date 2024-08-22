package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC2 {

	public static void main(String[] args) throws Exception {
		//insert, update, delete
		//database validation
				//create connection
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root","root");
				
				//create statement
				Statement stmt=con.createStatement();
				
				
				
				//create query
				String query="Select employee_id, first_name,last_name,email from Employees";
				
				//execute statement/query and store in the result set if we use select command it will give the result set
				ResultSet rs=stmt.executeQuery(query);
				
				while(rs.next()) {
					int eid=rs.getInt("employee_id");
					String fname=rs.getString("first_name");
					String lname=rs.getString("last_name");
					String email=rs.getString("email");
				
				System.out.println(eid+"   "+fname+"   "+lname+"   "+email);
				}
				
				
				
				
				
				
				
				
				
				con.close();
				System.out.println("data fetched");

	}

}
