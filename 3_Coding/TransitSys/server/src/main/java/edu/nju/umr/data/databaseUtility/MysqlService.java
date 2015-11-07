package edu.nju.umr.data.databaseUtility;

public interface MysqlService {
	public boolean addInfo(Object ob);
	public boolean deleteInfo(String statement,String key);
	public boolean reviseInfo(Object ob);
	public Object checkInfo(String statement,String key);
}
