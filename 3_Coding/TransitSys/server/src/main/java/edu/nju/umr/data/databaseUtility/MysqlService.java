package edu.nju.umr.data.databaseUtility;

import java.sql.ResultSet;
import java.util.Calendar;
import java.util.List;

import edu.nju.umr.po.PO;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.enums.POKind;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.OrderOper;

public interface MysqlService {
	public Result addInfo(PO po);
	public Result deleteInfo(PO po);
	public Result reviseInfo(PO po);
	public Object checkAll(POKind kind);
	public ResultSet checkInfo(PO po);
	public ResultSet checkDate(Calendar start,Calendar end,POKind kind);
	public Result updateOrder(boolean isPassed,List<String> id,Order kind);
	public ResultSet checkOrder(OrderOper order);
}
