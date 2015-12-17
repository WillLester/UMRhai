package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.RecipientPO;

public interface RecipientOrderDSer extends Remote{
	public Result create(RecipientPO order) throws RemoteException;
	/**
	 * 获得当日生成的接收单数量
	 * @param partId 编号中表示机构编号和日期的部分
	 * @return 数量，-1表示数据库错误
	 * @throws RemoteException
	 */
	public int getOrderSize(String partId) throws RemoteException;
}
