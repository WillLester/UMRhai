package edu.nju.umr.data.utilityData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import sun.misc.BASE64Encoder;
import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.DriverPO;
import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.ShelfPO;
import edu.nju.umr.po.UserPO;
import edu.nju.umr.po.VanPO;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.enums.Gender;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Organization;
import edu.nju.umr.po.enums.Part;
import edu.nju.umr.po.enums.Pay;
import edu.nju.umr.po.enums.Wage;
import edu.nju.umr.po.order.IncomePO;
import edu.nju.umr.po.order.PaymentPO;

@SuppressWarnings("restriction")
public class ArrayListFactory {
	public static ArrayList<IncomePO> produceIncomeList(ResultSet result){
		ArrayList<IncomePO> incomeList = new ArrayList<IncomePO>();
		try {
			while(result.next()){
				Calendar date = Calendar.getInstance();
				date.setTime(result.getDate(4));
				Calendar time = Calendar.getInstance();
				time.setTime(result.getDate(5));
				ArrayList<String> express = new ArrayList<String>();
				String ori[] = result.getString(5).split(" ");
				for(int i = 0;i < ori.length;i++){
					express.add(ori[i]);
				}
				IncomePO income = new IncomePO(date, result.getString(2), result.getBigDecimal(3), express, result.getString(1), 
						time,result.getString(7),result.getString(8),result.getString(9),result.getString(10));
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
				date.setTime(result.getDate(7));
				Pay pays[] = Pay.values();
				Calendar opTime = Calendar.getInstance();
				opTime.setTime(result.getDate(8));
				PaymentPO payment = new PaymentPO(result.getString(1), date,result.getString(2) , result.getString(3), 
						pays[result.getInt(4)], result.getBigDecimal(5), result.getString(6), opTime,
						result.getString(9),result.getString(10));
				paymentList.add(payment);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return paymentList;
	}
	public static ArrayList<UserPO> produceUserList(ResultSet result){
		Jurisdiction juris[] = Jurisdiction.values();
		ArrayList<UserPO> userList = new ArrayList<UserPO>();
		try {
			while(result.next()){
				UserPO user = new UserPO(result.getString(1), result.getString(2), juris[result.getInt(5)], result.getString(3), result.getString(4), result.getString(8),result.getInt(6),result.getString(7));
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return null;
		}
		return userList;
	}
	public static ArrayList<GoodPO> produceGoodList(ResultSet result){
		ArrayList<GoodPO> goodList = new ArrayList<GoodPO>();
		Part parts[] = Part.values();
		try {
			while(result.next()){
				Calendar date = Calendar.getInstance();
				date.setTime(result.getDate(8));
				GoodPO good = new GoodPO(result.getString(1), result.getString(2), date, result.getString(3), parts[result.getInt(4)], result.getString(5), result.getInt(6), result.getInt(7));
				goodList.add(good);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return null;
		}
		return goodList;
	}
	public static ArrayList<WorkPO> produceWorkList(ResultSet result){
		Jurisdiction juris[] = Jurisdiction.values();
		Wage wages[] = Wage.values();
		ArrayList<WorkPO> workList = new ArrayList<WorkPO>();
		try {
			while(result.next()){
				WorkPO work = new WorkPO(result.getString(3), result.getString(4),result.getString(8) , result.getString(7),result.getInt(6), juris[result.getInt(5)], wages[result.getInt(9)], result.getInt(10), result.getInt(11));
				workList.add(work);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return null;
		}
		return workList;
	}
	public static ArrayList<VanPO> produceVanList(ResultSet result){
		ArrayList<VanPO> vanList = new ArrayList<VanPO>();
		try {
			while(result.next()){
				String path = result.getString(4);
				InputStream in = new FileInputStream(path);  
				byte[] data = new byte[in.available()];
				try {
					in.read(data);
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					in.close();
					e.printStackTrace();
					return null;
				}  
				in.close();
				BASE64Encoder encoder = new BASE64Encoder();  
				String photo =encoder.encode(data);
				Calendar date = Calendar.getInstance();
				date.setTime(result.getDate(3));
				VanPO van = new VanPO(result.getString(1), result.getString(2), date, photo,result.getString(5));
				vanList.add(van);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		} catch (FileNotFoundException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
		return vanList;
	}
	public static ArrayList<DriverPO> produceDriverList(ResultSet result){
		ArrayList<DriverPO> driverList = new ArrayList<DriverPO>();
		try {
			while(result.next()){
				Calendar birthday = Calendar.getInstance();
				Calendar driveStart = Calendar.getInstance();
				Calendar driveEnd = Calendar.getInstance();
				birthday.setTime(result.getDate(6));
				driveStart.setTime(result.getDate(7));
				driveEnd.setTime(result.getDate(8));
				Gender genders[] = Gender.values();
				DriverPO driver = new DriverPO(result.getString(1), result.getString(2), birthday, result.getString(3), result.getString(4), genders[result.getInt(5)], driveStart, driveEnd,result.getString(9));
				driverList.add(driver);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return null;
		}
		return driverList;
	}
	public static ArrayList<OrgPO> produceOrgList(ResultSet result){
		Organization orgs[] = Organization.values();
		ArrayList<OrgPO> orgList = new ArrayList<OrgPO>();
		try {
			while(result.next()){
				OrgPO org = new OrgPO(result.getString(1), result.getString(2), orgs[result.getInt(3)], result.getString(4),result.getString(5),result.getString(6) );
				orgList.add(org);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
		return orgList;
	}
	
	public static ArrayList<ShelfPO> produceShelfList(ResultSet result){
		ArrayList<ShelfPO> shelfList = new ArrayList<ShelfPO>();
		Part parts[] = Part.values();
		try {
			while(result.next()){
				ShelfPO shelf = new ShelfPO(result.getString(1), result.getString(2), result.getInt(3), result.getInt(4), parts[result.getInt(5)]);
				shelfList.add(shelf);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return null;
		}
		return shelfList;
	}
	
	public static ArrayList<AccountPO> produceAccountList(ResultSet result){
		ArrayList<AccountPO> accountList = new ArrayList<AccountPO>();
		try {
			while(result.next()){
				AccountPO account = new AccountPO(result.getInt(1), result.getString(2), result.getBigDecimal(3));
				accountList.add(account);
			}
			return accountList;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return null;
		}
	}
}
