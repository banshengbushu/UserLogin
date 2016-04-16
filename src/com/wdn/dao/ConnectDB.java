package com.wdn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/servlet";
			conn = DriverManager.getConnection(url, "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return conn;
		
	}
	public static void closeConnection(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
