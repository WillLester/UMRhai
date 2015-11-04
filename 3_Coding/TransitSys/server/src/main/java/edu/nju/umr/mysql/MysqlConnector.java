package edu.nju.umr.mysql;

import java.sql.*;

public class MysqlConnector {
	private String url = "jdbc:mysql://localhost:8040/transitSys";
	Connection conn;
	public static void main(String[] args){
		try{
			Connection con=null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/transitSys","root","");
			System.out.print("Connected!\n");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
//	public static void main(String[] args) {
//		MysqlConnector con = new MysqlConnector();
//	}
	public MysqlConnector() {
		// TODO 自动生成的构造函数存根
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url,"root","");
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
}
