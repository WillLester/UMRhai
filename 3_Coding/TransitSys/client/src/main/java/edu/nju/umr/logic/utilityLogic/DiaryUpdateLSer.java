package edu.nju.umr.logic.utilityLogic;

import edu.nju.umr.po.enums.Result;
/**
 * 更新日志的逻辑接口
 * @author Lester
 *
 */
public interface DiaryUpdateLSer {
	/**
	 * 添加日志
	 * @param op 操作名称
	 * @param name 操作者名
	 * @return 结果
	 */
	public Result addDiary(String op,String name);
}
