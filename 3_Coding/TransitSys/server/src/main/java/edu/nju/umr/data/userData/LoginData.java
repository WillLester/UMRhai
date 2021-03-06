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
	private MysqlService mysqlSer;
	private static LoginData data = null;
	private LoginData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}
	
	public static LoginData getLogin() throws RemoteException{
		if(data == null){
			data = new LoginData();
		}
		return data;
	}

	public UserPO findUser(String id,String password) throws RemoteException {
		// TODO 自动生成的方法存根
		ResultSet result = mysqlSer.checkInfo(new UserPO(id, null, null, null, null, null, 0, null));
		Jurisdiction juris[] = Jurisdiction.values();
		try {
			if(result.next()){
				UserPO user = new UserPO(result.getString(1), result.getString(2), juris[result.getInt(5)], result.getString(3), result.getString(4), result.getString(8),result.getInt(6),result.getString(7));
				if(user.getPassword().equals(password)){
					return user;
				} else {
					return new UserPO(id, null, null, null, null, null, 0, null);
				}
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return null;
		}
	}

}
