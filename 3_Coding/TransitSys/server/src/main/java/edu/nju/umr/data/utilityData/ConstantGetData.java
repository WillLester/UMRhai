package edu.nju.umr.data.utilityData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.data.databaseUtility.SerialHelper;
import edu.nju.umr.dataService.utilityDSer.ConstantGetDSer;
import edu.nju.umr.po.ConstantPO;

public class ConstantGetData extends UnicastRemoteObject implements ConstantGetDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = -876281662508377343L;
	private static ConstantGetData data = null;
	private ConstantGetData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}
	public static ConstantGetData getConstantGet() throws RemoteException{
		if(data == null){
			data = new ConstantGetData();
		}
		return data;
	}

	@Override
	public ConstantPO getConstant() throws RemoteException {
		// TODO 自动生成的方法存根
		return (ConstantPO) SerialHelper.readFromFile("data/constant/constant.ser");
	}

}
