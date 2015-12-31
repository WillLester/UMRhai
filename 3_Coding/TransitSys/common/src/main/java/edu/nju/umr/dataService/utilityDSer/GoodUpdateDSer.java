package edu.nju.umr.dataService.utilityDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.enums.Result;

public interface GoodUpdateDSer extends Remote{
	/**
	 * 入库单生成后向数据库添加货物的存储信息
	 * @param good 货物信息
	 * @return 添加的结果
	 * @throws RemoteException
	 */
	public Result addGood(GoodPO good) throws RemoteException;
	/**
	 * 出库单生成后要从库存中删除货物
	 * @param id 货物（即快递单）的编号
	 * @return 删除结果
	 * @throws RemoteException
	 */
	public Result removeGood(String id) throws RemoteException;
}
