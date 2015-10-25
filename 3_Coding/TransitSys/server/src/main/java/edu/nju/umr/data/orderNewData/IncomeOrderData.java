package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.dataService.orderNewDSer.IncomeOrderDSer;
import edu.nju.umr.po.order.IncomePO;

public class IncomeOrderData extends UnicastRemoteObject implements IncomeOrderDSer{

	public IncomeOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public boolean create(IncomePO order) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

	public ArrayList<String> getCouriers(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		String courier1 = "宝华";
		String courier2 = "华莱士";
		ArrayList<String> couriers = new ArrayList<String>();
		couriers.add(courier1);
		couriers.add(courier2);
		return couriers;
	}

}
