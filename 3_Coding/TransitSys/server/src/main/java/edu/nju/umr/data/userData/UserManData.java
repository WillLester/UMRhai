package edu.nju.umr.data.userData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.userDSer.UserManDSer;
import edu.nju.umr.po.UserPO;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Result;
/*
 * 用户管理数据
 */
public class UserManData extends UnicastRemoteObject implements UserManDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8342614834288983719L;
	MysqlService mysqlSer;

	public UserManData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = new MysqlImpl();
	}

	public ArrayList<UserPO> findUser(String keyword) throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<UserPO> ar=new ArrayList<UserPO>();
		ar.add(new UserPO("1","Password",Jurisdiction.ADMIN,"一个用户名啊","一个手机号啊",1));
		ar.add(new UserPO("2","Password2",Jurisdiction.CENTER,"一个用户名啊2","一个手机号啊2",1));
		return ar;
	}

	public Result addUser(UserPO user) throws RemoteException {
		return mysqlSer.addInfo(user);
	}

	public Result deleteUser(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.deleteInfo(new UserPO(id, null, null, null, null, 0));
	}

	public Result reviseUser(UserPO user) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.reviseInfo(user);
	}
}
