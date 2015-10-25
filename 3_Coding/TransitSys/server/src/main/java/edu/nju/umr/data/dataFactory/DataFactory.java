package edu.nju.umr.data.dataFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.umr.data.orderNewData.TransitOrderData;
import edu.nju.umr.data.userData.UserManData;
import edu.nju.umr.data.workOrgManData.VanManData;
import edu.nju.umr.data.workOrgManData.WageManData;
import edu.nju.umr.data.workOrgManData.WorkManData;
import edu.nju.umr.dataService.accountDSer.AccountDSer;
import edu.nju.umr.dataService.accountDSer.CountDSer;
import edu.nju.umr.dataService.checkDSer.CollectFormDSer;
import edu.nju.umr.dataService.checkDSer.DiaryDSer;
import edu.nju.umr.dataService.checkDSer.StatementSheetDSer;
import edu.nju.umr.dataService.cityDSer.CityDSer;
import edu.nju.umr.dataService.dataFactory.AccountDFacSer;
import edu.nju.umr.dataService.dataFactory.ArriveOrderDFacSer;
import edu.nju.umr.dataService.dataFactory.CenterLoadingOrderDFacSer;
import edu.nju.umr.dataService.dataFactory.CityDFacSer;
import edu.nju.umr.dataService.dataFactory.CollectFormDFacSer;
import edu.nju.umr.dataService.dataFactory.CountDFacSer;
import edu.nju.umr.dataService.dataFactory.CourierDFacSer;
import edu.nju.umr.dataService.dataFactory.CustomerDFacSer;
import edu.nju.umr.dataService.dataFactory.DiaryDFacSer;
import edu.nju.umr.dataService.dataFactory.HallLoadingOrderDFacSer;
import edu.nju.umr.dataService.dataFactory.IncomeOrderDFacSer;
import edu.nju.umr.dataService.dataFactory.LoginDFacSer;
import edu.nju.umr.dataService.dataFactory.OrderApproveDFacSer;
import edu.nju.umr.dataService.dataFactory.OrderResubmitDFacSer;
import edu.nju.umr.dataService.dataFactory.OrgManDFacSer;
import edu.nju.umr.dataService.dataFactory.PaymentOrderDFacSer;
import edu.nju.umr.dataService.dataFactory.ReceiveOrderDFacSer;
import edu.nju.umr.dataService.dataFactory.RecipientOrderDFacSer;
import edu.nju.umr.dataService.dataFactory.SendOrderDFacSer;
import edu.nju.umr.dataService.dataFactory.StatementSheetDFacSer;
import edu.nju.umr.dataService.dataFactory.StockCheckDFacSer;
import edu.nju.umr.dataService.dataFactory.StockCheckNowDFacSer;
import edu.nju.umr.dataService.dataFactory.StockCheckWarnDFacSer;
import edu.nju.umr.dataService.dataFactory.StockDivideDFacSer;
import edu.nju.umr.dataService.dataFactory.StockInOrderDFacSer;
import edu.nju.umr.dataService.dataFactory.StockOutOrderDFacSer;
import edu.nju.umr.dataService.dataFactory.StockWarningDFacSer;
import edu.nju.umr.dataService.dataFactory.TransitOrderDFacSer;
import edu.nju.umr.dataService.dataFactory.UserManDFacSer;
import edu.nju.umr.dataService.dataFactory.VanManDFacSer;
import edu.nju.umr.dataService.dataFactory.WageManDFacSer;
import edu.nju.umr.dataService.dataFactory.WorkManDFacSer;
import edu.nju.umr.dataService.orderApproveDSer.OrderApproveDSer;
import edu.nju.umr.dataService.orderApproveDSer.OrderResubmitDSer;
import edu.nju.umr.dataService.orderNewDSer.ArriveOrderDSer;
import edu.nju.umr.dataService.orderNewDSer.CenterLoadingOrderDSer;
import edu.nju.umr.dataService.orderNewDSer.ExpressOrderDSer;
import edu.nju.umr.dataService.orderNewDSer.HallLoadingOrderDSer;
import edu.nju.umr.dataService.orderNewDSer.IncomeOrderDSer;
import edu.nju.umr.dataService.orderNewDSer.PaymentOrderDSer;
import edu.nju.umr.dataService.orderNewDSer.ReceiveOrderDSer;
import edu.nju.umr.dataService.orderNewDSer.RecipientOrderDSer;
import edu.nju.umr.dataService.orderNewDSer.SendOrderDSer;
import edu.nju.umr.dataService.orderNewDSer.StockInOrderDSer;
import edu.nju.umr.dataService.orderNewDSer.StockOutOrderDSer;
import edu.nju.umr.dataService.orderNewDSer.TransitOrderDSer;
import edu.nju.umr.dataService.stockDSer.StockCheckDSer;
import edu.nju.umr.dataService.stockDSer.StockCheckNowDSer;
import edu.nju.umr.dataService.stockDSer.StockCheckWarnDSer;
import edu.nju.umr.dataService.stockDSer.StockDivideDSer;
import edu.nju.umr.dataService.stockDSer.StockWarningDSer;
import edu.nju.umr.dataService.transitInfoDSer.CourierDSer;
import edu.nju.umr.dataService.transitInfoDSer.CustomerDSer;
import edu.nju.umr.dataService.userDSer.LoginDSer;
import edu.nju.umr.dataService.userDSer.UserManDSer;
import edu.nju.umr.dataService.workOrgManDSer.DriverManDSer;
import edu.nju.umr.dataService.workOrgManDSer.OrgManDSer;
import edu.nju.umr.dataService.workOrgManDSer.VanManDSer;
import edu.nju.umr.dataService.workOrgManDSer.WageManDSer;
import edu.nju.umr.dataService.workOrgManDSer.WorkManDSer;
import edu.nju.umr.po.DriverPO;
import edu.nju.umr.po.order.ExpressPO;

