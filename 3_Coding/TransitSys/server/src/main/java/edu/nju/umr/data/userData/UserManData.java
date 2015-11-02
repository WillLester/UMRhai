package edu.nju.umr.data.userData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.dataService.userDSer.UserManDSer;
import edu.nju.umr.po.UserPO;
import edu.nju.umr.po.enums.Jurisdiction;

public class UserManData extends UnicastRemoteObject implements UserManDSer{

	public UserManData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<UserPO> findUser(String keyword) throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<UserPO> ar=new ArrayList<UserPO>();
		ar.add(new UserPO("1","Password",Jurisdiction.ADMIN,"一个用户名啊","一个手机号啊","一个机构编号啊"));
		ar.add(new UserPO("2","Password2",Jurisdiction.CENTER,"一个用户名啊2","一个手机号啊2","一个机构编号啊2"));
		return ar;
	}

	public boolean addUser(UserPO user) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean deleteUser(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean reviseUser(UserPO user) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}
}
