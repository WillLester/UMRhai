package edu.nju.umr.logicService.utilityLogicSer;
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
	
}
