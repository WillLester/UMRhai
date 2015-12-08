package edu.nju.umr.logicService.accountLogicSer;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;

public interface CountLSer {
	/**
	 * 新增账的期初信息
	 * @param name 操作者姓名
	 * @return 新增结果
	 */
	public Result newCount(String name);
	/**
	 * 删除账
	 * @param index 账在列表中的编号（0-base）
	 * @param name 操作者姓名
	 * @return 删除结果
	 */
	public Result deleteCount(int index,String name);
	public ResultMessage getCount();
}
