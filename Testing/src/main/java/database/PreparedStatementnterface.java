package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementnterface {

	public static void main(String[] args) throws SQLException {
		//As you can see, we are passing parameter (?) for the values. Its value will be set by calling the setter methods of PreparedStatement.

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/databasetesting", "root","root");

		PreparedStatement ps=con.prepareStatement("insert into emp values(?,?)");
		
		ps.setInt(1, 56);
		ps.setString(2, "Aruna");
		
		ps.setInt(2, 23);
		ps.setString(2, "Aru");
		
		ps.setInt(2, 6);
		ps.setString(2, "mona");
		
		int i=ps.executeUpdate();
		System.out.println("updated");
		
		con.close();
		//methods- set int, string, float, double, executeupdate, executequery
		
		
		//update
		/*
		 * PreparedStatement
		 * stmt=con.prepareStatement("update emp set name=? where id=?");
		 * stmt.setString(1,"Sonoo");//1 specifies the first parameter in the query i.e.
		 * name stmt.setInt(2,101);
		 * 
		 * 
		 * //delete PreparedStatement
		 * stmt=con.prepareStatement("delete from emp where id=?"); stmt.setInt(1,101);
		 * 
		 * 
		 * //retrive PreparedStatement stmt=con.prepareStatement("select * from emp");
		 * ResultSet rs=stmt.executeQuery(); while(rs.next()){
		 * System.out.println(rs.getInt(1)+" "+rs.getString(2));
		 */ 
	}

}
