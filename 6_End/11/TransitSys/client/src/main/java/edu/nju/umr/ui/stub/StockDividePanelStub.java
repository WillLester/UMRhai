package edu.nju.umr.ui.stub;
import java.util.ArrayList;

import edu.nju.umr.logicService.stockLogicSer.StockDivideLSer;
import edu.nju.umr.po.enums.Part;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.ShelfVO;
public class StockDividePanelStub implements StockDivideLSer{

	@Override
	public ResultMessage searchShelf(String id, String keyword) {
		// TODO Auto-generated method stub
		ArrayList<ShelfVO> ar =new ArrayList<ShelfVO>();
		ar.add(new ShelfVO("1", 2, 3, Part.VAN));
		return new ResultMessage(Result.SUCCESS,ar);
	}

	@Override
	public Result addShelf(ShelfVO shelf, String name, String orgId) {
		// TODO Auto-generated method stub
		return Result.SUCCESS;
	}

	@Override
	public Result deleteShelf(String id, String name) {
		// TODO Auto-generated method stub
		return Result.SUCCESS;
	}

	@Override
	public Result reviseShelf(ShelfVO shelf, String name, String orgId) {
		// TODO Auto-generated method stub
		return Result.SUCCESS;
	}

	@Override
	public String getNextId(String orgId) {
		// TODO Auto-generated method stub
		return "5";
	}

}
