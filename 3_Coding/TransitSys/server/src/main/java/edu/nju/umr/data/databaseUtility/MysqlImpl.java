package edu.nju.umr.data.databaseUtility;

import edu.nju.umr.po.enums.POKind;



public class MysqlImpl implements MysqlService{
	private MysqlConnector connector;
	public MysqlImpl() {
		// TODO 自动生成的构造函数存根
		connector = new MysqlConnector();
	}
	protected void finalize(){
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
	

}
