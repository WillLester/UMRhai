package edu.nju.umr.logic.stub;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.orderNewDSer.OrderCalcuDSer;
import edu.nju.umr.po.CitiesPO;
public class OrderCalcuLogicStub implements OrderCalcuDSer{

	@Override
	public CitiesPO getCitesPO(String city1, String city2)
			throws RemoteException {
		// TODO Auto-generated method stub
		return new CitiesPO("1","2",50);
	}

}
