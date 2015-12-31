package edu.nju.umr.data.utilityData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.dataService.utilityDSer.OrderInfoDSer;
import edu.nju.umr.po.order.CenterLoadingPO;
import edu.nju.umr.po.order.ExpressPO;
import edu.nju.umr.po.order.HallLoadingPO;
import edu.nju.umr.po.order.TransitPO;
/**
 * 用于获得各种单据的信息
 * @author Lester
 *
 */
public class OrderInfoData extends UnicastRemoteObject implements OrderInfoDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = -63981585528836017L;
	private MysqlService mysqlSer;
	private static OrderInfoData data =null;
	private OrderInfoData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}
	
	public static OrderInfoData getOrderInfo() throws RemoteException{
		if(data == null){
			data = new OrderInfoData();
		}
		return data;
	}

	
	@Override
	/**
	 * 获得中转单中的订单号列表
	 * @param id 中转单编号
	 * @return 中转单中含有的订单号组成的ArrayList
	 */
	public List<String> getTransitExp(String id){
		ResultSet result = mysqlSer.checkInfo(new TransitPO(id, null, null, null, null, null, null, null, null, null, 0, null,null,false,null));
		TransitPO transit = OrderPOFactory.getTransit(result);
		if(transit == null){
			return new ArrayList<String>();
		}
		return transit.getExpress();
	}
	
	@Override
	public boolean isTransitValid(String id){
		ResultSet result = mysqlSer.checkInfo(new TransitPO(id, null, null, null, null, null, null, null, null, null, 0, null,null,false,null));
		try {
			if(result.next()){
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return false;
		}
	}
	
	@Override
	public boolean isExpressValid(String id){
		ResultSet result = mysqlSer.checkInfo(new ExpressPO(null, null, null, null, null, null, 
				null, null, null, null, 0, null, 0, 0, 0, 0, 0, id, null, null, null, 0, null,
				null, null, null, null, null, null, null,null));
		try {
			if(result.next()){
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return false;
		}
	}
	
	@Override
	public boolean isCenterLoadValid(String id){
		ResultSet result = mysqlSer.checkInfo(new CenterLoadingPO(null, id, null, null, null, null, null, null, null, 0, null,false,null,null));
		try {
			if(result.next()){
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return false;
		}
	}
	
	@Override
	public List<ExpressPO> getExpresses(List<String> expressIds)
			throws RemoteException {
		// TODO 自动生成的方法存根
		List<ExpressPO> expresses = new ArrayList<ExpressPO>();
		for(String id:expressIds){
			ResultSet result = mysqlSer.checkInfo(new ExpressPO(null, null, null, null, null, null, null, null, null, 
					null, 0, null, 0, 0, 0, 0, 0, id, null, null, null, 0, null, null, null, null, 
					null, null, null, null,null));
			ExpressPO po = OrderPOFactory.getExpress(result);

			if(po == null){
				return null;
			} else {
				expresses.add(po);
			}
		}
		return expresses;
	}

	@Override
	public List<String> getHallLoadExp(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		ResultSet result = mysqlSer.checkInfo(new HallLoadingPO(null, id, null, null, null, null, null, null, null, null, 0, null,false));
		HallLoadingPO po = OrderPOFactory.getHallLoad(result);
		if(po == null){
			return new ArrayList<String>();
		} else {
			return po.getExpress();
		}
	}

	@Override
	public List<String> getCenterLoadExp(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		ResultSet result = mysqlSer.checkInfo(new CenterLoadingPO(null, id, null, null, null, null, null, null, null, 0, null,false,null,null));
		CenterLoadingPO po = OrderPOFactory.getCenterLoad(result);
		if(po==null)return new ArrayList<String>();
		return po.getExpress();
	}
	
}
