package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseMetaDataInterface {

	public static void main(String[] args) throws SQLException {
		// DatabaseMetaData interface provides methods to get meta data of a database such as database product name, database product version, driver name, name of total number of tables, name of total number of views etc.
		
		Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/hr", "root","root");  
				DatabaseMetaData dbmd=con.getMetaData();  
				  
				System.out.println("Driver Name: "+dbmd.getDriverName());  
				System.out.println("Driver Version: "+dbmd.getDriverVersion());  
				System.out.println("UserName: "+dbmd.getUserName());  
				System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
				System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  
				  
				//get table name
//				String table[]={"TABLE"}; 
//				ResultSet rs=dbmd.getTables(null,null,null,table);  
//				  
//				while(rs.next()){  
//				System.out.println(rs.getString(3));  
//				}  
				
				
				//get views
				String table[]={"VIEW"};  
				ResultSet rs=dbmd.getTables(null,null,null,table);  
				  
				while(rs.next()){  
				System.out.println(rs.getString(3));  
				}  
				
				
				
				con.close();  
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
