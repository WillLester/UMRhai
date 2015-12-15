package edu.nju.umr.logicService.utilityLogicSer;

import edu.nju.umr.vo.ResultMessage;
/**
 * 用于获得各种常量
 * @author Lester
 *
 */
public interface ConstantGetLSer {
	/**
	 * 获得订单运费（经济，标准，特快）
	 * @return 价格List，目前是Array，按经济，标准和特快的顺序排,数值是BigDecimal
	 */
	public ResultMessage getExpressCost();
	
	/**
	 * 获得运费额（飞机，铁路，公路）
	 * @return List,目前是Array，按照飞机、铁路、公路排序的运费，数值是BigDecimal
	 */
	public ResultMessage getTransitCost();
	
	/**
	 * 获得满载量（飞机、铁路、公路）
	 * @return List，目前是Array,按照飞机、铁路、公路排，数值是BigDecimal
	 */
	public ResultMessage getFullLoad();
}
