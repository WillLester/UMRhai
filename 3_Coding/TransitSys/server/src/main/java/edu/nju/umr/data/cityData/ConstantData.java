package edu.nju.umr.data.cityData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.cityDSer.ConstantDSer;
import edu.nju.umr.po.ConstantPO;

public class ConstantData  extends UnicastRemoteObject implements ConstantDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4333792722404056865L;
	private MysqlService mysqlSer;
	public ConstantData () throws RemoteException{
		super();
		mysqlSer = new MysqlImpl();
	}
	
	public boolean setConstant(ConstantPO constant)throws RemoteException{
		return true;
	}
	public ConstantPO getConstant()throws RemoteException{
		return new ConstantPO(23333333,2,3,4,5,6,7,8,9);
	}

}
