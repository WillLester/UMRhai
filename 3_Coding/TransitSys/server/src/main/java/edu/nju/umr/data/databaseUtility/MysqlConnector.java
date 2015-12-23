package edu.nju.umr.data.databaseUtility;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class MysqlConnector {
	private static final String LOC = "database.txt";
	private String url = "jdbc:mysql://localhost:3306/transitsys";
	private Connection connect;
	private String userName;
	private String password;
	public MysqlConnector() {
		// TODO 自动生成的构造函数存根
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(LOC)));
			url = "jdbc:mysql://"+reader.readLine();
			userName = reader.readLine();
			password = reader.readLine();
			reader.close();
		} catch (FileNotFoundException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connect = DriverManager.getConnection(url,userName,password);
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
	public Connection getConnect() {
		return connect;
	}
}
