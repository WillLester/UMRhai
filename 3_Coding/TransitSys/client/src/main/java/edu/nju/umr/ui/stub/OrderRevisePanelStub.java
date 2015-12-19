package edu.nju.umr.ui.stub;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.logicService.orderApproveLogicSer.OrderResubmitLSer;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.OrderVO;

public class OrderRevisePanelStub implements OrderResubmitLSer{

	@Override
	public ResultMessage getUnpassed(String id) {
		// TODO Auto-generated method stub
		return new ResultMessage(Result.SUCCESS,5);
	}

	@Override
	public ResultMessage getOrdersDisplay() {
		// TODO Auto-generated method stub
		ArrayList<OrderVO> ar=new ArrayList<OrderVO>();
		ar.add(new OrderVO("1",Order.ARRIVE,"2",Calendar.getInstance()));
		return new ResultMessage(Result.SUCCESS,ar);
	}

	@Override
	public ResultMessage getOrder(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
