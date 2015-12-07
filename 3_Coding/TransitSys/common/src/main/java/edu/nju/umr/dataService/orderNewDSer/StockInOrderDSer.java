package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.ShelfPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.StockInPO;

public interface StockInOrderDSer extends Remote{
	public Result create(StockInPO order) throws RemoteException;
	public ArrayList<ShelfPO> getShelves(String orgId) throws RemoteException;
	/**
	 * 入库单生成后向数据库添加货物的存储信息
	 * @param good 货物信息
	 * @return 添加的结果
	 * @throws RemoteException
	 */
	public Result addGood(GoodPO good) throws RemoteException;
}
