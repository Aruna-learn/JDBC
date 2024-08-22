package database;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSetInterface {

	public static void main(String[] args) throws Throwable {
		//An instance of RowSet is the Java bean component because it has properties and Java bean notification mechanism. It is the wrapper of ResultSet. A JDBC RowSet facilitates a mechanism to keep the data in tabular form. It happens to make the data more flexible as well as easier as compared to a ResultSet. The connection between the data source and the RowSet object is maintained throughout its life cycle. The RowSet supports development models that are component-based such as JavaBeans, with the standard set of properties and the mechanism of event notification.
		JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();  
        rowSet.setUrl("jdbc:mysql://localhost:3306/hr");  
        rowSet.setUsername("root");  
        rowSet.setPassword("root");  
                   
        rowSet.setCommand("select * from employees");  
        rowSet.execute();  
                   
    while (rowSet.next()) {  
                        // Generating cursor Moved event  
                        System.out.println("employee_id: " + rowSet.getString(1));  
                        System.out.println("first_name: " + rowSet.getString(2));  
                         
                }  
                 

	}

}
