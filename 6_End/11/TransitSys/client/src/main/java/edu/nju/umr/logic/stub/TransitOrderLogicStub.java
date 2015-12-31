package edu.nju.umr.logic.stub;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.orderNewDSer.TransitOrderDSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.TransitPO;
public class TransitOrderLogicStub implements TransitOrderDSer{

	@Override
	public Result create(TransitPO order) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getOrderSize(String partId) throws RemoteException {
		// TODO Auto-generated method stub
		return 5;
	}

}
