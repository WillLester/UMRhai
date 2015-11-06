package edu.nju.umr.mysql;


public abstract class MysqlImpl implements MysqlService{
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

}
