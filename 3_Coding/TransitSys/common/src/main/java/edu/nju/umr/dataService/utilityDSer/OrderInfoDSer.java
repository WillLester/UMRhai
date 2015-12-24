package edu.nju.umr.dataService.utilityDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import edu.nju.umr.po.order.ExpressPO;

public interface OrderInfoDSer extends Remote{
	/**
	 * 检查中转单编号是否存在
	 * @param id 中转单编号
	 * @return true表示合理，false表示编号不存在
	 * @throws RemoteException
	 */
	public boolean isTransitValid(String id) throws RemoteException;
	
	/**
	 * 检查订单是否存在
	 * @param id 订单编号
	 * @return true表示存在，false表示不存在
	 * @throws RemoteException
	 */
	public boolean isExpressValid(String id) throws RemoteException;
	
	/**
	 * 检查中转中心装车单是否存在
	 * @param id 汽运编号
	 * @return true表示存在，false表示不存在
	 * @throws RemoteException
	 */
	public boolean isCenterLoadValid(String id) throws RemoteException;
	
	/**
	 * 获得快递单列表
	 * @param expressIds 快递单编号列表
	 * @return ExpressPO的List,如果有订单号错了，返回null
	 * @throws RemoteException
	 */
	public List<ExpressPO> getExpresses(List<String> expressIds) throws RemoteException;
	
	/**
	 * 获得中转单中的快递单列表
	 * @param id 中转单编号
	 * @return List<String>表示的快递单列表
	 * @throws RemoteException
	 */
	public List<String> getTransitExp(String id) throws RemoteException;
	
	/**
	 * 获得营业厅装车单中的快递单列表
	 * @param id 装车单编号
	 * @return List<String>表示的快递单列表
	 * @throws RemoteException
	 */
	public List<String> getHallLoadExp(String id) throws RemoteException;
	
	/**
	 * 获得中转中心装车单中的快递单列表
	 * @param id 装车单编号
	 * @return List<String>表示的快递单列表
	 * @throws RemoteException
	 */
	public List<String> getCenterLoadExp(String id) throws RemoteException;
}
