package edu.nju.umr.data.transitInfoData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.dataService.accountDSer.CountDSer;
import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.CountPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.StockPO;
import edu.nju.umr.po.VanPO;
import edu.nju.umr.po.WorkPO;

public class CourierData extends UnicastRemoteObject implements CountDSer{

	protected CourierData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public boolean addCount(CountPO count) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public CountPO findInitInfo() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<OrgPO> findOrg() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<WorkPO> getWorkers(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<VanPO> getVans(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<StockPO> getStock(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<AccountPO> getAccount(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
