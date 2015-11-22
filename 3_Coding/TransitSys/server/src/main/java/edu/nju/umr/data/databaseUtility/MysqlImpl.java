package edu.nju.umr.data.databaseUtility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.data.utilityData.ArrayListFactory;
import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.CitiesPO;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.PO;
import edu.nju.umr.po.UserPO;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.MysqlOperation;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.enums.Organization;
import edu.nju.umr.po.enums.POKind;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.enums.Wage;
import edu.nju.umr.po.order.OrderPO;


public class MysqlImpl implements MysqlService{
	private MysqlConnector connector;
	private Statement state;
	public MysqlImpl() {
		// TODO 自动生成的构造函数存根
		connector = new MysqlConnector();
		try {
			state = connector.getConnect().createStatement();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	protected void finalize(){
		try {
			state.close();
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		connector.close();
		try {
			super.finalize();
		} catch (Throwable e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public Result addInfo(PO po) {
		// TODO 自动生成的方法存根
		try{
			state.executeUpdate(po.getCommand(MysqlOperation.INSERT));
		} catch (SQLException e){
			return Result.DATABASE_ERROR;
		}
		return Result.SUCCESS;
	}
	public Result deleteInfo(PO po) {
		// TODO 自动生成的方法存根
		try {
			state.executeUpdate(po.getCommand(MysqlOperation.DELETE));
		} catch (SQLException e){
			return Result.DATABASE_ERROR;
		}
		
		return Result.SUCCESS;
	}
	public Result reviseInfo(PO po) {
		// TODO 自动生成的方法存根
		try{
			state.executeUpdate(po.getCommand(MysqlOperation.UPDATE));
		} catch (SQLException e){
			return Result.DATABASE_ERROR;
		}
		return Result.SUCCESS;
	}
	public Object checkAll(POKind kind){
		ResultSet result;
		try{
			switch(kind){
			case ACCOUNT:
				result = state.executeQuery("select * from account");
				ArrayList<AccountPO> accountList = new ArrayList<AccountPO>();
				while(result.next()){
					AccountPO account = new AccountPO(result.getInt(0), result.getString(1), result.getDouble(2));
					accountList.add(account);
				}
				return accountList;
			case CITIES:
				result = state.executeQuery("select * from citiesinfo");
				ArrayList<CitiesPO> citiesList = new ArrayList<CitiesPO>();
				while(result.next()){
					CitiesPO cities = new CitiesPO(result.getString(0), result.getString(1), result.getDouble(2));
					citiesList.add(cities);
				}
				return citiesList;
			case CITY:
				result = state.executeQuery("select * from city");
				ArrayList<CityPO> cityList = new ArrayList<CityPO>();
				while(result.next()){
					CityPO city = new CityPO(result.getString(1), result.getString(0), result.getString(2), result.getInt(3));
					cityList.add(city);
				}
				return cityList;
			case ORG:
				Organization orgs[] = Organization.values();
				result = state.executeQuery("select * from org");
				ArrayList<OrgPO> orgList = new ArrayList<OrgPO>();
				while(result.next()){
					OrgPO org = new OrgPO(result.getString(0), result.getString(1), orgs[result.getInt(2)], result.getString(3),result.getString(4),result.getString(5) );
					orgList.add(org);
				}
				return orgList;
			case USER:
				Jurisdiction juris[] = Jurisdiction.values();
				result = state.executeQuery("select * from user");
				ArrayList<UserPO> userList = new ArrayList<UserPO>();
				while(result.next()){
					UserPO user = new UserPO(result.getString(0), result.getString(1), juris[result.getInt(4)], result.getString(2), result.getString(3), result.getString(7),result.getInt(5),result.getString(6));
					userList.add(user);
				}
				return userList;
			case WORK:
				juris = Jurisdiction.values();
				Wage wages[] = Wage.values();
				result = state.executeQuery("select * from user");
				ArrayList<WorkPO> workList = new ArrayList<WorkPO>();
				while(result.next()){
					WorkPO work = new WorkPO(result.getString(2), result.getString(3),result.getString(7) , result.getString(6),result.getInt(5), juris[result.getInt(4)], wages[result.getInt(8)], result.getInt(9), result.getInt(10));
					workList.add(work);
				}
				return workList;
			case INCOME:
				result = state.executeQuery("select * from incomeorderpassed");
				return ArrayListFactory.produceIncomeList(result);
			case ORDER:
				ArrayList<OrderPO> orderList = new ArrayList<OrderPO>();			
				result = state.executeQuery("select * from arriveorderwaiting");
				Calendar time = Calendar.getInstance();
				while(result.next()){
					time.setTime(result.getDate(5));
					OrderPO order = new OrderPO(result.getString(0), Order.ARRIVE, result.getString(6), time, false);
					orderList.add(order);
				}
				result = state.executeQuery("select * from centerlorderwaiting");
				while(result.next()){
					time.setTime(result.getDate(6));
					OrderPO order = new OrderPO(result.getString(0), Order.CENTERLOADING, result.getString(9), time, false);
					orderList.add(order);
				}
				result = state.executeQuery("select * from expressorderwaiting");
				while(result.next()){
					time.setTime(result.getDate(22));
					OrderPO order = new OrderPO(result.getString(0), Order.EXPRESS, result.getString(23), time, false);
					orderList.add(order);
				}
				result = state.executeQuery("select * from halllorderwaiting");
				while(result.next()){
					time.setTime(result.getDate(8));
					OrderPO order = new OrderPO(result.getString(0), Order.HALLLOADING, result.getString(10), time, false);
					orderList.add(order);
				}
				result = state.executeQuery("select * from incomeorderwaiting");
				while(result.next()){
					time.setTime(result.getDate(4));
					OrderPO order = new OrderPO(result.getString(0), Order.INCOME, result.getString(6), time, false);
					orderList.add(order);
				}
				result = state.executeQuery("select * from paymentorderwaiting");
				while(result.next()){
					time.setTime(result.getDate(7));
					OrderPO order = new OrderPO(result.getString(0), Order.PAYMENT, result.getString(8), time, false);
					orderList.add(order);
				}
				result = state.executeQuery("select * from recipientorderwaiting");
				while(result.next()){
					time.setTime(result.getDate(5));
					OrderPO order = new OrderPO(result.getString(0), Order.RECIPIENT, result.getString(6), time, false);
					orderList.add(order);
				}
				result = state.executeQuery("select * from sendorderwaiting");
				while(result.next()){
					time.setTime(result.getDate(4));
					OrderPO order = new OrderPO(result.getString(0), Order.SEND, result.getString(5), time, false);
					orderList.add(order);
				}
				result = state.executeQuery("select * from stockinorderwaiting");
				while(result.next()){
					time.setTime(result.getDate(9));
					OrderPO order = new OrderPO(result.getString(0), Order.STOCKIN, result.getString(9), time, false);
					orderList.add(order);
				}
				result = state.executeQuery("select * from stockoutorderwaiting");
				while(result.next()){
					time.setTime(result.getDate(5));
					OrderPO order = new OrderPO(result.getString(0), Order.STOCKOUT, result.getString(6), time, false);
					orderList.add(order);
				}
				result = state.executeQuery("select * from transitorderwaiting");
				while(result.next()){
					time.setTime(result.getDate(7));
					OrderPO order = new OrderPO(result.getString(0), Order.TRANSIT, result.getString(8), time, false);
					orderList.add(order);
				}
				return orderList;
			case PAYMENT:
				result = state.executeQuery("select * from paymentorderpassed");
				return ArrayListFactory.producePaymentList(result);
			default:return null;
			}
		} catch(SQLException e){
			return null;
		}
	}

	public ResultSet checkInfo(PO po) {
		// TODO 自动生成的方法存根
		ResultSet result;
		try{
			result = state.executeQuery(po.getCommand(MysqlOperation.FIND));
			return result;
		} catch (SQLException e){
			return null;
		}
	}
	public ResultSet checkDate(Calendar start, Calendar end,POKind kind) {
		// TODO 自动生成的方法存根
		ResultSet result;
		try{
			switch(kind){
			case INCOME:
				result = state.executeQuery("select * from incomeorderpassed where comDate between '"+DateFormat.DATE.format(start.getTime())+"' and '"+DateFormat.DATE.format(end.getTime())+"'");break;
			case PAYMENT:
				result = state.executeQuery("select * from paymentorderpassed where comDate between '"+DateFormat.DATE.format(start.getTime())+"' and '"+DateFormat.DATE.format(end.getTime())+"'");break;
			case DIARY:
				result = state.executeQuery("select * from diary where time between '"+DateFormat.TIME.format(start.getTime())+"' and '"+DateFormat.TIME.format(end.getTime())+"'");break;
			case STOCKIN:
				result = state.executeQuery("select * from stockinorderpassed where comDate between '"+DateFormat.DATE.format(start.getTime())+"' and '"+DateFormat.DATE.format(end.getTime())+"'");break;
			case STOCKOUT:
				result = state.executeQuery("select * from stockoutorderpassed where comDate between '"+DateFormat.DATE.format(start.getTime())+"' and '"+DateFormat.DATE.format(end.getTime())+"'");break;
			default:
				return null;
			}
			return result;
		} catch (SQLException e){
			return null;
		}
	}
}
