package edu.nju.umr.data.orderNewData;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderCounter {
	public static int count(ResultSet result){
		int count = 0;
		try {
			while(result.next()){
				count++;
			}
			return count;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return -1;
		}
	}
}
