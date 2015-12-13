package edu.nju.umr.data.orderNewData;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.data.utilityData.ArrayListFactory;
import edu.nju.umr.dataService.orderNewDSer.PaymentOrderDSer;
import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.PaymentPO;
/*
 * 付款单数据
 */
public class PaymentOrderData extends UnicastRemoteObject implements PaymentOrderDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9162964323292140428L;
	private MysqlService mysqlSer;
	private static PaymentOrderData data = null;
	private PaymentOrderData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
		mysqlSer = MysqlImpl.getMysql();
	}
	
	public static PaymentOrderData getPaymentOrder() throws RemoteException{
		if(data == null){
			data = new PaymentOrderData();
		}
		return data;
	}

	public Result create(PaymentPO order) throws RemoteException {
		Result result = mysqlSer.addInfo(order);
		if(result == Result.SUCCESS){
			mysqlSer.deleteUnpassed(order);
		}
		return result;
		
	}

	@Override
	public Result updateAccount(String account, BigDecimal amount)
			throws RemoteException {
		// TODO 自动生成的方法存根
		ResultSet result = mysqlSer.checkInfo(new AccountPO(0, account, null));
		ArrayList<AccountPO> accountList = ArrayListFactory.produceAccountList(result);
		if(accountList == null){
			return Result.DATABASE_ERROR;
		}
		for(AccountPO po:accountList){
			if(po.getName().equals(account)){
				BigDecimal balance = po.getBalance();
				balance = balance.subtract(amount);
				AccountPO newAccount = new AccountPO(po.getId(), account, balance);
				return mysqlSer.reviseInfo(newAccount);
			}
		}
		return Result.DATA_NOT_FOUND;
	}

}
