package edu.nju.umr.data.cityData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.data.databaseUtility.SerialHelper;
import edu.nju.umr.dataService.cityDSer.ConstantDSer;
import edu.nju.umr.po.ConstantPO;
import edu.nju.umr.po.enums.Result;

public class ConstantData  extends UnicastRemoteObject implements ConstantDSer{
	public ConstantData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 4333792722404056865L;
	
	public Result setConstant(ConstantPO constant)throws RemoteException{
		return SerialHelper.writeToFile(constant, "data/constant/constant.ser");
	}

	@Override
	public ConstantPO getConstant() throws RemoteException {
		// TODO 自动生成的方法存根
		return (ConstantPO) SerialHelper.readFromFile("data/constant/constant.ser");
	}
}
