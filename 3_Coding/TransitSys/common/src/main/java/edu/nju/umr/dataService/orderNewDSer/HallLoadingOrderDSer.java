package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.HallLoadingPO;

public interface HallLoadingOrderDSer extends Remote{
	public Result create(HallLoadingPO order) throws RemoteException;
	/**
	 * 获得当日已生成单据的数量
	 * @param partId 单据编号中表示机构编号和日期的部分
	 * @return 数量
	 * @throws RemoteException
	 */
	public int getOrderSize(String partId) throws RemoteException;
}
