package edu.nju.umr.dataService.checkDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.order.IncomePO;
import edu.nju.umr.po.order.PaymentPO;
/**
 * 成本收益表
 * @author WillLester
 * @see CostBeneData
 */
public interface CostBeneDSer extends Remote{
	public ArrayList<IncomePO> getIncomes() throws RemoteException;
	public ArrayList<PaymentPO> getPayments() throws RemoteException;
}
