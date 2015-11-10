package edu.nju.umr.data.checkData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.checkDSer.CostBeneDSer;
import edu.nju.umr.po.order.IncomePO;
import edu.nju.umr.po.order.PaymentPO;
/*
 * 成本收益表数据
 */
public class CostBeneData extends UnicastRemoteObject implements CostBeneDSer{
	MysqlService mysqlSer;
	public CostBeneData() throws RemoteException {
		super();
		mysqlSer = new MysqlImpl();
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
