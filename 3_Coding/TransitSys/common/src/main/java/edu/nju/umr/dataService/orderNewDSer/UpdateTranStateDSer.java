package edu.nju.umr.dataService.orderNewDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.function.LocationFind;
import edu.nju.umr.po.order.function.UpdateTranState;

/**
 * 更新单据物流状态的数据接口
 * @author Lester
 * 
 */
public interface UpdateTranStateDSer extends Remote{
	/**
	 * 更新单据物流状态
	 * @param order 单据PO，要求实现UpdateTranState接口，PO中要有ID和被更改的状态两项内容
	 * @return 更新结果
	 * @see UpdateTranState
	 * @throws RemoteException
	 */
	public Result updateTranState(UpdateTranState order) throws RemoteException;
	
	/**
	 * 根据当前机构ID获得所有这里的订单列表
	 * @param 实现了LocationFind接口的单据PO，要求含有表示当前位置或状态的项
	 * @see LocationFind
	 * @return 订单ID列表，形式是List<String>
	 * @throws RemoteException
	 */
	public List<String> getExpressesHere(LocationFind order) throws RemoteException;
}
