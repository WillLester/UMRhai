package edu.nju.umr.data.checkData;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.data.utilityData.ArrayListFactory;
import edu.nju.umr.dataService.checkDSer.BusiCircumDSer;
import edu.nju.umr.po.enums.POKind;
import edu.nju.umr.po.order.IncomePO;
import edu.nju.umr.po.order.PaymentPO;
/*
 * 经营情况表数据
 */
public class BusiCircumData extends UnicastRemoteObject implements BusiCircumDSer{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4682435735979107069L;
	private MysqlService mysqlSer;
	public BusiCircumData() throws RemoteException {
		super();
		mysqlSer = new MysqlImpl();
		// TODO 自动生成的构造函数存根
	}

	public ArrayList<IncomePO> findIncome(Calendar start, Calendar end)//时间参数与findPayment相同
			throws RemoteException {
		ResultSet result = mysqlSer.checkDate(start, end, POKind.INCOME);
		return ArrayListFactory.produceIncomeList(result);
	}

	public ArrayList<PaymentPO> findPayment(Calendar start, Calendar end)//时间参数与findIncome相同
			throws RemoteException {
		ResultSet result = mysqlSer.checkDate(start, end, POKind.PAYMENT);
		return ArrayListFactory.producePaymentList(result);
	}
}
