package edu.nju.umr.ui.stub;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.logicService.orderApproveLogicSer.OrderApproveLSer;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.OrderVO;
public class OrderApprovePanelStub implements OrderApproveLSer{

	@Override
	public ResultMessage askExamine() {
		// TODO Auto-generated method stub
		ArrayList<OrderVO> ar=new ArrayList<OrderVO>();
		ar.add(new OrderVO("1", Order.ARRIVE, "2", Calendar.getInstance()));
		return new ResultMessage(Result.SUCCESS,ar);
	}

	@Override
	public Result examine(boolean approve, ArrayList<Integer> indexs,
			String name) {
		// TODO Auto-generated method stub
		System.out.println(approve);
		return Result.SUCCESS;
	}

	@Override
	public ResultMessage chooseOrder(String id, Order kind) {
		// TODO Auto-generated method stub
		return null;
	}

}
