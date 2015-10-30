package com.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	public static Connection getConnection() throws Exception{
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=utf8",
					"root","1234");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return conn;
	}
	
	public static void close(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		Connection conn = getConnection();
		System.out.println(conn);
	}
 }
