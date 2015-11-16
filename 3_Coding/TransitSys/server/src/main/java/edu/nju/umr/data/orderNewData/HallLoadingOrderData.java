package edu.nju.umr.data.orderNewData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.orderNewDSer.HallLoadingOrderDSer;
import edu.nju.umr.po.enums.POKind;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.HallLoadingPO;
/*
 * 营业厅装车单数据
 */
public class HallLoadingOrderData extends UnicastRemoteObject implements HallLoadingOrderDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6768962889030917613L;
	private MysqlService mysqlSer;
	public HallLoadingOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = new MysqlImpl();
	}

	public Result create(HallLoadingPO order) throws RemoteException {
		return mysqlSer.addInfo(order, POKind.HALLLOADING);
		
	}

//	public ArrayList<String> getOrgs() throws RemoteException {
//		// TODO 自动生成的方法存根
//		String org1 = "赛艇";
//		String org2 = "乃衣服";
//		ArrayList<String> orgs = new ArrayList<String>();
//		orgs.add(org1);
//		orgs.add(org2);
//		return orgs;
//	}
//
//	public ArrayList<String> getVans() throws RemoteException {
//		// TODO 自动生成的方法存根
//		String van1 = "00001";
//		String van2 = "00002";
//		ArrayList<String> vans = new ArrayList<String>();
//		vans.add(van1);
//		vans.add(van2);
//		return vans;
//	}

}
