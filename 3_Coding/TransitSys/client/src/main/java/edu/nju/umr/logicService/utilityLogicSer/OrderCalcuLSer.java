package edu.nju.umr.logicService.utilityLogicSer;

import java.math.BigDecimal;
import java.util.List;

import edu.nju.umr.po.enums.Transit;
import edu.nju.umr.vo.ResultMessage;

/**
 * 用于单据中一些数据的计算
 * @author Lester
 *
 */
public interface OrderCalcuLSer {
	/**
	 * 获得两个城市之间的距离
	 * @param city1 城市1
	 * @param city2 城市2
	 * @return 城市之间的距离 类型是BigDecimal，考虑到精度问题。如果没有，则返回。若网络错误，返回null
	 */
	public BigDecimal getDistance(String city1,String city2);
	
	/**
	 * 获得机构之间的运费
	 * @param org1 机构1
	 * @param org2 机构2
	 * @param transit Transit类型，飞机，铁路，公路
	 * @param expressList 订单号列表
	 * @see edu.nju.umr.po.enums.Transit
	 * @return BigDecimal
	 */
	public ResultMessage getPrice(String org1, String org2,Transit transit,List<String> expressList);
}
