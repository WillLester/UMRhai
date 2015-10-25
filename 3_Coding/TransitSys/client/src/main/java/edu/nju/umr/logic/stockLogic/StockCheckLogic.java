package edu.nju.umr.logic.stockLogic;

import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.logicService.stockLogicSer.StockCheckLSer;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.vo.order.OrderVO;
import edu.nju.umr.vo.ResultMessage;

public class StockCheckLogic implements StockCheckLSer{

	public ResultMessage checkStock(Date start, Date end, String id) {
		// TODO 自动生成的方法存根
		ArrayList<OrderVO> ar=new ArrayList();
		ar.add(new OrderVO("1",Order.EXPRESS,"sb1",new Date(),false));
		ar.add(new OrderVO("2",Order.ARRIVE,"sb2",new Date(),true));
		ResultMessage message = new ResultMessage(true, ar);
		return message;
	}

}
