package edu.nju.umr.data.databaseUtility;

import java.sql.SQLException;
import java.sql.Statement;

import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.CitiesPO;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.ConstantPO;
import edu.nju.umr.po.CountPO;
import edu.nju.umr.po.enums.POKind;


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
			case CITY:break;
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
	private String getCommand(CityPO city){
		return "";
	}
	private String getCommand(ConstantPO constant){
		return "";
	}
	private String getCommand(CountPO count){
		return null;
	}

}
