package edu.nju.umr.data.userData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.userDSer.LoginDSer;
import edu.nju.umr.po.UserPO;
import edu.nju.umr.po.enums.Jurisdiction;

public class LoginData extends UnicastRemoteObject implements LoginDSer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8520494959646688525L;
	MysqlService mysqlSer;

	public LoginData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = new MysqlImpl();
	}

	public UserPO findUser(String id,String password) throws RemoteException {
		// TODO 自动生成的方法存根
		return new UserPO(id,"hhhhh",Jurisdiction.ADMIN,"一个用户名啊","一个手机号啊",1);
	}

}
