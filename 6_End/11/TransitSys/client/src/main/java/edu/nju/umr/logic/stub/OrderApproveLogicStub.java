package edu.nju.umr.logic.stub;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.dataService.orderApproveDSer.OrderApproveDSer;
import edu.nju.umr.po.PO;
import edu.nju.umr.po.UserPO;
import edu.nju.umr.po.enums.GoodState;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.ArrivePO;
import edu.nju.umr.po.order.OrderPO;
public class OrderApproveLogicStub implements OrderApproveDSer{

	@Override
	public ArrayList<OrderPO> getExamine() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(boolean isPassed, ArrayList<String> id, Order kind)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PO getOrder(String id, Order kind) throws RemoteException {
		// TODO Auto-generated method stub
		return new ArrivePO("2", Calendar.getInstance(), "2", "2", GoodState.DAMAGED, Calendar.getInstance(), "2", "2");
	}

	@Override
	public UserPO getUser(String userId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


}
