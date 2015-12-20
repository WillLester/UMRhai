package edu.nju.umr.ui.stub;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.logicService.stockLogicSer.StockCheckNowLSer;
import edu.nju.umr.po.enums.Part;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.StockVO;
import edu.nju.umr.vo.GoodVO;
public class StockCheckNowPanelStub implements StockCheckNowLSer{

	@Override
	public ResultMessage checkNow(String id) {
		// TODO Auto-generated method stub
		ArrayList<GoodVO> ar = new ArrayList<GoodVO>();
		ar.add(new GoodVO("1", Calendar.getInstance(), "2",Part.PLANE, "2", 3, 4));
		StockVO v=new StockVO(ar, "1", "2");
		return new ResultMessage(Result.SUCCESS,v);
	}

	@Override
	public Result outputExcel(String location, String name) {
		// TODO Auto-generated method stub
		return Result.SUCCESS;
	}

}
