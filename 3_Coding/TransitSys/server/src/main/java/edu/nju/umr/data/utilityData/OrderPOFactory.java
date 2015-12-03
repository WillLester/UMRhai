package edu.nju.umr.data.utilityData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.po.enums.Express;
import edu.nju.umr.po.enums.GoodState;
import edu.nju.umr.po.enums.Parse;
import edu.nju.umr.po.order.ArrivePO;
import edu.nju.umr.po.order.CenterLoadingPO;
import edu.nju.umr.po.order.ExpressPO;
import edu.nju.umr.po.order.HallLoadingPO;
import edu.nju.umr.po.order.IncomePO;
import edu.nju.umr.po.order.PaymentPO;
import edu.nju.umr.po.order.RecipientPO;
import edu.nju.umr.po.order.SendPO;
import edu.nju.umr.po.order.StockInPO;
import edu.nju.umr.po.order.StockOutPO;
import edu.nju.umr.po.order.TransitPO;

public class OrderPOFactory {
	public static ArrivePO getArrive(ResultSet result){
		try {
			if(result.next()){
				Calendar date = Calendar.getInstance();
				date.setTime(result.getDate(5));
				GoodState[] states = GoodState.values();
				Calendar opTime = Calendar.getInstance();
				opTime.setTime(result.getDate(6));
				return new ArrivePO(result.getString(2), date, result.getString(1), result.getString(3), states[result.getInt(4)], opTime, result.getString(7));
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return null;
		}
	}
	public static CenterLoadingPO getCenterLoad(ResultSet result){
		try {
			if(result.next()){
				Calendar date = Calendar.getInstance();
				date.setTime(result.getDate(6));
				Calendar opTime = Calendar.getInstance();
				opTime.setTime(result.getDate(7));
				String text[] = result.getString(8).split(" ");
				ArrayList<String> express = new ArrayList<String>();
				for(int i = 0;i < text.length;i++){
					express.add(text[i]);
				}
				return new CenterLoadingPO(date, result.getString(1), result.getString(2), result.getString(3), 
						result.getString(4), result.getString(5), express, opTime, result.getString(10), result.getDouble(9));
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return null;
		}
	}
	public static ExpressPO getExpress(ResultSet result){
		try {
			if(result.next()){
				Express expresses[] = Express.values();
				Parse parses[] = Parse.values();
				Calendar arrive = Calendar.getInstance();
				arrive.setTime(result.getDate(18));
				Calendar opTime = Calendar.getInstance();
				opTime.setTime(result.getDate(23));
				Calendar date = Calendar.getInstance();
				date.setTime(result.getDate(31));
				return new ExpressPO(result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7), 
						result.getString(8), result.getString(9), result.getString(10), result.getString(11), result.getInt(12),
						result.getString(13), result.getDouble(14), result.getDouble(15), result.getDouble(16), result.getDouble(25), 
						result.getDouble(17), result.getString(1), arrive, date,expresses[result.getInt(19)], result.getDouble(20), 
						opTime, result.getString(24),parses[result.getInt(26)],result.getString(27),result.getString(28),result.getString(29),result.getString(30));
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return null;
		}
	}
	public static HallLoadingPO getHallLoad(ResultSet result){
		try {
			if(result.next()){
				String text[] = result.getString(8).split(" ");
				ArrayList<String> express = new ArrayList<String>();
				for(int i = 0;i < text.length;i++){
					express.add(text[i]);
				}
				Calendar date = Calendar.getInstance();
				date.setTime(result.getDate(8));
				Calendar opTime = Calendar.getInstance();
				opTime.setTime(result.getDate(9));
				return new HallLoadingPO(result.getString(1), result.getString(2), result.getString(3), result.getString(5), 
						result.getString(4), result.getString(6), result.getString(7), express, date, opTime, result.getString(11), result.getDouble(12));
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return null;
		}
	}
	public static IncomePO getIncome(ResultSet result){
		return null;
	}
	public static PaymentPO getPayment(ResultSet result){
		return null;
	}
	public static RecipientPO getRecipient(ResultSet result){
		return null;
	}
	public static SendPO getSend(ResultSet result){
		return null;
	}
	public static StockInPO getStockIn(ResultSet result){
		return null;
	}
	public static StockOutPO getStockOut(ResultSet result){
		return null;
	}
	public static TransitPO getTransit(ResultSet result){
		return null;
	}
}
