package edu.nju.umr.logicService.utilityLogicSer;

import java.util.List;

import edu.nju.umr.po.order.ExpressPO;

/**
 * 单据信息的逻辑接口
 * @author Lester
 *
 */
public interface OrderInfoLSer {
	/**
	 * 判断中转单是否存在
	 * @param id 中转单的编号
	 * @return 判断结果
	 */
	public boolean isTransitValid(String id);
	
	/**
	 * 检查订单编号是否存在
	 * @param id 订单编号
	 * @return 结果
	 */
	public boolean isExpressValid(String id);
	
	/**
	 * 检查中转中心装车单是否存在
	 * @param id 装车单编号
	 * @return 结果
	 */
	public boolean isCenterLoadValid(String id);
	
	/**
	 * 检查订单列表中各订单号是否存在
	 * @param expressList 订单列表，List形式
	 * @return 有错误的第一个订单的index（0-base），如果没有错误则返回-1。
	 */
	public int isExpressListValid(List<String> expressList);
	
	/**
	 * 获得中转单中的订单列表
	 * @param id 中转单编号
	 * @return List<String>表示的订单编号列表
	 */
	public List<String> getTransitExp(String id);
	
	/**
	 * 获得营业厅装车单的订单列表
	 * @param id 营业厅装车单编号
	 * @return List<String>表示的订单编号列表
	 */
	public List<String> getHallLoadExp(String id);
	
	/**
	 * 获得中转中心装车单的订单列表
	 * @param id 中转中心装车单编号
	 * @return List<String>表示的订单编号列表
	 */
	public List<String> getCenterLoadExp(String id);
	
	/**
	 * 根据订单编号获得订单信息
	 * @param expressList 订单编号列表
	 * @return 订单信息列表
	 * @see ExpressPO
	 */
	public List<ExpressPO> getExpresses(List<String> expressList);
}
