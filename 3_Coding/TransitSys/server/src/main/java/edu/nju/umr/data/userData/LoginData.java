package edu.nju.umr.data.userData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		ResultSet result = mysqlSer.checkInfo(new UserPO(id, password, null, null, null, null, 0, null));
		Jurisdiction juris[] = Jurisdiction.values();
		try {
			if(result.next()){
				UserPO user = new UserPO(result.getString(0), result.getString(1), juris[result.getInt(4)], result.getString(2), result.getString(3), result.getString(7),result.getInt(5),result.getString(6));
				return user;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return null;
		}
	}

}
