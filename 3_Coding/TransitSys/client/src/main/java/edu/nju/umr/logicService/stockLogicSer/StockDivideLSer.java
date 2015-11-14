package edu.nju.umr.logicService.stockLogicSer;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.ShelfVO;

public interface StockDivideLSer {
	public ResultMessage searchShelf(String id,String keyword);
	public Result addShelf(ShelfVO shelf);
	public Result deleteShelf(String id);
	public Result reviseShelf(ShelfVO shelf);
//	public ResultMessage checkShelf(String id);
	
}
