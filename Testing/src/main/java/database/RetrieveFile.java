package database;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RetrieveFile {

	public static void main(String[] args) throws Exception {
		Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/databasetesting", "root","root");  
		PreparedStatement ps=con.prepareStatement("select * from filetable1");  
		ResultSet rs=ps.executeQuery();  
		rs.next();//now on 1st row  
		              
		Clob c=rs.getClob(2);  
		Reader r=c.getCharacterStream();              
		              
		FileWriter fw=new FileWriter("D:\\jdbcpr\\db.txt");  
		              
		int i;  
		while((i=r.read())!=-1)  
		fw.write((char)i);  
		              
		fw.close();  
		con.close();  
		              
		System.out.println("success");
	}

}
