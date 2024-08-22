package database;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StoreFile {

	public static void main(String[] args) throws Exception {
		Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/databasetesting", "root","root");  
				              
				PreparedStatement ps=con.prepareStatement(  
				"insert into filetable1 values(?,?)");  
				              
				File f=new File("D:\\jdbcpr\\db.txt");  
				FileReader fr=new FileReader(f);  
				              
				ps.setInt(1,101);  
				ps.setCharacterStream(2,fr,(int)f.length());  
				int i=ps.executeUpdate();  
				System.out.println(i+" records affected");  
				              
				con.close();  

	}

}
