package edu.nju.umr.data.checkData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.data.utilityData.ArrayListFactory;
import edu.nju.umr.dataService.checkDSer.CollectRecordDSer;
import edu.nju.umr.po.enums.POKind;
import edu.nju.umr.po.order.IncomePO;
/*
 * 收款记录数据
 */
public class IncomeListData extends UnicastRemoteObject implements CollectRecordDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2546029703937491602L;
	private MysqlService mysqlSer;
	private static IncomeListData data = null;
	private IncomeListData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}
	
	public static IncomeListData getCollectRecord() throws RemoteException{
		if(data == null){
			data = new IncomeListData();
		} 
		return data;
	}

	public ArrayList<IncomePO> getCollectRec(Calendar date, String id)
			throws RemoteException {
		// TODO 自动生成的方法存根
		if(date == null){
			ResultSet result = mysqlSer.checkInfo(new IncomePO(null, null, null, null, null, null, null, id,null,null));
			return ArrayListFactory.produceIncomeList(result);
		} else {
			Calendar start = Calendar.getInstance();
			Calendar end = Calendar.getInstance();
			start.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DATE), 0, 0, 0);
			end.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DATE), 23, 59, 59);
			ResultSet result = mysqlSer.checkDate(start, end, POKind.INCOME);
			ArrayList<IncomePO> incomeList = ArrayListFactory.produceIncomeList(result);
			if(id == null){
				return incomeList;
			} else {
				ArrayList<IncomePO> newIncomeList = new ArrayList<IncomePO>();
				for(IncomePO income:incomeList){
					if(income.getOrgId().equals(id)){
						newIncomeList.add(income);
					}
				}
				return newIncomeList;
			}
		}
	}
}
