package edu.nju.umr.data.databaseUtility;

import java.sql.ResultSet;
import java.util.Calendar;
import java.util.List;

import edu.nju.umr.po.PO;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.enums.POKind;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.OrderOper;
/**
 * 
 * @author WillLester
 * 
 */
public interface MysqlService {
	public Result addInfo(PO po);
	public Result deleteInfo(PO po);
	public Result reviseInfo(PO po);
	public Object checkAll(POKind kind);
	public ResultSet checkInfo(PO po);
	public ResultSet checkDate(Calendar start,Calendar end,POKind kind);
	/**
	 * 更新单据
	 * @param isPassed 是否通过
	 * @param id 单据编号
	 * @param kind 单据类型
	 * @return Result 更新结果
	 */
	public Result updateOrder(boolean isPassed,List<String> id,Order kind);
	/**
	 * 单据审批查看
	 * @param order 要获得的单据的PO 以OrderOper接口形式
	 * @return ResultSet 返回数据库的ResultSet
	 */
	public ResultSet checkOrder(OrderOper order);
	/**
	 * 获得未通过单据
	 * @param order 要获得单据的PO 以OrderOper接口形式 其中要有用户名
	 * @return ResultSet 返回数据库的ResultSet
	 */
	public ResultSet checkUnpassed(OrderOper order);
	/**
	 * 删除未通过单据
	 * @param order 要删除单据的PO
	 */
	public void deleteUnpassed(OrderOper order);
}
