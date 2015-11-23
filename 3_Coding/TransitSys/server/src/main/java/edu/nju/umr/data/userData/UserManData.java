package edu.nju.umr.data.userData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.data.utilityData.ArrayListFactory;
import edu.nju.umr.data.utilityData.EnumFactory;
import edu.nju.umr.dataService.userDSer.UserManDSer;
import edu.nju.umr.po.UserPO;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.POKind;
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

	@SuppressWarnings("unchecked")
	public ArrayList<UserPO> findUser(String keyword) throws RemoteException {
		// TODO 自动生成的方法存根
		if(keyword == null){
			return (ArrayList<UserPO>) mysqlSer.checkAll(POKind.USER);
		} else {
			Jurisdiction juri = EnumFactory.getJuri(keyword);
			ResultSet result = mysqlSer.checkInfo(new UserPO(keyword, null, juri, keyword, null, keyword, 0, null));
			return ArrayListFactory.produceUserList(result);
		}
	}

	public Result addUser(UserPO user) throws RemoteException {
		return mysqlSer.addInfo(user);
	}

	public Result deleteUser(int key) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.deleteInfo(new UserPO(null, null, null, null, null, null, key, null));
	}

	public Result reviseUser(UserPO user) throws RemoteException {
		// TODO 自动生成的方法存根
		return mysqlSer.reviseInfo(user);
	}
}
