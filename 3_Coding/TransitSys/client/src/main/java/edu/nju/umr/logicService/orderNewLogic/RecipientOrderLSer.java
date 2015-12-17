package edu.nju.umr.logicService.orderNewLogic;

import java.util.List;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.RecipientVO;

public interface RecipientOrderLSer {
	public Result create(RecipientVO order);
	public ResultMessage getCities();
	/**
	 * 检查中转单编号是否存在
	 * @param id 中转单编号
	 * @return 编号存在返回true，否则返回false
	 */
	public boolean isTransitValid(String id);
	/**
	 * 获得中转单中的订单号
	 * @param id 中转单编号
	 * @return 订单号List 目前是链表
	 */
	public List<String> expressList(String id);
	
	/**
	 * 获得接收单编号
	 * @param orgId 机构编号
	 * @return
	 */
	public ResultMessage getNextId(String orgId);
}
