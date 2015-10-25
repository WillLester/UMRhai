package edu.nju.umr.logic.stockLogic;

import java.util.ArrayList;

import edu.nju.umr.logicService.stockLogicSer.StockDivideLSer;
import edu.nju.umr.po.enums.Part;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.ShelfVO;

public class StockDivideLogic implements StockDivideLSer{

	public ResultMessage shelfList(String id) {
		// TODO 自动生成的方法存根
		ArrayList<ShelfVO> ar=new ArrayList<ShelfVO>();
		ar.add(new ShelfVO("1",1,1,Part.PLANE));
		ar.add(new ShelfVO("2",3,4,Part.TRAIN));
		ResultMessage message = new ResultMessage(true, ar);
		return message;
	}

	public boolean addShelf(ShelfVO shelf) {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean deleteShelf(String id) {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean reviseShelf(ShelfVO shelf) {
		// TODO 自动生成的方法存根
		return true;
	}

	public ResultMessage checkShelf(String id) {
		// TODO 自动生成的方法存根
		ResultMessage message = new ResultMessage(true, new ShelfVO("1",1,1,Part.PLANE));
		return message;
	}

}