public class DataFactory extends UnicastRemoteObject implements AccountDFacSer,ArriveOrderDFacSer,CenterLoadingOrderDFacSer,CityDFacSer,CollectFormDFacSer,CountDFacSer,CourierDFacSer,CustomerDFacSer,
DiaryDFacSer,DriverManDSer,ExpressOrderDSer,HallLoadingOrderDFacSer,IncomeOrderDFacSer,LoginDFacSer,OrderApproveDFacSer,OrderResubmitDFacSer,OrgManDFacSer,PaymentOrderDFacSer,ReceiveOrderDFacSer,
RecipientOrderDFacSer,SendOrderDFacSer,StatementSheetDFacSer,StockCheckDFacSer,StockCheckNowDFacSer,StockCheckWarnDFacSer,StockDivideDFacSer,StockInOrderDFacSer,StockOutOrderDFacSer,
StockWarningDFacSer,TransitOrderDFacSer,UserManDFacSer,VanManDFacSer,WageManDFacSer,WorkManDFacSer{

	protected DataFactory() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public WorkManDSer getWorkMan() throws RemoteException {
		// TODO 自动生成的方法存根
		return new WorkManData();
	}

	public WageManDSer getWageMan() throws RemoteException {
		// TODO 自动生成的方法存根
		return new WageManData();
	}

	public VanManDSer getVanMan() throws RemoteException {
		// TODO 自动生成的方法存根
		return new VanManData();
	}

	public UserManDSer getUserMan() throws RemoteException {
		// TODO 自动生成的方法存根
		return new UserManData();
	}

	public TransitOrderDSer getTransitOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return new TransitOrderData();
	}

	public StockWarningDSer getStockWarning() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public StockOutOrderDSer getStockOutOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public StockInOrderDSer getStockInOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public StockDivideDSer getStockDivide() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public StockCheckWarnDSer getStockCheckWarn() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public StockCheckNowDSer getStockCheckNow() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public StockCheckDSer getStockCheck() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public StatementSheetDSer getStatementSheet() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public SendOrderDSer getSendOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public RecipientOrderDSer getRecipientOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public ReceiveOrderDSer getReceiveOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public PaymentOrderDSer getPaymentOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public OrgManDSer getOrgMan() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public OrderApproveDSer getOrderApprove() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public LoginDSer getLogin() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public IncomeOrderDSer getIncomeOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public HallLoadingOrderDSer getHallLoadingOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public boolean create(ExpressPO order) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public ArrayList<DriverPO> findDriver(String keyword)
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public boolean addDriver(DriverPO Driver) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean deleteDriver(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean reviseDriver(DriverPO Driver) throws RemoteException {
		// TODO 自动生成的方法存根
		return false;
	}

	public DriverPO checkDriver(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public DiaryDSer getDiary() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public CustomerDSer getCustomer() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public CourierDSer getCourier() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public CountDSer getCountData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public CollectFormDSer getCollect() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public CityDSer getCity() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public CenterLoadingOrderDSer getCenterLoadingOrder()
			throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArriveOrderDSer getArriveOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public AccountDSer getAccountData() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

	public OrderResubmitDSer getOrderResubmit() throws RemoteException {
		// TODO 自动生成的方法存根
		return null;
	}

}
