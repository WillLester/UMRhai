package edu.nju.umr.logicService.orderApproveLogicSer;

import java.util.ArrayList;

import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;

public interface OrderApproveLSer {
	public ResultMessage askExamine();
	/**
	 * 审批单据
	 * @param approve 是否通过
	 * @param indexs 单据在列表中的编号（0-base）
	 * @param name 操作者姓名
	 * @return 结果
	 */
	public Result examine(boolean approve,ArrayList<Integer> indexs,String name);
	public ResultMessage chooseOrder(String id,Order kind);
}	
