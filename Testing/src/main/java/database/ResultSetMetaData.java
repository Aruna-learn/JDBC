package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetMetaData {

	public static void main(String[] args) throws Exception {
		// If you have to get metadata of a table like total number of column, column name, column type etc. , ResultSetMetaData interface is useful because it provides methods to get metadata from the ResultSet object.
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root","root");

		PreparedStatement ps=con.prepareStatement("select* from employees");
		
		ResultSet rs=ps.executeQuery();
		
		ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();  
		
		System.out.println("Total columns: "+((java.sql.ResultSetMetaData) rsmd).getColumnCount());  
		System.out.println("Column Name of 1st column: "+((java.sql.ResultSetMetaData) rsmd).getColumnName(1));  
		System.out.println("Column Type Name of 1st column: "+((java.sql.ResultSetMetaData) rsmd).getColumnTypeName(1));  
		
		con.close();
		
		
		
	}

}
