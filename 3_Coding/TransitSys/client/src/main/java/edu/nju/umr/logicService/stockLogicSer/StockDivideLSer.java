package edu.nju.umr.logicService.stockLogicSer;

import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.ShelfVO;

public interface StockDivideLSer {
	public ResultMessage shelfList(String id);
	public boolean addShelf(ShelfVO shelf);
	public boolean deleteShelf(String id);
	public boolean reviseShelf(ShelfVO shelf);
	public ResultMessage checkShelf(String id);
	
}
