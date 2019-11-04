package com.ruda.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnector {

	public static Connection getConnection() throws Exception {
		Connection con = null;
		
		 String user = "user14";
		 String password = "user14";
		 String url = "jdbc:oracle:thin:@211.238.142.24:1521:xe";
		 String driver = "oracle.jdbc.driver.OracleDriver";
		 
		 Class.forName(driver);
		 
		con = DriverManager.getConnection(url, user, password);
		
		return con;
		
	}
	
}
