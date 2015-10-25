package edu.nju.umr.logic.stockLogic;

import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.logicService.stockLogicSer.StockCheckNowLSer;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.enums.Part;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.StockVO;
import edu.nju.umr.vo.GoodVO;
import edu.nju.umr.vo.order.OrderVO;

public class StockCheckNowLogic implements StockCheckNowLSer{

	public ResultMessage checkNow(String id) {
		// TODO 自动生成的方法存根
		StockVO sv=new StockVO(new ArrayList<GoodVO>());
		sv.getGoods().add(new GoodVO("1",new Date(),"南京",Part.PLANE,"shelf1",1,1));
		sv.getGoods().add(new GoodVO("2",new Date(),"上海",Part.TRAIN,"shelf2",3,4));
		ResultMessage message = new ResultMessage(true, sv);
		return message;
	}

	public boolean setPoint(String id, Date date) {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean outputExcel(String location, StockVO stock) {
		// TODO 自动生成的方法存根
		return true;
	}

}
