package edu.nju.umr.data.utilityData;

import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ImageIcon;

import edu.nju.umr.po.DriverPO;
import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.OrgPO;
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
	public static ArrayList<UserPO> produceUserList(ResultSet result){
		Jurisdiction juris[] = Jurisdiction.values();
		ArrayList<UserPO> userList = new ArrayList<UserPO>();
		try {
			while(result.next()){
				UserPO user = new UserPO(result.getString(0), result.getString(1), juris[result.getInt(4)], result.getString(2), result.getString(3), result.getString(7),result.getInt(5),result.getString(6));
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
				date.setTime(result.getDate(7));
				GoodPO good = new GoodPO(result.getString(0), result.getString(1), date, result.getString(2), parts[result.getInt(3)], result.getString(4), result.getInt(5), result.getInt(6));
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
				WorkPO work = new WorkPO(result.getString(2), result.getString(3),result.getString(7) , result.getString(6),result.getInt(5), juris[result.getInt(4)], wages[result.getInt(8)], result.getInt(9), result.getInt(10));
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
				ImageIcon icon = new ImageIcon(result.getString(3));
				Image photo = icon.getImage();
				Calendar date = Calendar.getInstance();
				date.setTime(result.getDate(2));
				VanPO van = new VanPO(result.getString(0), result.getString(1), date, photo,result.getString(4));
				vanList.add(van);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
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
				birthday.setTime(result.getDate(5));
				driveStart.setTime(result.getDate(6));
				driveEnd.setTime(result.getDate(7));
				Gender genders[] = Gender.values();
				DriverPO driver = new DriverPO(result.getString(0), result.getString(1), birthday, result.getString(2), result.getString(3), genders[result.getInt(4)], driveStart, driveEnd,result.getString(8));
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
				OrgPO org = new OrgPO(result.getString(0), result.getString(1), orgs[result.getInt(2)], result.getString(3),result.getString(4),result.getString(5) );
				orgList.add(org);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return null;
		}
		return orgList;
	}
}
