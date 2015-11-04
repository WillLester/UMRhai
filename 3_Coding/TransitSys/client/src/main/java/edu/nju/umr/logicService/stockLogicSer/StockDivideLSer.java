package edu.nju.umr.logicService.stockLogicSer;

import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.ShelfVO;

public interface StockDivideLSer {
	public ResultMessage searchShelf(String id,String keyword);
	public boolean addShelf(ShelfVO shelf);
	public boolean deleteShelf(String id);
	public boolean reviseShelf(ShelfVO shelf);
//	public ResultMessage checkShelf(String id);
	
}
