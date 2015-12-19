package edu.nju.umr.data.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.dataService.accountDSer.CountDSer;
import edu.nju.umr.po.CountPO;
import edu.nju.umr.po.enums.Result;

public class CountDataStub implements CountDSer{

	@Override
	public Result addCount(CountPO count) throws RemoteException {
		// TODO 自动生成的方法存根
		return Result.SUCCESS;
	}

	@Override
	public ArrayList<CountPO> getCount() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Result deleteCount(int id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
