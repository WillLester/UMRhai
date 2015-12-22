package edu.nju.umr.logic.stub;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.dataService.utilityDSer.UtilityDSer;
import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.StockPO;
import edu.nju.umr.po.VanPO;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.enums.Result;
public class UtilityLogicStub implements UtilityDSer{
	public ArrayList<CityPO> getCities() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<CityPO> ar=new ArrayList<CityPO>();
		ar.add(new CityPO(null, null, null, 0));
		return ar;
	}
	@Override
	public ArrayList<OrgPO> getOrgs() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<WorkPO> getWorkers(String OrgID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<VanPO> getVans(String OrgID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<StockPO> getStocks() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<OrgPO> getHall() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<AccountPO> getAccount() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Result setRecord(Calendar time, String operation, String operator)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<OrgPO> getCenters() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<WorkPO> getCouriers(String hallId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
