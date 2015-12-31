package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.ShelfPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.StockInPO;

public interface StockInOrderDSer extends Remote{
	public Result create(StockInPO order) throws RemoteException;
	public ArrayList<ShelfPO> getShelves(String orgId) throws RemoteException;
	
	/**
	 * 获得当日已生成的入库单数量
	 * @param partId 入库单中表示机构编号和日期的部分
	 * @return 数量，-1表示数据库错误
	 * @throws RemoteException
	 */
	public int getOrderSize(String partId) throws RemoteException;
}
