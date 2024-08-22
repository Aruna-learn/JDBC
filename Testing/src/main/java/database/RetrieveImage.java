package database;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrieveImage {

	public static void main(String[] args) throws SQLException, IOException {
		Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/databasetesting", "root","root");  
				      
				PreparedStatement ps=con.prepareStatement("select * from imgtable");  
				ResultSet rs=ps.executeQuery();  
				if(rs.next()){//now on 1st row  
				              
				Blob b=rs.getBlob(2);//2 means 2nd column data  
				byte barr[]=b.getBytes(1,(int)b.length());//1 means first image  
				              
				FileOutputStream fout=new FileOutputStream("D:\\jdbcpr\\sh.jpg");  
				fout.write(barr);  
				              
				fout.close();  
				}//end of if  
				System.out.println("ok");  
				              
				con.close();  

	}

}
