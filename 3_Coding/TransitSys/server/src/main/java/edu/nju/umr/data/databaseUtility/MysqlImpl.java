package edu.nju.umr.data.databaseUtility;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.CitiesPO;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.DiaryPO;
import edu.nju.umr.po.DriverPO;
import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.ShelfPO;
import edu.nju.umr.po.StockPO;
import edu.nju.umr.po.TransitInfoPO;
import edu.nju.umr.po.UserPO;
import edu.nju.umr.po.VanPO;
import edu.nju.umr.po.WorkPO;
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
	public Result addInfo(Object ob, POKind kind) {
		// TODO 自动生成的方法存根
		try{
			switch(kind){
			case ACCOUNT:
				state.executeUpdate(getCommand((AccountPO) ob, MysqlOperation.INSERT));
				break;
			case CITIES:
				state.executeUpdate(getCommand((CitiesPO) ob, MysqlOperation.INSERT));
				break;
			case CITY:
				state.executeUpdate(getCommand((CityPO)ob, MysqlOperation.INSERT));
				break;
			case DIARY:
				state.executeUpdate(getCommand((DiaryPO)ob, MysqlOperation.INSERT));
				break;
			case DRIVER:
				state.executeUpdate(getCommand((DriverPO)ob, MysqlOperation.INSERT));
				break;
			case GOOD:
				state.executeUpdate(getCommand((GoodPO)ob, MysqlOperation.INSERT));
				break;
			case ORG:
				state.executeUpdate(getCommand((OrgPO)ob, MysqlOperation.INSERT));
				break;
			case SHELF:
				state.executeUpdate(getCommand((ShelfPO)ob, MysqlOperation.INSERT));
				break;
			case STOCK:
				//state.executeUpdate(getCommand((StockPO)ob, MysqlOperation.INSERT));
				StockPO po=(StockPO)ob;
				for(int i=0;i<po.getGoods().size();i++)
				{
					state.executeUpdate(getCommand(po.getGoods().get(i),MysqlOperation.INSERT));
				}
				break;
			case USER:
				state.executeUpdate(getCommand((UserPO)ob, MysqlOperation.INSERT));
				break;
			case VAN:
				state.executeUpdate(getCommand((VanPO)ob, MysqlOperation.INSERT));
				break;
			case WORK:
				state.executeUpdate(getCommand((WorkPO)ob, MysqlOperation.INSERT));
				break;
			case ARRIVE:
				state.executeUpdate(getCommand((ArrivePO)ob,MysqlOperation.INSERT));
				break;
			case CENTERLOADING:
				state.executeUpdate(getCommand((CenterLoadingPO)ob,MysqlOperation.INSERT));
				break;
			case EXPRESS:
				state.executeUpdate(getCommand((ExpressPO)ob,MysqlOperation.INSERT));
				break;
			case HALLLOADING:
				state.executeUpdate(getCommand((HallLoadingPO)ob,MysqlOperation.INSERT));
				break;
			case INCOME:
				state.executeUpdate(getCommand((IncomePO)ob,MysqlOperation.INSERT));
				break;
			case ORDER:
				state.executeUpdate(getCommand((OrderPO)ob,MysqlOperation.INSERT));
				break;
			case PAYMENT:
				state.executeUpdate(getCommand((PaymentPO)ob,MysqlOperation.INSERT));
				break;
			case RECIPIENT:
				state.executeUpdate(getCommand((RecipientPO)ob,MysqlOperation.INSERT));
				break;
			case SEND:
				state.executeUpdate(getCommand((SendPO)ob,MysqlOperation.INSERT));
				break;
			case STOCKIN:
				state.executeUpdate(getCommand((StockInPO)ob,MysqlOperation.INSERT));
				break;
			case STOCKOUT:
				state.executeUpdate(getCommand((StockOutPO)ob,MysqlOperation.INSERT));
				break;
			case TRANSIT:
				state.executeUpdate(getCommand((TransitPO)ob,MysqlOperation.INSERT));
				break;
			case TRANSITINFO:
				state.executeUpdate(getCommand((TransitInfoPO)ob,MysqlOperation.INSERT));
				break;
			default:return Result.PO_KIND_ERROR;
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return Result.PO_NOT_FOUND;
	}
	public Result deleteInfo(String key, POKind kind) {
		// TODO 自动生成的方法存根
		try {
			switch(kind){
			case ACCOUNT:
				state.executeUpdate(getCommand(new AccountPO(Integer.parseInt(key), null, 0), MysqlOperation.DELETE));
				break;
			case CITIES:
				state.executeUpdate(getCommand(new CitiesPO(key,null,0,0), MysqlOperation.DELETE));
				state.executeUpdate(getCommand(new CitiesPO(null, key, 0, 0),MysqlOperation.DELETE));
				break;
			case CITY:
				state.executeUpdate(getCommand(new CityPO(key, null, null), MysqlOperation.DELETE));
				break;
//			case DIARY:
//				state.executeUpdate(getCommand((DiaryPO)ob, MysqlOperation.INSERT));
//				break;
			case DRIVER:
				state.executeUpdate(getCommand(new DriverPO(key, null, null, null, null, null, null, null), MysqlOperation.DELETE));
				break;
			case GOOD:
				state.executeUpdate(getCommand(new GoodPO(key, null, null, null, null, null, 0, 0), MysqlOperation.DELETE));
				break;
			case ORG:
				state.executeUpdate(getCommand(new OrgPO(key, null, null, null, null), MysqlOperation.DELETE));
				break;
			case SHELF:
				state.executeUpdate(getCommand(new ShelfPO(key, null, 0, 0, null), MysqlOperation.DELETE));
				break;
//			case STOCK:
//				StockPO po=(StockPO)ob;
//				for(int i=0;i<po.getGoods().size();i++) {
//					state.executeUpdate(getCommand(po.getGoods().get(i),MysqlOperation.INSERT));
//				}
//				break;
			case USER:
				state.executeUpdate(getCommand(new UserPO(null, null, null, null, null, null,Integer.parseInt(key)), MysqlOperation.DELETE));
				break;
			case VAN:
				state.executeUpdate(getCommand(new VanPO(key, null, null, null, null), MysqlOperation.DELETE));
				break;
//			case WORK:
//				state.executeUpdate(getCommand(new WorkPO(null, null, null, key, null), MysqlOperation.DELETE));
//				break;
//			case ARRIVE:
//				state.executeUpdate(getCommand(new ArrivePO(null, null, key, null, null, null),MysqlOperation.DELETE));
//				break;
//			case CENTERLOADING:
//				state.executeUpdate(getCommand(new CenterLoadingPO(null, key, null, null, null, null, null, null),MysqlOperation.DELETE));
//				break;
//			case EXPRESS:
//				state.executeUpdate(getCommand(new ExpressPO(null, null, null, null, null, null, null, null, null, null, 0, null, 0, 0, 0, 0, 0, key, null, null, 0, null),MysqlOperation.DELETE));
//				break;
//			case HALLLOADING:
//				state.executeUpdate(getCommand(new HallLoadingPO(key, null, null, null, null, null, null, null, null, null),MysqlOperation.DELETE));
//				break;
//			case INCOME:
//				state.executeUpdate(getCommand(new IncomePO(null, null, 0, null, key, null),MysqlOperation.DELETE));
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
			default:return Result.PO_KIND_ERROR;
		}
		} catch (SQLException e){
			return Result.DATABASE_ERROR;
		}
		
		return Result.PO_NOT_FOUND;
	}
	public Result reviseInfo(Object ob, POKind kind) {
		// TODO 自动生成的方法存根
		try{
			switch(kind){
			case ACCOUNT:
				state.executeUpdate(getCommand((AccountPO) ob, MysqlOperation.UPDATE));
				break;
			case CITIES:
				state.executeUpdate(getCommand((CitiesPO) ob, MysqlOperation.UPDATE));
				break;
			case CITY:
				state.executeUpdate(getCommand((CityPO)ob, MysqlOperation.UPDATE));
				break;
//			case DIARY:
//				state.executeUpdate(getCommand((DiaryPO)ob, MysqlOperation.INSERT));
//				break;
			case DRIVER:
				state.executeUpdate(getCommand((DriverPO)ob, MysqlOperation.UPDATE));
				break;
			case GOOD:
				state.executeUpdate(getCommand((GoodPO)ob, MysqlOperation.UPDATE));
				break;
			case ORG:
				state.executeUpdate(getCommand((OrgPO)ob, MysqlOperation.UPDATE));
				break;
			case SHELF:
				state.executeUpdate(getCommand((ShelfPO)ob, MysqlOperation.UPDATE));
				break;
//			case STOCK:
//				StockPO po=(StockPO)ob;
//				for(int i=0;i<po.getGoods().size();i++){
//					state.executeUpdate(getCommand(po.getGoods().get(i),MysqlOperation.INSERT));
//				}
//				break;
			case USER:
				state.executeUpdate(getCommand((UserPO)ob, MysqlOperation.UPDATE));
				break;
			case VAN:
				state.executeUpdate(getCommand((VanPO)ob, MysqlOperation.UPDATE));
				break;
			case WORK:
				state.executeUpdate(getCommand((WorkPO)ob, MysqlOperation.UPDATE));
				break;
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
			case TRANSITINFO:
				state.executeUpdate(getCommand((TransitInfoPO)ob,MysqlOperation.UPDATE));
				break;
			default:return Result.PO_KIND_ERROR;
			}
		} catch (SQLException e){
			return Result.DATABASE_ERROR;
		}
		return Result.PO_NOT_FOUND;
	}
	public Object checkInfo(String key,POKind kind) {
		// TODO 自动生成的方法存根
		return null;
	}
	private String getCommand(AccountPO account,MysqlOperation op){
		String command=null;
		switch(op)
		{
		case INSERT:command = "insert into account values"+"("+account.getId()+","+"'"+account.getName()+"',"+account.getBalance()+")";break;
		case DELETE:command = "delete from account where id="+account.getId();break;
		case FIND:break;
		case UPDATE:command = "update account set name='"+account.getName()+"',balance="+account.getBalance()+" where id="+account.getId();break;
		}
		return command;
	}
	private String getCommand(CitiesPO cities,MysqlOperation op){
		String command=null;
		switch(op){
		case INSERT:command = "insert into citiesInfo values"+"('"+cities.getCity1()+"','"+cities.getCity2()+"',"+cities.getDistance()+")";break;
		case DELETE:
			if(cities.getCity2() == null)
				command = "delete from citiesInfo where city1='" + cities.getCity1()+"'";
			else
				command = "delete from citiesInfo where city2='" + cities.getCity2()+"'";
			break;
		case FIND:break;
		case UPDATE:command = "update citiesInfo set distance ="+cities.getDistance()+" where city1 = '"+cities.getCity1()+"' and city2 = '"+cities.getCity2()+"'";break;
		}
		return command;
	}
	private String getCommand(CityPO city,MysqlOperation op){
		String command=null;
		switch(op)
		{
		case INSERT:command="insert into city values"+"('"+city.getId()+"',"+"'"+city.getName()+"','"+city.getProvince()+"')";break;
		case DELETE:command="delete from city where name='"+city.getName()+"'";break;
		case FIND:break;
		case UPDATE:command = "update city set ";break;
		}
		return command;
	}
	private String getCommand(DiaryPO diary,MysqlOperation op){
		String command=null;
		switch(op)
		{
		case INSERT:command="insert into diary values"+"("+diary.getTime()+","+"'"+diary.getOperation()+"','"+diary.getOperator()+"')";break;
		case DELETE:break;
		case FIND:break;
		case UPDATE:break;
		}
		return command;
	}
	private String getCommand(DriverPO driver,MysqlOperation op){
		String command=null;
		switch(op)
		{
		case INSERT:command="insert into driver values"+"("+"'"+driver.getId()+"','"+driver.getName()+"','"+driver.getIdNum()+"','"+driver.getMobile()+"',"+driver.getSex()+","+driver.getBirthday()+","+driver.getDriveStart()+","+driver.getDriveEnd()+")";break;
		case DELETE:command="delete from driver where id='"+driver.getId()+"'";break;
		case FIND:break;
		case UPDATE:command = "update driver set name='"+driver.getName()+"' idNum='"+driver.getIdNum()+"' mobile='"+driver.getMobile()+"' sex="+driver.getSex().ordinal()+" birthday='"+DateFormat.DATE.format(driver.getBirthday().getTime())+"' driveStart='"+DateFormat.DATE.format(driver.getDriveStart().getTime())+"' driveEnd='"+DateFormat.DATE.format(driver.getDriveEnd().getTime())+"' where id='"+driver.getId()+"'";break;
		}
		return command;
	}
	private String getCommand(GoodPO good,MysqlOperation op){
		String command=null;
		switch(op){
		case INSERT:command="insert into good values"+"("+"'"+good.getId()+"','"+good.getStockId()+"','"+good.getCity()+"',"+good.getPart()+",'"+good.getShelf()+"',"+good.getRow()+","+good.getPlace()+","+good.getDate()+")";break;
		case DELETE:command="delete from good where id='"+good.getId()+"'";break;
		case FIND:break;
		case UPDATE:command="update good set stockId='"+good.getStockId()+"' city='"+good.getCity()+"' part="+good.getPart().ordinal()+" shelf='"+good.getShelf()+"' row="+good.getRow()+" place="+good.getPlace()+" date='"+DateFormat.DATE.format(good.getDate().getTime())+"' where id='"+good.getId()+"'";break;
		}
		return command;
	}
	
	private String getCommand(OrgPO org,MysqlOperation op){
		String command=null;
		switch(op)
		{
		case INSERT:command="insert into org values"+"("+"'"+org.getId()+"','"+org.getName()+"',"+org.getKind()+",'"+org.getLocation()+"','"+org.getCity().getName()+"','"+org.getCity().getId()+"'"+")";break;
		case DELETE:command="delete from org where id='"+org.getId()+"'";break;
		case FIND:break;
		case UPDATE:command="update org set name = '"+org.getName()+"' kind ="+org.getKind().ordinal()+" location='"+org.getLocation()+"' city='"+org.getCity().getName()+"' cityId='"+org.getCity().getId()+"' where id='"+org.getId()+"'";break;
		}
		return command;
	}
	private String getCommand(ShelfPO shelf,MysqlOperation op){
		String command=null;
		switch(op)
		{
		case INSERT:command="insert into shelf values"+"('"+shelf.getId()+"','"+shelf.getStockId()+"',"+shelf.getRow()+","+shelf.getPlace()+","+shelf.getPart()+")";break;
		case DELETE:command="delete from shelf where id='"+shelf.getId()+"'";break;
		case FIND:break;
		case UPDATE:command="update shelf set stockId='"+shelf.getStockId()+"' row="+shelf.getRow()+" place="+shelf.getPlace()+" part="+shelf.getPart().ordinal()+" where id='"+shelf.getId()+"'";break;
		}
		return command;
	}
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
	private String getCommand(UserPO user,MysqlOperation op){
		String command=null;
		switch(op){
		case INSERT:command="insert into user values"+"("+"'"+user.getId()+"','"+user.getPassword()+"','"+user.getName()+"','"+user.getMobile()+"','"+user.getOrg()+"',"+user.getJuri()+")";break;
		case DELETE:command="delete from user where id='"+user.getId()+"'";break;
		case FIND:break;
		case UPDATE:break;
		}
		return command;
	}
	private String getCommand(VanPO van,MysqlOperation op){
		String command=null;
		switch(op)
		{
		case INSERT:command="insert into van values"+"("+"'"+van.getId()+"','"+van.getPlateNum()+"',"+van.getServTime()+",'"+van.getPhoto()+"','"+van.getOrgId()+"'"+")";break;
		case DELETE:command="delete from van where id='"+van.getId()+"'";break;
		case FIND:break;
		case UPDATE:command="update van set plateNum='"+van.getPlateNum()+"' servTime='"+DateFormat.DATE.format(van.getServTime().getTime())+"' orgId='"+van.getOrgId()+"' where id='"+van.getId()+"'";break;
		}
		return command;
	}
	private String getCommand(WorkPO work,MysqlOperation op){
		String command=null;
		switch(op)
		{
		case INSERT:command="insert into work values"+"("+work.getId()+",'"+work.getOrgId()+"',"+work.getKind()+","+work.getMoney()+","+work.getCommission()+")";break;
		case DELETE:command="delete from work where id='"+work.getId()+"'";break;
		case FIND:break;
		case UPDATE:command="update work set orgId='"+work.getOrgId()+"' kind="+work.getKind().ordinal()+" money="+work.getMoney()+" commission="+work.getCommission()+" where id="+work.getId();break;
		}
		return command;
	}
	private String getCommand(ArrivePO arrive,MysqlOperation op){
		String command=null;
		switch(op)
		{
		case INSERT:command="insert into arriveorderwaiting values"+"("+"'"+arrive.getId()+"','"+arrive.getCenterId()+"','"+arrive.getStartPlace()+"',"+arrive.getState()+","+new Date()+","+arrive.getOpTime()+")";break;
		case DELETE:break;
		case FIND:break;
		case UPDATE:break;
		}
		return command;
	}
	private String getCommand(CenterLoadingPO centerLoading,MysqlOperation op){
		String command=null;
		switch(op)
		{
		case INSERT:command="insert into centerlorderwaiting values"+"("+"'"+centerLoading.getId()+"','"+centerLoading.getTarget()+"','"+centerLoading.getVanId()+"','"+centerLoading.getSupervision()+"','"+centerLoading.getEscort()+"',"+centerLoading.getDate()+","+centerLoading.getOpTime()+")";break;
		case DELETE:break;
		case FIND:break;
		case UPDATE:break;
		}
		return command;
	}
	private String getCommand(ExpressPO express,MysqlOperation op){
		String command=null;
		switch(op)
		{
		case INSERT:command="insert into expressorderwaiting values"+"("+"'"+express.getId()+"','"+express.getSender()+"','"+express.getSendLoc()+"','"+express.getReceiver()+"','"+express.getReceiveLoc()+"','"+express.getSendMobile()+"','"+express.getReceiveMobile()+"','"+express.getSendPhone()+"','"+express.getReceivePhone()+"','"+express.getSendUnit()+"','"+express.getReceiveUnit()+"',"+express.getNum()+",'"+express.getName()+"',"+express.getLength()+","+express.getWidth()+","+express.getHeight()+","+express.getVolumn()+","+express.getArrive()+","+express.getKind()+","+express.getCost()+",'"+"null"+"',"+"null"+","+express.getOpTime()+")";break;
		case DELETE:break;
		case FIND:break;
		case UPDATE:break;
		}
		return command;
	}
	private String getCommand(HallLoadingPO hallLoading,MysqlOperation op){
		String command=null;
		switch(op)
		{
		case INSERT:command="insert into halllorderwaiting values"+"("+"'"+hallLoading.getId()+"','"+hallLoading.getHallId()+"','"+hallLoading.getConvertId()+"','"+hallLoading.getVanId()+"','"+hallLoading.getArriveLoc()+"','"+hallLoading.getSupervision()+"','"+hallLoading.getEscort()+"',"+hallLoading.getDate()+","+hallLoading.getOpTime()+")";break;
		case DELETE:break;
		case FIND:break;
		case UPDATE:break;
		}
		return command;
	}
	private String getCommand(IncomePO income,MysqlOperation op){
		String command=null;
		switch(op)
		{
		case INSERT:command="insert into incomeorderwaiting values"+"("+income.getId()+",'"+income.getCourier()+"',"+income.getCost()+","+income.getDate()+","+income.getOpTime()+")";break;
		case DELETE:break;
		case FIND:break;
		case UPDATE:break;
		}
		return command;
	}
	private String getCommand(OrderPO order,MysqlOperation op){
		String command=null;
		switch(op){
		case FIND:break;
		default:
			break;
		}
		return command;
	}
	private String getCommand(PaymentPO payment,MysqlOperation op){
		String command=null;
		switch(op)
		{
		case INSERT:command="insert into paymentorderwaiting values"+"("+payment.getId()+",'"+payment.getPayer()+"','"+payment.getAccount()+"',"+payment.getKind()+","+payment.getAmount()+",'"+payment.getRemarks()+"',"+payment.getDate()+","+payment.getOpTime()+")";break;
		case DELETE:break;
		case FIND:break;
		case UPDATE:break;
		}
		return command;
	}
	private String getCommand(RecipientPO recipient,MysqlOperation op){
		String command=null;
		switch(op)
		{
		case INSERT:command="insert into recipientorderwaiting values"+"("+recipient.getId()+",'"+recipient.getTransitId()+"','"+recipient.getStartPlace()+"',"+recipient.getState()+","+recipient.getDate()+","+recipient.getOpTime()+")";break;
		case DELETE:break;
		case FIND:break;
		case UPDATE:break;
		}
		return command;
	}
	private String getCommand(SendPO send,MysqlOperation op){
		String command=null;
		switch(op)
		{
		case INSERT:command="insert into sendorderwaiting values"+"("+send.getId()+",'"+send.getExpressId()+"','"+send.getCourier()+"',"+send.getDate()+","+send.getOpTime()+")";break;
		case DELETE:break;
		case FIND:break;
		case UPDATE:break;
		}
		return command;
	}
	private String getCommand(StockInPO stockIn, MysqlOperation op){
		String command=null;
		switch(op)
		{
		case INSERT:command="insert into stockinorderwaiting values"+"("+stockIn.getId()+",'"+stockIn.getExpressId()+"','"+stockIn.getArrivePlace()+"',"+stockIn.getPart()+","+stockIn.getShelfId()+","+stockIn.getRow()+","+stockIn.getPlace()+","+stockIn.getDate()+","+stockIn.getOpTime()+")";break;
		case DELETE:break;
		case FIND:break;
		case UPDATE:break;
		}
		return command;
	}
	private String getCommand(StockOutPO stockOut,MysqlOperation op){
		String command=null;
		switch(op)
		{
		case INSERT:command="insert into stockoutwaiting values"+"("+stockOut.getId()+",'"+stockOut.getExpressId()+"',"+stockOut.getKind()+",'"+stockOut.getTransitId()+"',"+stockOut.getDate()+","+stockOut.getOpTime()+")";break;
		case DELETE:break;
		case FIND:break;
		case UPDATE:break;
		}
		return command;
	}
	private String getCommand(TransitPO transit,MysqlOperation op){
		String command=null;
		switch(op){
		case INSERT:command="insert into transitorderwaiting values"+"("+"'"+transit.getId()+"','"+transit.getPlaneId()+"','"+transit.getStartPlace()+"','"+transit.getArrivePlace()+"','"+transit.getContainerId()+"','"+transit.getSupervision()+"',"+null+","+transit.getOpTime()+")";break;
		case DELETE:break;
		case FIND:break;
		case UPDATE:break;
		}
		return command;
	}
	private String getCommand(TransitInfoPO transitInfo,MysqlOperation op){
		String command = null;
		String info = "";
		for(String inf:transitInfo.getInfo()){
			info = info + inf + " ";
		}
		switch(op){
		case INSERT:	
			command = "insert into transitinfo values" + "(" + "'" + transitInfo.getExpressid() + "','" + info +")";
			break;
		case UPDATE:
			command = "update transitinfo set info='"+info+"' where id='"+transitInfo.getExpressid()+"'";break;
		case FIND:break;
		case DELETE:
			break;
		}
		return command;
	}
}
