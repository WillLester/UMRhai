package edu.nju.umr.data.stockData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import edu.nju.umr.dataService.stockDSer.StockCheckDSer;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.enums.Part;
import edu.nju.umr.po.enums.Transit;
import edu.nju.umr.po.order.OrderPO;
import edu.nju.umr.po.order.StockInPO;
import edu.nju.umr.po.order.StockOutPO;

public class StockCheckData extends UnicastRemoteObject implements StockCheckDSer{

	public StockCheckData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<StockInPO> getIn(Date start, Date end, String id)
			throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<StockInPO> inList = new ArrayList<StockInPO>();
		StockInPO po = new StockInPO("12345", "123343421", new Date(115,4,3), "北京", Part.PLANE, "T10000", 5, 3,Calendar.getInstance());
		inList.add(po);
		return inList;
	}

	public ArrayList<StockOutPO> getOut(Date start, Date end, String id)
			throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<StockOutPO> outList = new ArrayList<StockOutPO>();
		StockOutPO po = new StockOutPO("12345", "1000012314", new Date(115,4,3), Transit.PLANE, "1029142",Calendar.getInstance());
		outList.add(po);
		return outList;
	}

}
