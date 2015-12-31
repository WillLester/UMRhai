package edu.nju.umr.logicService.orderNewLogic;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.IncomeVO;

public interface IncomeOrderLSer {
	public Result create(IncomeVO order);
	public ResultMessage getCouriers(String id);
	/**
	 * 获得账户列表
	 * @return String[]形式的账户名称列表
	 */
	public ResultMessage getAccount();
	/**
	 * 获得下一个单据的编号
	 * @param orgId 机构编号
	 * @return int 表示数字编号
	 */
	public ResultMessage getNextId(String orgId);
	public ResultMessage expressAvaliable(String orgId);
	
}
