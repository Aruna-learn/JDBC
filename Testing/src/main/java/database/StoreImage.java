package database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StoreImage {

	public static void main(String[] args) throws SQLException, IOException {
		// he setBinaryStream() method of PreparedStatement is used to set Binary information into the parameterIndex.

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/databasetesting", "root","root");

		PreparedStatement ps=con.prepareStatement("insert into imgtable values(?,?)");
		
		ps.setString(1,"sonoo");  
		  
		FileInputStream fin=new FileInputStream("D:\\jdbcpr\\sh.jpg");  
		ps.setBinaryStream(2,fin,fin.available());  
		int i=ps.executeUpdate();  
		System.out.println(i+" records affected");  
		          
		con.close();  
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
