package edu.nju.umr.logic.stub;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.dataService.userDSer.UserManDSer;
import edu.nju.umr.po.UserPO;
import edu.nju.umr.po.enums.Result;

public class UserManLogicStub implements UserManDSer{

	@Override
	public ArrayList<UserPO> findUser(String keyword) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(keyword);
		return null;
	}

	@Override
	public Result addUser(UserPO user) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result deleteUser(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result reviseUser(UserPO user) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result checkIsUsed(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
