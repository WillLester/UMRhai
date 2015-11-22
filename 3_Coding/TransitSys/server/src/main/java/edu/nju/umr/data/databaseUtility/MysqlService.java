package edu.nju.umr.data.databaseUtility;

import java.sql.ResultSet;
import java.util.Calendar;

import edu.nju.umr.po.PO;
import edu.nju.umr.po.enums.POKind;
import edu.nju.umr.po.enums.Result;

public interface MysqlService {
	public Result addInfo(PO po);
	public Result deleteInfo(PO po);
	public Result reviseInfo(PO po);
	public Object checkAll(POKind kind);
	public ResultSet checkInfo(PO po);
	public ResultSet checkDate(Calendar start,Calendar end,POKind kind);
}
