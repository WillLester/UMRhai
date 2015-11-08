package edu.nju.umr.data.databaseUtility;

import edu.nju.umr.po.enums.POKind;

public interface MysqlService {
	public boolean addInfo(Object ob,POKind kind);
	public boolean deleteInfo(String statement,String key,POKind kind);
	public boolean reviseInfo(Object ob,POKind kind);
	public Object checkInfo(String statement,String key,POKind kind);
}
