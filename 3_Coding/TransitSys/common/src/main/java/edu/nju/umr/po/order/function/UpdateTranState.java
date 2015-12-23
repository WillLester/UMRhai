package edu.nju.umr.po.order.function;
/**
 * 更新单据所处的状态
 * @author Lester
 * 订单更新所在位置，中转单更新是否被接收等等
 */
public interface UpdateTranState {
	/**
	 * 获得更新所需的SQL指令
	 * @return SQL指令
	 */
	public String getUpdateTran();
}
