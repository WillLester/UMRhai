package edu.nju.umr.data.userData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.dataService.userDSer.LoginDSer;
import edu.nju.umr.po.UserPO;

public class LoginData extends UnicastRemoteObject implements LoginDSer{

	protected LoginData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public UserPO findUser(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
