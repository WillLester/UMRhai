package edu.nju.umr.logicService.stockLogicSer;

import java.util.ArrayList;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;

public interface StockWarningLSer {
	/**
	 * 修改警戒线
	 * @param warnings 警戒线排序，按照航运、铁运、汽运和机动排列
	 * @param id 仓库ID
	 * @param name 操作者姓名
	 * @return 结果
	 */
	public Result setWarning(ArrayList<Integer> warnings,String id,String name);
	/**
	 * 获得警戒线
	 * @param id 仓库ID，即所属中转中心的编号
	 * @return 若文件找不到，将返回Result.FILE_NOT_FOUND，否则将返回警戒线List,按照航运、铁运、汽运和机动排列
	 * 
	 */
	public ResultMessage getWarning(String id);

}
