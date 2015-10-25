package edu.nju.umr.data.workOrgManData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.dataService.workOrgManDSer.WageManDSer;
import edu.nju.umr.po.WagePO;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Wage;

public class WageManData extends UnicastRemoteObject implements WageManDSer{

	public WageManData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<WorkPO> findWork(String keyword) throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<WorkPO> ar2=new ArrayList<WorkPO>();
		ar2.add(new WorkPO("Worker1","11111111111","1","1",Jurisdiction.ADMIN));
		ar2.add(new WorkPO("Worker2","22222222222","2","2",Jurisdiction.COURIER));
		return ar2;
	}

	public boolean reviseWage(WagePO wage) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

	public WagePO getWage(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return new WagePO("WorkerID1",Wage.MONTH,5,5);
	}

}
