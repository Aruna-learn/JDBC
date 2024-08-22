package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

	public static void main(String[] args) throws Exception {
		//insert, update, delete
		//database validation
				//create connection
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/databasetesting", "root","root");
				
				//create statement
				Statement stmt=con.createStatement();
				
				//create query
				//insert
				//String query="INSERT INTO Employ VALUES(104, 'Arunareddy', 907889)";
				
				//update
				//String query="update employ set EName='Anu' where EID=101";
				
				
				//delete
				String query="delete from employ where EID=101";
				
				//if we use select command it will give the result set
				
				
				//execute statement/query and store in the result set
				stmt.execute(query);
				
				con.close();
				System.out.println("data inserted");

	}

}
