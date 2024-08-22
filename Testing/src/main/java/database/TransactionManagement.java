package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionManagement {

	public static void main(String[] args) throws Exception {
		//acid properties, setautocommit, rollback, commit
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/databasetesting", "root","root");

		con.setAutoCommit(false);  

		//create statement
		Statement stmt=con.createStatement();
		stmt.executeUpdate("insert into user420 values(190,'abhi')");  
		stmt.executeUpdate("insert into user420 values(191,'umesh')");  

		con.commit();  
		con.close();  

	}

}
