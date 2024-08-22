package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetInterface {

	public static void main(String[] args) throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root","root");

		//create statement
		Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=stmt.executeQuery("select * from employees");  
		  
		//getting the record of 3rd row  
		System.out.println(rs.absolute(1));  
		System.out.println(rs.first());
		System.out.println(rs.next());
		System.out.println(rs.previous());
		System.out.println(rs.findColumn("email"));
		System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));  
		  
		con.close();  
	}

}
