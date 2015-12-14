package edu.nju.umr.data.databaseUtility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.data.utilityData.ArrayListFactory;
import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.CitiesPO;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.PO;
import edu.nju.umr.po.enums.MysqlOperation;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.enums.POKind;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.ArrivePO;
import edu.nju.umr.po.order.CenterLoadingPO;
import edu.nju.umr.po.order.ExpressPO;
import edu.nju.umr.po.order.HallLoadingPO;
import edu.nju.umr.po.order.IncomePO;
import edu.nju.umr.po.order.OrderPO;
import edu.nju.umr.po.order.PaymentPO;
import edu.nju.umr.po.order.RecipientPO;
import edu.nju.umr.po.order.SendPO;
import edu.nju.umr.po.order.StockInPO;
import edu.nju.umr.po.order.StockOutPO;
import edu.nju.umr.po.order.TransitPO;
import edu.nju.umr.po.order.function.GetToday;
import edu.nju.umr.po.order.function.OrderOper;


public class MysqlImpl implements MysqlService{
	private MysqlConnector connector;
	private Statement state;
	private static MysqlImpl mysql = null;
	private MysqlImpl() {
		// TODO 自动生成的构造函数存根
		connector = new MysqlConnector();
		try {
			state = connector.getConnect().createStatement();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	/**
	 * 数据库实现单件化，保证只有一个数据库的连接
	 * @return 数据库实现
	 */
	public static MysqlImpl getMysql(){
		if(mysql == null){
			mysql = new MysqlImpl();
		}
		return mysql;
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
			e.printStackTrace();
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
			e.printStackTrace();
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
					AccountPO account = new AccountPO(result.getInt(1), result.getString(2), result.getBigDecimal(3));
					accountList.add(account);
				}
				return accountList;
			case CITIES:
				result = state.executeQuery("select * from citiesinfo");
				ArrayList<CitiesPO> citiesList = new ArrayList<CitiesPO>();
				while(result.next()){
					CitiesPO cities = new CitiesPO(result.getString(1), result.getString(2), result.getDouble(3));
					citiesList.add(cities);
				}
				return citiesList;
			case CITY:
				result = state.executeQuery("select * from city");
				ArrayList<CityPO> cityList = new ArrayList<CityPO>();
				while(result.next()){
					CityPO city = new CityPO(result.getString(2), result.getString(1), result.getString(3), result.getInt(4));
					cityList.add(city);
				}
				return cityList;
			case ORG:
				result = state.executeQuery("select * from org");
				return ArrayListFactory.produceOrgList(result);
			case USER:
				result = state.executeQuery("select * from user");
				return ArrayListFactory.produceUserList(result);
			case WORK:
				result = state.executeQuery("select * from user");
				return ArrayListFactory.produceWorkList(result);
			case INCOME:
				result = state.executeQuery("select * from incomeorderpassed");
				return ArrayListFactory.produceIncomeList(result);
			case ORDER:
				ArrayList<OrderPO> orderList = new ArrayList<OrderPO>();			
				result = state.executeQuery("select * from arriveorderwaiting");
				Calendar time = Calendar.getInstance();
				String datetime = null;
				while(result.next()){
					datetime = result.getString(6);
					time = Calendar.getInstance();
					time.setTime(DateFormat.TIME.parse(datetime));
					OrderPO order = new OrderPO(result.getString(1), Order.ARRIVE, result.getString(7), time, false);
					orderList.add(order);
				}
				result = state.executeQuery("select * from centerlorderwaiting");
				while(result.next()){
					datetime = result.getString(7);
					time = Calendar.getInstance();
					time.setTime(DateFormat.TIME.parse(datetime));
					OrderPO order = new OrderPO(result.getString(1), Order.CENTERLOADING, result.getString(10), time, false);
					orderList.add(order);
				}
				result = state.executeQuery("select * from expressorderwaiting");
				while(result.next()){
					datetime = result.getString(23);
					time = Calendar.getInstance();
					time.setTime(DateFormat.TIME.parse(datetime));
					OrderPO order = new OrderPO(result.getString(1), Order.EXPRESS, result.getString(24), time, false);
					orderList.add(order);
				}
				result = state.executeQuery("select * from halllorderwaiting");
				while(result.next()){
					datetime = result.getString(8);
					time = Calendar.getInstance();
					time.setTime(DateFormat.TIME.parse(datetime));
					OrderPO order = new OrderPO(result.getString(2), Order.HALLLOADING, result.getString(10), time, false);
					orderList.add(order);
				}
				result = state.executeQuery("select * from incomeorderwaiting");
				while(result.next()){
					datetime = result.getString(5);
					time = Calendar.getInstance();
					time.setTime(DateFormat.TIME.parse(datetime));
					OrderPO order = new OrderPO(result.getString(1), Order.INCOME, result.getString(7), time, false);
					orderList.add(order);
				}
				result = state.executeQuery("select * from paymentorderwaiting");
				while(result.next()){
					datetime = result.getString(8);
					time = Calendar.getInstance();
					time.setTime(DateFormat.TIME.parse(datetime));
					OrderPO order = new OrderPO(result.getString(1), Order.PAYMENT, result.getString(9), time, false);
					orderList.add(order);
				}
				result = state.executeQuery("select * from recipientorderwaiting");
				while(result.next()){
					datetime = result.getString(6);
					time = Calendar.getInstance();
					time.setTime(DateFormat.TIME.parse(datetime));
					OrderPO order = new OrderPO(result.getString(1), Order.RECIPIENT, result.getString(7), time, false);
					orderList.add(order);
				}
				result = state.executeQuery("select * from sendorderwaiting");
				while(result.next()){
					datetime = result.getString(5);
					time = Calendar.getInstance();
					time.setTime(DateFormat.TIME.parse(datetime));
					OrderPO order = new OrderPO(result.getString(1), Order.SEND, result.getString(6), time, false);
					orderList.add(order);
				}
				result = state.executeQuery("select * from stockinorderwaiting");
				while(result.next()){
					datetime = result.getString(9);
					time = Calendar.getInstance();
					time.setTime(DateFormat.TIME.parse(datetime));
					OrderPO order = new OrderPO(result.getString(1), Order.STOCKIN, result.getString(10), time, false);
					orderList.add(order);
				}
				result = state.executeQuery("select * from stockoutorderwaiting");
				while(result.next()){
					datetime = result.getString(6);
					time = Calendar.getInstance();
					time.setTime(DateFormat.TIME.parse(datetime));
					OrderPO order = new OrderPO(result.getString(1), Order.STOCKOUT, result.getString(7), time, false);
					orderList.add(order);
				}
				result = state.executeQuery("select * from transitorderwaiting");
				while(result.next()){
					datetime = result.getString(8);
					time = Calendar.getInstance();
					time.setTime(DateFormat.TIME.parse(datetime));
					OrderPO order = new OrderPO(result.getString(1), Order.TRANSIT, result.getString(9), time, false);
					orderList.add(order);
				}
				return orderList;
			case PAYMENT:
				result = state.executeQuery("select * from paymentorderpassed");
				return ArrayListFactory.producePaymentList(result);
			case STOCK:
				result = state.executeQuery("select * from good");
				return ArrayListFactory.produceGoodList(result);
			default:return null;
			}
		} catch(SQLException | ParseException e){
			e.printStackTrace();
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
				result = state.executeQuery("select * from incomeorderpassed where opTime between '"+DateFormat.TIME.format(start.getTime())+"' and '"+DateFormat.TIME.format(end.getTime())+"'");break;
			case PAYMENT:
				result = state.executeQuery("select * from paymentorderpassed where opTime between '"+DateFormat.TIME.format(start.getTime())+"' and '"+DateFormat.TIME.format(end.getTime())+"'");break;
			case DIARY:
				result = state.executeQuery("select * from diary where time between '"+DateFormat.TIME.format(start.getTime())+"' and '"+DateFormat.TIME.format(end.getTime())+"'");break;
			case STOCKIN:
				result = state.executeQuery("select * from stockinorderpassed where opTime between '"+DateFormat.TIME.format(start.getTime())+"' and '"+DateFormat.TIME.format(end.getTime())+"'");break;
			case STOCKOUT:
				result = state.executeQuery("select * from stockoutorderpassed where opTime between '"+DateFormat.TIME.format(start.getTime())+"' and '"+DateFormat.TIME.format(end.getTime())+"'");break;
			default:
				return null;
			}
			return result;
		} catch (SQLException e){
			return null;
		}
	}
	@Override
	public Result updateOrder(boolean isPassed, List<String> id, Order kind) {
		// TODO 自动生成的方法存根
		OrderOper order;
		switch(kind){
		case ARRIVE:
			for(String i:id){
				order = new ArrivePO(null, null, i, null, null, null, null,null);
				Result re = changeOrder(isPassed, order);
				if(!re.equals(Result.SUCCESS)){
					return re;
				}
			}
			return Result.SUCCESS;
		case CENTERLOADING:
			for(String i:id){
				order = new CenterLoadingPO(null, i, null, null, null, null, null, null, null, 0,null);
				Result re = changeOrder(isPassed, order);
				if(!re.equals(Result.SUCCESS)){
					return re;
				}
			}
			return Result.SUCCESS;
		case EXPRESS:
			for(String i:id){
				order = new ExpressPO(null, null, null, null, null, null, null, null, null, null, 0, null, 
						0, 0, 0, 0, 0, i, null, null, null, 0, null, null, null, null, null, null, null,null);
				Result re = changeOrder(isPassed, order);
				if(!re.equals(Result.SUCCESS)){
					return re;
				}
			}
			return Result.SUCCESS;
		case HALLLOADING:
			for(String i:id){
				order = new HallLoadingPO(null, i, null, null, null, null, null, null, null, null, 0,null);
				Result re = changeOrder(isPassed, order);
				if(!re.equals(Result.SUCCESS)){
					return re;
				}
			}
			return Result.SUCCESS;
		case INCOME:
			for(String i:id){
				order = new IncomePO(null, null, null, null, i, null, null, null,null,null);
				Result re = changeOrder(isPassed, order);
				if(!re.equals(Result.SUCCESS)){
					return re;
				}
			}
			return Result.SUCCESS;
		case PAYMENT:
			for(String i:id){
				order = new PaymentPO(Integer.parseInt(i), null, null, null, null, null, null, null, null,null);
				Result re = changeOrder(isPassed, order);
				if(!re.equals(Result.SUCCESS)){
					return re;
				}
			}
			return Result.SUCCESS;
		case RECIPIENT:
			for(String i:id){
				order = new RecipientPO(null, i, null, null, null, null, null,null);
				Result re = changeOrder(isPassed, order);
				if(!re.equals(Result.SUCCESS)){
					return re;
				}
			}
			return Result.SUCCESS;
		case SEND:
			for(String i:id){
				order = new SendPO(null, null, i, null, null, null,null);
				Result re = changeOrder(isPassed, order);
				if(!re.equals(Result.SUCCESS)){
					return re;
				}
			}
			return Result.SUCCESS;
		case STOCKIN:
			for(String i:id){
				order = new StockInPO(i, null, null, null, null, null, 0, 0, null, null, null,null);
				Result re = changeOrder(isPassed, order);
				if(!re.equals(Result.SUCCESS)){
					return re;
				}
			}
			return Result.SUCCESS;
		case STOCKOUT:
			for(String i:id){
				order = new StockOutPO(i, null, null, null, null, null, null, null, null,null);
				Result re = changeOrder(isPassed, order);
				if(!re.equals(Result.SUCCESS)){
					return re;
				}
			}
			return Result.SUCCESS;
		case TRANSIT:
			for(String i:id){
				order = new TransitPO(i, null, null, null, null, null, null, null, null, null, 0,null);
				Result re = changeOrder(isPassed, order);
				if(!re.equals(Result.SUCCESS)){
					return re;
				}
			}
			return Result.SUCCESS;
		default:
			break;
		}
		return Result.PO_NOT_FOUND;
	}
	private Result changeOrder(boolean isPassed,OrderOper order){
		try {
			state.executeUpdate(order.getApprove(isPassed));
			state.executeUpdate(order.getDeleteWaiting());
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return Result.DATABASE_ERROR;
		}
		return Result.SUCCESS;
	}
	@Override
	public ResultSet checkOrder(OrderOper order) {
		// TODO 自动生成的方法存根
		try {
			ResultSet result = state.executeQuery(order.getDetail());
			return result;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public ResultSet checkUnpassed(OrderOper order) {
		// TODO 自动生成的方法存根
		try {
			ResultSet result = state.executeQuery(order.getUnpassed());	
			return result;
		} catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public void deleteUnpassed(OrderOper order) {
		// TODO 自动生成的方法存根
		try {
			state.executeUpdate(order.getDeleteUnpassed());
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	@Override
	public ResultSet checkToday(GetToday get) {
		// TODO 自动生成的方法存根
		try {
			ResultSet result = state.executeQuery(get.getToday());
			return result;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return null;
		}
	}
}
