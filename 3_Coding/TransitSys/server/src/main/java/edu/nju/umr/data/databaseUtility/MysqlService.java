package edu.nju.umr.data.databaseUtility;

import java.sql.ResultSet;
import java.util.Calendar;
import java.util.List;

import edu.nju.umr.po.PO;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.enums.POKind;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.function.GetToday;
import edu.nju.umr.po.order.function.OrderOper;
/**
 * 
 * @author WillLester
 * 
 */
public interface MysqlService {
	/**
	 * 添加信息
	 * @param po PO类型的类，会调用getCommand以获取sql指令
	 * 类中应包含所有应含有的信息
	 * @see PO
	 * @return 添加信息的结果
	 */
	public Result addInfo(PO po);
	/**
	 * 删除信息
	 * @param po PO类型的类，会调用getCommand以获取sql指令
	 * 类中只需要有供检索的标记
	 * @see PO
	 * @return 删除信息的结果
	 */
	public Result deleteInfo(PO po);
	/**
	 * 修改信息
	 * @param po PO类型的类，会调用getCommand以获取sql指令
	 * 类中需要有所有应含有的信息
	 * @see PO
	 * @return 删除信息的结果
	 */
	public Result reviseInfo(PO po);
	/**
	 * 检索某类型的所有信息
	 * @param kind 要检索的类型
	 * 可检索的有账户、城市间、城市、机构、用户、人员、收款单、查看单据、付款单和库存
	 * @see POKind
	 * @return
	 */
	public Object checkAll(POKind kind);
	/**
	 * 检索信息
	 * @param po PO类型的类，会调用getCommand以获取sql指令
	 * 类中需要含有检索用的关键字
	 * @see PO
	 * @return 查询得到的ResultSet结果
	 */
	public ResultSet checkInfo(PO po);
	/**
	 * 根据时间检索
	 * @param start 开始时间
	 * @param end 结束时间
	 * @param kind PO的种类
	 * @see POKind
	 * @return
	 */
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
	/**
	 * 获得当天的单据
	 * @param get GetToday接口
	 * @param partId 编号中含有机构编号和日期的部分
	 * @return 包含当天所有单据的ResultSet
	 * @see GetToday
	 */
	public ResultSet checkToday(GetToday get);
}
