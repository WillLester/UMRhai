package edu.nju.umr.data.databaseUtility;

import java.sql.SQLException;
import java.sql.Statement;

import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.CitiesPO;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.DiaryPO;
import edu.nju.umr.po.DriverPO;
import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.ShelfPO;
import edu.nju.umr.po.StockPO;
<<<<<<< HEAD
import edu.nju.umr.po.UserPO;
import edu.nju.umr.po.VanPO;
import edu.nju.umr.po.WorkPO;
=======
>>>>>>> origin/master
import edu.nju.umr.po.enums.POKind;
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
	public boolean addInfo(Object ob, POKind kind) {
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
			default:return false;
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteInfo(String statement, String key, POKind kind) {
		// TODO 自动生成的方法存根
		return false;
	}
	public boolean reviseInfo(Object ob, POKind kind) {
		// TODO 自动生成的方法存根
		return false;
	}
	public Object checkInfo(String statement, String key,POKind kind) {
		// TODO 自动生成的方法存根
		return null;
	}
	private String getCommand(AccountPO acccount,MysqlOperation op){
		
		return "";
	}
	private String getCommand(CitiesPO cities,MysqlOperation op){
		return "";
	}
	private String getCommand(CityPO city,MysqlOperation op){
		return "";
	}
	private String getCommand(DiaryPO diary,MysqlOperation op){
		return "";
	}
	private String getCommand(DriverPO driver,MysqlOperation op){
		return "";
	}
	private String getCommand(GoodPO good,MysqlOperation op){
		return "";
	}
	private String getCommand(OrgPO org,MysqlOperation op){
		return "";
	}
	private String getCommand(ShelfPO shelf,MysqlOperation op){
		return "";
	}
	private String getCommand(StockPO stock,MysqlOperation op){
		return "";
	}
<<<<<<< HEAD
	private String getCommand(UserPO user,MysqlOperation op){
		return "";
	}
	private String getCommand(VanPO van,MysqlOperation op){
		return "";
	}
	private String getCommand(WorkPO work,MysqlOperation op){
		return "";
	}
	private String getCommand(ArrivePO arrive,MysqlOperation op){
		return "";
	}
	private String getCommand(CenterLoadingPO centerLoading,MysqlOperation op){
		return "";
	}
	private String getCommand(ExpressPO express,MysqlOperation op){
		return "";
	}
	private String getCommand(HallLoadingPO hallLoading,MysqlOperation op){
		return "";
	}
	private String getCommand(IncomePO income,MysqlOperation op){
		return "";
	}
	private String getCommand(OrderPO order,MysqlOperation op){
		return "";
	}
	private String getCommand(PaymentPO payment,MysqlOperation op){
		return "";
	}
	private String getCommand(RecipientPO recipient,MysqlOperation op){
		return "";
	}
	private String getCommand(SendPO send,MysqlOperation op){
		return "";
	}
	private String getCommand(StockInPO stockIn, MysqlOperation op){
		return "";
	}
	private String getCommand(StockOutPO stockOut,MysqlOperation op){
		return "";
	}
	private String getCommand(TransitPO transit,MysqlOperation op){
		return "";
	}
=======
	private String getCommand;
>>>>>>> origin/master
}
