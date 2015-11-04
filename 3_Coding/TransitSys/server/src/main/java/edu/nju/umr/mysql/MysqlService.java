package edu.nju.umr.mysql;

public interface MysqlService {
	public boolean addInfo(Object ob);
	public boolean deleteInfo(Object ob);
	public boolean reviseInfo(Object ob);
	public Object checkInfo(Object ob);
}
