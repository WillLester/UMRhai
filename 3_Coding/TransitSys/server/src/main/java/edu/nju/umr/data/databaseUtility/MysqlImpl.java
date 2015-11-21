package edu.nju.umr.data.databaseUtility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

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
import edu.nju.umr.po.enums.Pay;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.enums.Wage;
import edu.nju.umr.po.order.IncomePO;
import edu.nju.umr.po.order.OrderPO;
import edu.nju.umr.po.order.PaymentPO;


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
//			switch(kind){
//			case ACCOUNT:
//				state.executeUpdate(getCommand((AccountPO) ob, MysqlOperation.INSERT));
//				break;
//			case CITIES:
//				state.executeUpdate(getCommand((CitiesPO) ob, MysqlOperation.INSERT));
//				break;
//			case CITY:
//				state.executeUpdate(getCommand((CityPO)ob, MysqlOperation.INSERT));
//				break;
//			case DIARY:
//				state.executeUpdate(getCommand((DiaryPO)ob, MysqlOperation.INSERT));
//				break;
//			case DRIVER:
//				state.executeUpdate(getCommand((DriverPO)ob, MysqlOperation.INSERT));
//				break;
//			case GOOD:
//				state.executeUpdate(getCommand((GoodPO)ob, MysqlOperation.INSERT));
//				break;
//			case ORG:
//				state.executeUpdate(getCommand((OrgPO)ob, MysqlOperation.INSERT));
//				break;
//			case SHELF:
//				state.executeUpdate(getCommand((ShelfPO)ob, MysqlOperation.INSERT));
//				break;
//			case STOCK:
//				//state.executeUpdate(getCommand((StockPO)ob, MysqlOperation.INSERT));
//				StockPO po=(StockPO)ob;
//				for(int i=0;i<po.getGoods().size();i++)
//				{
//					state.executeUpdate(getCommand(po.getGoods().get(i),MysqlOperation.INSERT));
//				}
//				break;
//			case USER:
//				state.executeUpdate(getCommand((UserPO)ob, MysqlOperation.INSERT));
//				break;
//			case VAN:
//				state.executeUpdate(getCommand((VanPO)ob, MysqlOperation.INSERT));
//				break;
//			case WORK:
//				state.executeUpdate(getCommand((WorkPO)ob, MysqlOperation.INSERT));
//				break;
//			case ARRIVE:
//				state.executeUpdate(getCommand((ArrivePO)ob,MysqlOperation.INSERT));
//				break;
//			case CENTERLOADING:
//				state.executeUpdate(getCommand((CenterLoadingPO)ob,MysqlOperation.INSERT));
//				break;
//			case EXPRESS:
//				state.executeUpdate(getCommand((ExpressPO)ob,MysqlOperation.INSERT));
//				break;
//			case HALLLOADING:
//				state.executeUpdate(getCommand((HallLoadingPO)ob,MysqlOperation.INSERT));
//				break;
//			case INCOME:
//				state.executeUpdate(getCommand((IncomePO)ob,MysqlOperation.INSERT));
//				break;
//			case ORDER:
//				state.executeUpdate(getCommand((OrderPO)ob,MysqlOperation.INSERT));
//				break;
//			case PAYMENT:
//				state.executeUpdate(getCommand((PaymentPO)ob,MysqlOperation.INSERT));
//				break;
//			case RECIPIENT:
//				state.executeUpdate(getCommand((RecipientPO)ob,MysqlOperation.INSERT));
//				break;
//			case SEND:
//				state.executeUpdate(getCommand((SendPO)ob,MysqlOperation.INSERT));
//				break;
//			case STOCKIN:
//				state.executeUpdate(getCommand((StockInPO)ob,MysqlOperation.INSERT));
//				break;
//			case STOCKOUT:
//				state.executeUpdate(getCommand((StockOutPO)ob,MysqlOperation.INSERT));
//				break;
//			case TRANSIT:
//				state.executeUpdate(getCommand((TransitPO)ob,MysqlOperation.INSERT));
//				break;
//			case TRANSITINFO:
//				state.executeUpdate(getCommand((TransitInfoPO)ob,MysqlOperation.INSERT));
//				break;
//			default:return Result.PO_KIND_ERROR;
//			}
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
					OrgPO org = new OrgPO(result.getString(0), result.getString(1), orgs[result.getInt(2)], result.getString(3),null );
					orgList.add(org);
				}
				return orgList;
			case USER:
				Jurisdiction juris[] = Jurisdiction.values();
				result = state.executeQuery("select * from user");
				ArrayList<UserPO> userList = new ArrayList<UserPO>();
				while(result.next()){
					ResultSet workInfo = state.executeQuery("select * from work where id="+result.getInt(5));
					while(workInfo.next()){
						UserPO user = new UserPO(result.getString(0), result.getString(1), juris[result.getInt(4)], result.getString(2), result.getString(3), workInfo.getString(1),result.getInt(5),workInfo.getString(6));
						userList.add(user);
					}
				}
				return userList;
			case WORK:
				juris = Jurisdiction.values();
				Wage wages[] = Wage.values();
				result = state.executeQuery("select * from user");
				ArrayList<WorkPO> workList = new ArrayList<WorkPO>();
				while(result.next()){
					ResultSet userInfo = state.executeQuery("select * from user where id="+result.getInt(6));
					while(userInfo.next()){
						WorkPO work = new WorkPO(userInfo.getString(2), userInfo.getString(3),result.getString(1) , result.getInt(0), juris[userInfo.getInt(4)], wages[result.getInt(2)], result.getInt(3), result.getInt(4));
						workList.add(work);
					}
				}
				return workList;
			case INCOME:
				result = state.executeQuery("select * from incomeorderpassed");
				ArrayList<IncomePO> incomeList = new ArrayList<IncomePO>();
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
					IncomePO income = new IncomePO(date, result.getString(1), result.getDouble(2), express, result.getInt(0), time,result.getString(6));
					incomeList.add(income);
				}
				return incomeList;
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
				ArrayList<PaymentPO> paymentList = new ArrayList<PaymentPO>();
				while(result.next()){
					Calendar date = Calendar.getInstance();
					date.setTime(result.getDate(6));
					Pay pays[] = Pay.values();
					Calendar opTime = Calendar.getInstance();
					opTime.setTime(result.getDate(7));
					PaymentPO payment = new PaymentPO(result.getInt(0), date,result.getString(1) , result.getString(2), pays[result.getInt(3)], result.getDouble(4), result.getString(5), opTime,result.getString(8));
					paymentList.add(payment);
				}
				return paymentList;
			default:return null;
			}
		} catch(SQLException e){
			return null;
		}
	}

	public Object checkInfo(PO po) {
		// TODO 自动生成的方法存根
		ResultSet result;
		try{
			result = state.executeQuery(po.getCommand(MysqlOperation.FIND));
			return result;
		} catch (SQLException e){
			return null;
		}
	}
	public Object checkDate(Calendar start, Calendar end) {
		// TODO 自动生成的方法存根
		return null;
	}
	
