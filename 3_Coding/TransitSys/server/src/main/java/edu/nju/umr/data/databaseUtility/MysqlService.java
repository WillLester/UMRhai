package edu.nju.umr.data.databaseUtility;

import edu.nju.umr.po.enums.POKind;
import edu.nju.umr.po.enums.Result;

public interface MysqlService {
	public Result addInfo(Object ob,POKind kind);
	public Result deleteInfo(String key,POKind kind);
	public Result reviseInfo(Object ob,POKind kind);
	public Object checkInfo(String key,POKind kind);
}
