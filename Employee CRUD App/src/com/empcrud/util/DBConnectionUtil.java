package com.empcrud.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
	
	// declare database connection
	public static Connection DBConnection;
	
	// get connection by using this method
	public static Connection getDBConnection() {
		if(DBConnection == null) {
			try {
			// step 1: load the driver class
			Class.forName("com.mysql.jdbc.Driver");
			
			// step 2: get the connection
			DBConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeecrud","root","root");
			
			// step 3: display connection for testing purpose
			//System.out.println(DBConnection);
			
			// step 4 : return the dbconnection
			return DBConnection;
			
			}
			catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		// return dbconnection
		return DBConnection;
	}
}
