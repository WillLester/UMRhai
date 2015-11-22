package edu.nju.umr.data.utilityData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.po.enums.Pay;
import edu.nju.umr.po.order.IncomePO;
import edu.nju.umr.po.order.PaymentPO;

public class ArrayListFactory {
	public static ArrayList<IncomePO> produceIncomeList(ResultSet result){
		ArrayList<IncomePO> incomeList = new ArrayList<IncomePO>();
		try {
			while(result.next()){
				Calendar date = Calendar.getInstance();
				date.setTime(result.getDate(3));
				Calendar time = Calendar.getInstance();
				time.setTime(result.getDate(4));
				ArrayList<String> express = new ArrayList<String>();
				String ori[] = result.getString(5).split(" ");
				for(int i = 0;i < ori.length;i++){
					express.add(ori[i]);
				}
				IncomePO income = new IncomePO(date, result.getString(1), result.getDouble(2), express, result.getInt(0), time,result.getString(6),result.getString(7));
				incomeList.add(income);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return null;
		}
		return incomeList;
	}
	public static ArrayList<PaymentPO> producePaymentList(ResultSet result){
		ArrayList<PaymentPO> paymentList = new ArrayList<PaymentPO>();
		try {
			while(result.next()){
				Calendar date = Calendar.getInstance();
				date.setTime(result.getDate(6));
				Pay pays[] = Pay.values();
				Calendar opTime = Calendar.getInstance();
				opTime.setTime(result.getDate(7));
				PaymentPO payment = new PaymentPO(result.getInt(0), date,result.getString(1) , result.getString(2), pays[result.getInt(3)], result.getDouble(4), result.getString(5), opTime,result.getString(8));
				paymentList.add(payment);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return paymentList;
	}
}
