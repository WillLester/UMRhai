package edu.nju.umr.data.cityData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.data.databaseUtility.SerialHelper;
import edu.nju.umr.dataService.cityDSer.ConstantDSer;
import edu.nju.umr.po.ConstantPO;

public class ConstantData  extends UnicastRemoteObject implements ConstantDSer{
	public ConstantData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 4333792722404056865L;
	
	public boolean setConstant(ConstantPO constant)throws RemoteException{
		return SerialHelper.writeToFile(constant, "data/constant/constant.ser");
	}
	public ConstantPO getConstant()throws RemoteException{
		return new ConstantPO(23333333,2,3,4,5,6,7,8,9);
	}

}
