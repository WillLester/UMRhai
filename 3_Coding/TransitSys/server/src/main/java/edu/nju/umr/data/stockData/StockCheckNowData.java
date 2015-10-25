package edu.nju.umr.data.stockData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.ArrayList;

import edu.nju.umr.dataService.stockDSer.StockCheckNowDSer;
import edu.nju.umr.po.StockPO;
import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.enums.Part;

public class StockCheckNowData extends UnicastRemoteObject implements StockCheckNowDSer{

	public StockCheckNowData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public StockPO getStock(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		StockPO sp=new StockPO(new ArrayList<GoodPO>());
		sp.getGoods().add(new GoodPO("1",new Date(),"南京",Part.PLANE,"shelf1",1,1));
		sp.getGoods().add(new GoodPO("2",new Date(),"上海",Part.TRAIN,"shelf2",3,4));
		return sp;
	}

	public boolean setPoint(String id, Date date) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

}
