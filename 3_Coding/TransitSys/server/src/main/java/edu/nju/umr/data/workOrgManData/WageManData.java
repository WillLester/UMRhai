package edu.nju.umr.data.workOrgManData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import edu.nju.umr.dataService.workOrgManDSer.WageManDSer;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.enums.Result;

public class WageManData extends UnicastRemoteObject implements WageManDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2101834215561188546L;

	public WageManData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	@Override
	public List<WorkPO> searchWork(String keyword) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Result updateWork(WorkPO work) {
		// TODO 自动生成的方法存根
		return null;
	}

}
