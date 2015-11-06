package edu.nju.umr.mysql;

import java.sql.*;

public class MysqlConnector {
	private String url = "jdbc:mysql://localhost:3306/transitSys";
	private Connection connect;
	public MysqlConnector() {
		// TODO 自动生成的构造函数存根
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection(url,"root","");
			System.out.println("Connected!");
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void close(){
		try {
			connect.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
