package edu.nju.umr.data.userData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.dataService.userDSer.UserManDSer;
import edu.nju.umr.po.UserPO;

public class UserManData extends UnicastRemoteObject implements UserManDSer{

	public UserManData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public UserPO findUser(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public boolean addUser(UserPO user) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean deleteUser(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean reviseUser(UserPO user) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public ArrayList<UserPO> userList() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
