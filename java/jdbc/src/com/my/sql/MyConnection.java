package com.my.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnection {
	static {
		//1. JDBC드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";//localhost대신 ip값도 가능//jdbc프로토콜 드라이버 타입은 java로만 구성된 thin드라이버를 사용한다.
		String user = "hr";
		String password = "hr";
		con = DriverManager.getConnection(url, user, password);
		System.out.println("DB와 연결 성공");
		return con;
	}
	
	public static void close(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Statement stmt) {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//오버로딩
	public static void close(ResultSet rs, Statement stmt, Connection con) {
		close(rs);
		close(stmt);
		close(con);
	}
	
	//오버로딩
	public static void close(Statement stmt, Connection con) {
		close(stmt);
		close(con);
	}
}
