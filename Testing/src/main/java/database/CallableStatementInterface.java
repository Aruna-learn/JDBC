package database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableStatementInterface {

	public static void main(String[] args) throws Exception {
		//CallableStatement interface is used to call the stored procedures and functions.
		Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/databasetesting", "root","root");  
				  
				CallableStatement stmt=con.prepareCall("{call insertR(?,?)}");  //instr is storedprocedure and call it
				stmt.setInt(1,1011);  
				stmt.setString(2,"Amit");  
				stmt.execute();  
				  
				System.out.println("success");  

	}

}

//store procedure
//DELIMITER 

//CREATE PROCEDURE INSERTR(
//    IN id INT, 
//    IN name VARCHAR(50)
//)
//BEGIN
//    INSERT INTO user420 (id, name) VALUES (id, name);
//END //
//
//DELIMITER ; 
