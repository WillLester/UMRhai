package edu.nju.umr.dataService.utilityDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.po.CitiesPO;

public interface OrderCalcuDSer extends Remote{
	/**
	 * 获得城市间信息
	 * @param city1 城市1
	 * @param city2 城市2
	 * @return CitiesPO 如果没有获得则返回null
	 * @see CitiesPO
	 * @throws RemoteException
	 */
	public CitiesPO getCitesPO(String city1,String city2) throws RemoteException;
}
