package edu.nju.umr.po.order.function;
/**
 * 根据当前机构ID找到相应的单据
 * @author Lester
 *
 */
public interface LocationFind {
	/**
	 * 根据当前机构ID获得搜索用的SQL指令
	 * @return 搜索用的SQL指令
	 */
	public String getOrdersHere();
}
