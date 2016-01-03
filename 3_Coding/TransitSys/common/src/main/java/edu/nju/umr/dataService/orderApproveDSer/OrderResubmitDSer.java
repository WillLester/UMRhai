package edu.nju.umr.dataService.orderApproveDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.order.function.KindGetter;
/**
 * 查看未通过单据
 * @author WillLester
 * @see OrderResubmitData
 */
public interface OrderResubmitDSer extends Remote{
	/**
	 * 
	 * @param userId 用户名
	 * @return 未通过单据的列表 以KindGetter接口的形式
	 * @throws RemoteException
	 */
	public ArrayList<KindGetter> getOrders(String userId) throws RemoteException;
}
