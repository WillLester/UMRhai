package edu.nju.umr.data.stockData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.stockDSer.StockCheckNowDSer;
import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.StockPO;
import edu.nju.umr.po.enums.Part;

public class StockCheckNowData extends UnicastRemoteObject implements StockCheckNowDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6212234457642125928L;
	MysqlService mysqlSer;

	public StockCheckNowData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = new MysqlImpl();
	}

	public StockPO getStock(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		StockPO sp=new StockPO("00001",new ArrayList<GoodPO>());
		sp.getGoods().add(new GoodPO("1","00001",Calendar.getInstance(),"南京",Part.PLANE,"shelf1",1,1));
		sp.getGoods().add(new GoodPO("2","00001",Calendar.getInstance(),"上海",Part.TRAIN,"shelf2",3,4));
		return sp;
	}
	
//	public boolean outputExcel(String location, StockPO stock) throws RemoteException{
//		return true;
//	}

}
