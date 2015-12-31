package edu.nju.umr.dataService.stockDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import edu.nju.umr.po.enums.Result;
/**
 * 设置库存警戒线的接口
 * @author Lester
 * 
 */
public interface StockWarningDSer extends Remote{
	/**
	 * 
	 * @param id 仓库的ID，即所属中转中心的ID
	 * @return 警戒线的List，按照航运、铁运、汽运和机动排列，因此List大小是4
	 * @throws RemoteException
	 */
	public ArrayList<Integer> getWarning(String id) throws RemoteException;
	/**
	 * 
	 * @param warnings 警戒线的List，要求按照航运、铁运、汽运和机动排列
	 * @param id 仓库的ID，即所属中转中心的ID
	 * @return 设置的结果
	 * @throws RemoteException
	 */
	public Result setWarning(List<Integer> warnings,String id) throws RemoteException;
	
}
