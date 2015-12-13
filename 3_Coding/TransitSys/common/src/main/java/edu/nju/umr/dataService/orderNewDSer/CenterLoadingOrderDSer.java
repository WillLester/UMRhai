package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.CenterLoadingPO;

public interface CenterLoadingOrderDSer extends Remote{
	public Result create(CenterLoadingPO order) throws RemoteException;
	/**
	 * 获得当天已生成的单据的数量
	 * @param partId 单据编号表示机构编号+日期的部分
	 * @return 数量,返回-1表示数据库错误
	 * @throws RemoteException
	 */
	public int getOrderSize(String partId) throws RemoteException;
}
