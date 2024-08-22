package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessing {

	public static void main(String[] args) throws Throwable {
		// Instead of executing a single query, we can execute a batch (group) of queries. It makes the performance fast. It is because when one sends multiple statements of SQL at once to the database, the communication overhead is reduced significantly, as one is not communicating with the database frequently, which in turn results to fast performance.
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/databasetesting", "root","root");

		con.setAutoCommit(false);  

		//create statement
		Statement stmt=con.createStatement();
		stmt.addBatch("insert into user420 values(192,'abhimanya')");  
		stmt.addBatch("insert into user420 values(197,'umeshwar')");  

		
		//stmt.executeBatch();//executing the batch  
		stmt.clearBatch();
		con.commit();  
		con.close();  
		

	}

}
