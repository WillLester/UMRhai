package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.RecipientPO;

public interface RecipientOrderDSer extends Remote{
	public Result create(RecipientPO order) throws RemoteException;
	/**
	 * 
	 * @param id 中转单编号
	 * @return 中转单含有的所有订单号
	 * @throws RemoteException
	 */
	public ArrayList<String> getExpressList(String id) throws RemoteException;
	/**
	 * 检查中转单编号是否存在
	 * @param id 中转单编号
	 * @return true表示合理，false表示编号不存在
	 * @throws RemoteException
	 */
	public boolean isTransitValid(String id) throws RemoteException;
}
