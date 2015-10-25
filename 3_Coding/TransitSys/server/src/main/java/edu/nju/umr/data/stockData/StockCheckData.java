package edu.nju.umr.data.stockData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.dataService.stockDSer.StockCheckDSer;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.order.OrderPO;

public class StockCheckData extends UnicastRemoteObject implements StockCheckDSer{

	protected StockCheckData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<OrderPO> getInOut(Date start, Date end, String id)
			throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<OrderPO> ar=new ArrayList();
		ar.add(new OrderPO("1",Order.EXPRESS,"sb1",new Date(),false));
		ar.add(new OrderPO("2",Order.ARRIVE,"sb2",new Date(),true));
		return ar;
	}

}
