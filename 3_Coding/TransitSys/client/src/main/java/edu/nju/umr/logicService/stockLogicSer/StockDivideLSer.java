package edu.nju.umr.logicService.stockLogicSer;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.ShelfVO;
/**
 * 库存分区的逻辑接口
 * @author Lester
 *
 */
public interface StockDivideLSer {
	/**
	 * 关键词检索架信息
	 * @param id 库存编号，即中转中心编号
	 * @param keyword 关键词
	 * @return ResultMessage,包含一个ShelfVO的List
	 */
	public ResultMessage searchShelf(String id,String keyword);
	/**
	 * 添加架
	 * @param shelf ShelfVO
	 * @param name 操作者姓名
	 * @see edu.nju.umr.vo.ShelfVO
	 * @return 结果
	 */
	public Result addShelf(ShelfVO shelf,String name);
	/**
	 * 删除架
	 * @param id 架编号
	 * @param name 操作者姓名
	 * @return 结果
	 */
	public Result deleteShelf(String id,String name);
	/**
	 * 修改架信息
	 * @param shelf ShelfVO
	 * @param name 操作者姓名
	 * @see edu.nju.umr.vo.ShelfVO
	 * @return
	 */
	public Result reviseShelf(ShelfVO shelf,String name);
	
}
