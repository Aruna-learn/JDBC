package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementInterface {

	public static void main(String[] args) throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/databasetesting", "root","root");
		
		//create statement
		Statement stmt=con.createStatement();
		
		int result=stmt.executeUpdate("INSERT INTO Employ VALUES(103, 'Arundy', 97889)");  
		System.out.println(result+" records affected");  
		con.close();  
		

		//method
		//Resultset executequery, execute update(insert, update, delete). execute batch and boolean execute

	}

}
