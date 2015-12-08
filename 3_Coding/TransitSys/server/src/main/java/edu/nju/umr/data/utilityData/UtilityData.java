package edu.nju.umr.data.utilityData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.data.databaseUtility.SerialHelper;
import edu.nju.umr.dataService.utilityDSer.UtilityDSer;
import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.CitiesPO;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.ConstantPO;
import edu.nju.umr.po.DiaryPO;
import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.StockPO;
import edu.nju.umr.po.VanPO;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Organization;
import edu.nju.umr.po.enums.POKind;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.CenterLoadingPO;
import edu.nju.umr.po.order.ExpressPO;

public class UtilityData extends UnicastRemoteObject implements UtilityDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6578374576722125296L;
	private MysqlService mysqlSer;
	public UtilityData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<CityPO> getCities() throws RemoteException {
		// TODO 自动生成的方法存根
		return (ArrayList<CityPO>) mysqlSer.checkAll(POKind.CITY);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<OrgPO> getOrgs() throws RemoteException {
		// TODO 自动生成的方法存根
		return (ArrayList<OrgPO>) mysqlSer.checkAll(POKind.ORG);
	}
	public ArrayList<OrgPO> getHall() throws RemoteException {
		// TODO 自动生成的方法存根
		ResultSet result = mysqlSer.checkInfo(new OrgPO(null, null, Organization.HALL, null, null, null));
		return ArrayListFactory.produceOrgList(result);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<StockPO> getStocks() throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<StockPO> stockList = new ArrayList<StockPO>();
		ArrayList<GoodPO> goodList = (ArrayList<GoodPO>) mysqlSer.checkAll(POKind.STOCK);
		while(!goodList.isEmpty()){
			ArrayList<GoodPO> stockGood = new ArrayList<GoodPO>();
			String stockId = goodList.get(0).getStockId();
			ArrayList<GoodPO> removeList = new ArrayList<GoodPO>();
			for(GoodPO good:goodList){
				if(good.getStockId().equals(stockId)){
					removeList.add(good);
					stockGood.add(good);
				}
			}
			goodList.removeAll(removeList);
			StockPO stock = new StockPO(stockId, stockGood);
			stockList.add(stock);
		}
		return stockList;
	}
	public Result setRecord(Calendar time,String operation,String operator){
		DiaryPO diary = new DiaryPO(operation, time, operator);
		return mysqlSer.addInfo(diary);
	}

	public ArrayList<WorkPO> getWorkers(String orgID) throws RemoteException {
		// TODO 自动生成的方法存根
		return ArrayListFactory.produceWorkList(mysqlSer.checkInfo(new WorkPO(null, null, null, orgID, 0, null, null, 0, 0)));
	}

	public ArrayList<VanPO> getVans(String orgId) throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<VanPO> vanList = ArrayListFactory.produceVanList(mysqlSer.checkInfo(new VanPO(null, null, null, null, orgId)));
		return vanList;
	}
	@SuppressWarnings("unchecked")
	public ArrayList<AccountPO> getAccount() throws RemoteException{
		return (ArrayList<AccountPO>) mysqlSer.checkAll(POKind.ACCOUNT);
	}

	@Override
	public ArrayList<OrgPO> getCenters() throws RemoteException {
		// TODO 自动生成的方法存根
		ResultSet result = mysqlSer.checkInfo(new OrgPO(null, null, Organization.CENTER, null, null, null));
		return ArrayListFactory.produceOrgList(result);
	}

	@Override
	public ArrayList<WorkPO> getCouriers(String hallId) throws RemoteException {
		// TODO 自动生成的方法存根
		ResultSet result = mysqlSer.checkInfo(new WorkPO(null, null, null, null, 0, Jurisdiction.COURIER, null, 0, 0));
		return ArrayListFactory.produceWorkList(result);
	}
	public ConstantPO getConstant() throws RemoteException {
		// TODO 自动生成的方法存根
		return (ConstantPO) SerialHelper.readFromFile("data/constant/constant.ser");
	}

	@Override
	public boolean isTransitValid(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return OrderInfoData.isTransitValid(id);
	}

	@Override
	public boolean isExpressValid(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return OrderInfoData.isExpressValid(id);
	}

	@Override
	public CitiesPO getCitesPO(String city1, String city2)
			throws RemoteException {
		// TODO 自动生成的方法存根
		ResultSet result = mysqlSer.checkInfo(new CitiesPO(city1, city2, 0));
		try {
			if(result.next()){
				CitiesPO cities = new CitiesPO(result.getString(1), result.getString(2), result.getDouble(3));
				return cities;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return null;
		}
	}

	@Override
	public boolean isCenterLoadValid(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		ResultSet result = mysqlSer.checkInfo(new CenterLoadingPO(null, id, null, null, null, null, null, null, null, 0, null));
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
					null, 0, null, 0, 0, 0, 0, 0, id, null, null, null, 0, null, null, null, null, null, null, null, null));
			ExpressPO po = OrderPOFactory.getExpress(result);
			if(po == null){
				return null;
			} else {
				expresses.add(po);
			}
		}
		return expresses;
	}

}