//	private String getCommand(OrgPO org,MysqlOperation op){
//		String command=null;
//		switch(op)
//		{
//		case INSERT:command="insert into org values"+"("+"'"+org.getId()+"','"+org.getName()+"',"+org.getKind()+",'"+org.getLocation()+"','"+org.getCity().getName()+"','"+org.getCity().getId()+"'"+")";break;
//		case DELETE:command="delete from org where id='"+org.getId()+"'";break;
//		case FIND:break;
//		case UPDATE:command="update org set name = '"+org.getName()+"' kind ="+org.getKind().ordinal()+" location='"+org.getLocation()+"' city='"+org.getCity().getName()+"' cityId='"+org.getCity().getId()+"' where id='"+org.getId()+"'";break;
//		}
//		return command;
//	}
//	private String getCommand(ShelfPO shelf,MysqlOperation op){
//		String command=null;
//		switch(op)
//		{
//		case INSERT:command="insert into shelf values"+"('"+shelf.getId()+"','"+shelf.getStockId()+"',"+shelf.getRow()+","+shelf.getPlace()+","+shelf.getPart()+")";break;
//		case DELETE:command="delete from shelf where id='"+shelf.getId()+"'";break;
//		case FIND:break;
//		case UPDATE:command="update shelf set stockId='"+shelf.getStockId()+"' row="+shelf.getRow()+" place="+shelf.getPlace()+" part="+shelf.getPart().ordinal()+" where id='"+shelf.getId()+"'";break;
//		}
//		return command;
//	}
//	private String getCommand(StockPO stock,MysqlOperation op){
//		String command=null;
//		switch(op)
//		{
//		case INSERT:command="insert into  values"+"("+account.getId()+","+"'"+account.getName()+"',"+account.getBalance()+")";break;
//		case DELETE:break;
//		case FIND:break;
//		case UPDATE:break;
//		}
//		return command;
//	}
//	private String getCommand(UserPO user,MysqlOperation op){
//		String command=null;
//		switch(op){
//		case INSERT:command="insert into user values"+"("+"'"+user.getId()+"','"+user.getPassword()+"','"+user.getName()+"','"+user.getMobile()+"','"+user.getOrg()+"',"+user.getJuri()+")";break;
//		case DELETE:command="delete from user where keyid="+user.getKey();break;
//		case FIND:break;
//		case UPDATE:command="update user set id='"+user.getId()+"' password='"+user.getPassword()+"' name='"+user.getName()+"' mobile='"+user.getMobile()+"' org='"+user.getOrg()+"' juri="+user.getJuri().ordinal()+" where keyid="+user.getKey();break;
//		}
//		return command;
//	}
//	private String getCommand(VanPO van,MysqlOperation op){
//		String command=null;
//		switch(op)
//		{
//		case INSERT:command="insert into van values"+"("+"'"+van.getId()+"','"+van.getPlateNum()+"',"+van.getServTime()+",'"+van.getPhoto()+"','"+van.getOrgId()+"'"+")";break;
//		case DELETE:command="delete from van where id='"+van.getId()+"'";break;
//		case FIND:break;
//		case UPDATE:command="update van set plateNum='"+van.getPlateNum()+"' servTime='"+DateFormat.DATE.format(van.getServTime().getTime())+"' orgId='"+van.getOrgId()+"' where id='"+van.getId()+"'";break;
//		}
//		return command;
//	}
//	private String getCommand(WorkPO work,MysqlOperation op){
//		String command=null;
//		switch(op)
//		{
//		case INSERT:command="insert into work values"+"("+work.getId()+",'"+work.getOrgId()+"',"+work.getKind()+","+work.getMoney()+","+work.getCommission()+")";break;
//		case DELETE:command="delete from work where id='"+work.getId()+"'";break;
//		case FIND:break;
//		case UPDATE:command="update work set orgId='"+work.getOrgId()+"' kind="+work.getKind().ordinal()+" money="+work.getMoney()+" commission="+work.getCommission()+" where id="+work.getId();break;
//		}
//		return command;
//	}
//	private String getCommand(ArrivePO arrive,MysqlOperation op){
//		String command=null;
//		switch(op)
//		{
//		case INSERT:command="insert into arriveorderwaiting values"+"("+"'"+arrive.getId()+"','"+arrive.getCenterId()+"','"+arrive.getStartPlace()+"',"+arrive.getState()+","+new Date()+","+arrive.getOpTime()+")";break;
//		case DELETE:break;
//		case FIND:break;
//		case UPDATE:break;
//		}
//		return command;
//	}
//	private String getCommand(CenterLoadingPO centerLoading,MysqlOperation op){
//		String command=null;
//		switch(op){
//		case INSERT:command="insert into centerlorderwaiting values"+"("+"'"+centerLoading.getId()+"','"+centerLoading.getTarget()+"','"+centerLoading.getVanId()+"','"+centerLoading.getSupervision()+"','"+centerLoading.getEscort()+"',"+centerLoading.getDate()+","+centerLoading.getOpTime()+")";break;
//		case DELETE:break;
//		case FIND:break;
//		case UPDATE:break;
//		}
//		return command;
//	}
//	private String getCommand(ExpressPO express,MysqlOperation op){
//		String command=null;
//		switch(op)
//		{
//		case INSERT:command="insert into expressorderwaiting values"+"("+"'"+express.getId()+"','"+express.getSender()+"','"+express.getSendLoc()+"','"+express.getReceiver()+"','"+express.getReceiveLoc()+"','"+express.getSendMobile()+"','"+express.getReceiveMobile()+"','"+express.getSendPhone()+"','"+express.getReceivePhone()+"','"+express.getSendUnit()+"','"+express.getReceiveUnit()+"',"+express.getNum()+",'"+express.getName()+"',"+express.getLength()+","+express.getWidth()+","+express.getHeight()+","+express.getVolumn()+","+express.getArrive()+","+express.getKind()+","+express.getCost()+",'"+"null"+"',"+"null"+","+express.getOpTime()+")";break;
//		case DELETE:break;
//		case FIND:break;
//		case UPDATE:break;
//		}
//		return command;
//	}
//	private String getCommand(HallLoadingPO hallLoading,MysqlOperation op){
//		String command=null;
//		switch(op)
//		{
//		case INSERT:command="insert into halllorderwaiting values"+"("+"'"+hallLoading.getId()+"','"+hallLoading.getHallId()+"','"+hallLoading.getConvertId()+"','"+hallLoading.getVanId()+"','"+hallLoading.getArriveLoc()+"','"+hallLoading.getSupervision()+"','"+hallLoading.getEscort()+"',"+hallLoading.getDate()+","+hallLoading.getOpTime()+")";break;
//		case DELETE:break;
//		case FIND:break;
//		case UPDATE:break;
//		}
//		return command;
//	}
//	private String getCommand(IncomePO income,MysqlOperation op){
//		String command=null;
//		switch(op)
//		{
//		case INSERT:command="insert into incomeorderwaiting values"+"("+income.getId()+",'"+income.getCourier()+"',"+income.getCost()+","+income.getDate()+","+income.getOpTime()+")";break;
//		case DELETE:break;
//		case FIND:break;
//		case UPDATE:break;
//		}
//		return command;
//	}
//	private String getCommand(OrderPO order,MysqlOperation op){
//		String command=null;
//		switch(op){
//		case FIND:break;
//		default:
//			break;
//		}
//		return command;
//	}
//	private String getCommand(PaymentPO payment,MysqlOperation op){
//		String command=null;
//		switch(op)
//		{
//		case INSERT:command="insert into paymentorderwaiting values"+"("+payment.getId()+",'"+payment.getPayer()+"','"+payment.getAccount()+"',"+payment.getKind()+","+payment.getAmount()+",'"+payment.getRemarks()+"',"+payment.getDate()+","+payment.getOpTime()+")";break;
//		case DELETE:break;
//		case FIND:break;
//		case UPDATE:break;
//		}
//		return command;
//	}
//	private String getCommand(RecipientPO recipient,MysqlOperation op){
//		String command=null;
//		switch(op)
//		{
//		case INSERT:command="insert into recipientorderwaiting values"+"("+recipient.getId()+",'"+recipient.getTransitId()+"','"+recipient.getStartPlace()+"',"+recipient.getState()+","+recipient.getDate()+","+recipient.getOpTime()+")";break;
//		case DELETE:break;
//		case FIND:break;
//		case UPDATE:break;
//		}
//		return command;
//	}
//	private String getCommand(SendPO send,MysqlOperation op){
//		String command=null;
//		switch(op)
//		{
//		case INSERT:command="insert into sendorderwaiting values"+"("+send.getId()+",'"+send.getExpressId()+"','"+send.getCourier()+"',"+send.getDate()+","+send.getOpTime()+")";break;
//		case DELETE:break;
//		case FIND:break;
//		case UPDATE:break;
//		}
//		return command;
//	}
//	private String getCommand(StockInPO stockIn, MysqlOperation op){
//		String command=null;
//		switch(op)
//		{
//		case INSERT:command="insert into stockinorderwaiting values"+"("+stockIn.getId()+",'"+stockIn.getExpressId()+"','"+stockIn.getArrivePlace()+"',"+stockIn.getPart()+","+stockIn.getShelfId()+","+stockIn.getRow()+","+stockIn.getPlace()+","+stockIn.getDate()+","+stockIn.getOpTime()+")";break;
//		case DELETE:break;
//		case FIND:break;
//		case UPDATE:break;
//		}
//		return command;
//	}
//	private String getCommand(StockOutPO stockOut,MysqlOperation op){
//		String command=null;
//		switch(op)
//		{
//		case INSERT:command="insert into stockoutwaiting values"+"("+stockOut.getId()+",'"+stockOut.getExpressId()+"',"+stockOut.getKind()+",'"+stockOut.getTransitId()+"',"+stockOut.getDate()+","+stockOut.getOpTime()+")";break;
//		case DELETE:break;
//		case FIND:break;
//		case UPDATE:break;
//		}
//		return command;
//	}
//	private String getCommand(TransitPO transit,MysqlOperation op){
//		String command=null;
//		switch(op){
//		case INSERT:command="insert into transitorderwaiting values"+"("+"'"+transit.getId()+"','"+transit.getPlaneId()+"','"+transit.getStartPlace()+"','"+transit.getArrivePlace()+"','"+transit.getContainerId()+"','"+transit.getSupervision()+"',"+null+","+transit.getOpTime()+")";break;
//		case DELETE:break;
//		case FIND:break;
//		case UPDATE:break;
//		}
//		return command;
//	}
//	private String getCommand(TransitInfoPO transitInfo,MysqlOperation op){
//		String command = null;
//		String info = "";
//		for(String inf:transitInfo.getInfo()){
//			info = info + inf + " ";
//		}
//		switch(op){
//		case INSERT:	
//			command = "insert into transitinfo values" + "(" + "'" + transitInfo.getExpressid() + "','" + info +")";
//			break;
//		case UPDATE:
//			command = "update transitinfo set info='"+info+"' where id='"+transitInfo.getExpressid()+"'";break;
//		case FIND:break;
//		case DELETE:
//			break;
//		}
//		return command;
//	}
}
