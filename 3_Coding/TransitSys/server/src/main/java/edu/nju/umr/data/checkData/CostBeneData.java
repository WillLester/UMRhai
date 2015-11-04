package edu.nju.umr.data.checkData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.dataService.checkDSer.CostBeneDSer;
import edu.nju.umr.po.order.IncomePO;
import edu.nju.umr.po.order.PaymentPO;

public class CostBeneData extends UnicastRemoteObject implements CostBeneDSer{

	public CostBeneData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<IncomePO> getIncomes() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<PaymentPO> getPayments() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
