package edu.nju.umr.data.dataFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.data.accountData.AccountData;
import edu.nju.umr.data.accountData.CountData;
import edu.nju.umr.data.checkData.BusiCircumData;
import edu.nju.umr.data.checkData.CollectRecordData;
import edu.nju.umr.data.checkData.CostBeneData;
import edu.nju.umr.data.checkData.DiaryData;
import edu.nju.umr.data.cityData.CityData;
import edu.nju.umr.data.cityData.ConstantData;
import edu.nju.umr.data.orderApproveData.OrderApproveData;
import edu.nju.umr.data.orderApproveData.OrderResubmitData;
import edu.nju.umr.data.orderNewData.ArriveOrderData;
import edu.nju.umr.data.orderNewData.CenterLoadingOrderData;
import edu.nju.umr.data.orderNewData.ExpressOrderData;
import edu.nju.umr.data.orderNewData.HallLoadingOrderData;
import edu.nju.umr.data.orderNewData.IncomeOrderData;
import edu.nju.umr.data.orderNewData.PaymentOrderData;
import edu.nju.umr.data.orderNewData.ReceiveOrderData;
import edu.nju.umr.data.orderNewData.RecipientOrderData;
import edu.nju.umr.data.orderNewData.SendOrderData;
import edu.nju.umr.data.orderNewData.StockInOrderData;
import edu.nju.umr.data.orderNewData.StockOutOrderData;
import edu.nju.umr.data.orderNewData.TransitOrderData;
import edu.nju.umr.data.orderNewData.UpdateTransitInfoData;
import edu.nju.umr.data.stockData.StockCheckData;
import edu.nju.umr.data.stockData.StockCheckNowData;
import edu.nju.umr.data.stockData.StockCheckWarnData;
import edu.nju.umr.data.stockData.StockDivideData;
import edu.nju.umr.data.stockData.StockWarningData;
import edu.nju.umr.data.transitInfoData.CourierData;
import edu.nju.umr.data.transitInfoData.CustomerData;
import edu.nju.umr.data.userData.LoginData;
import edu.nju.umr.data.userData.UserManData;
import edu.nju.umr.data.utilityData.DiaryUpdateData;
import edu.nju.umr.data.utilityData.UtilityData;
import edu.nju.umr.data.workOrgManData.DriverManData;
import edu.nju.umr.data.workOrgManData.OrgManData;
import edu.nju.umr.data.workOrgManData.VanManData;
import edu.nju.umr.data.workOrgManData.WageManData;
import edu.nju.umr.data.workOrgManData.WorkManData;
import edu.nju.umr.dataService.accountDSer.AccountDSer;
import edu.nju.umr.dataService.accountDSer.CountDSer;
import edu.nju.umr.dataService.checkDSer.BusiCircumDSer;
import edu.nju.umr.dataService.checkDSer.CollectRecordDSer;
import edu.nju.umr.dataService.checkDSer.CostBeneDSer;
import edu.nju.umr.dataService.checkDSer.DiaryDSer;
import edu.nju.umr.dataService.cityDSer.CityDSer;
import edu.nju.umr.dataService.cityDSer.ConstantDSer;
import edu.nju.umr.dataService.dataFactory.AccountDFacSer;
import edu.nju.umr.dataService.dataFactory.ArriveOrderDFacSer;
import edu.nju.umr.dataService.dataFactory.CenterLoadingOrderDFacSer;
import edu.nju.umr.dataService.dataFactory.CityDFacSer;
import edu.nju.umr.dataService.dataFactory.CollectFormDFacSer;
import edu.nju.umr.dataService.dataFactory.ConstantDFacSer;
import edu.nju.umr.dataService.dataFactory.CostBeneDFacSer;
import edu.nju.umr.dataService.dataFactory.CountDFacSer;
import edu.nju.umr.dataService.dataFactory.CourierDFacSer;
import edu.nju.umr.dataService.dataFactory.CustomerDFacSer;
import edu.nju.umr.dataService.dataFactory.DiaryDFacSer;
import edu.nju.umr.dataService.dataFactory.DiaryUpdateDFacSer;
import edu.nju.umr.dataService.dataFactory.DriverManDFacSer;
import edu.nju.umr.dataService.dataFactory.ExpressOrderDFacSer;
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
import edu.nju.umr.dataService.dataFactory.UpdateTransitInfoDFacSer;
import edu.nju.umr.dataService.dataFactory.UserManDFacSer;
import edu.nju.umr.dataService.dataFactory.UtilityDFacSer;
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
import edu.nju.umr.dataService.orderNewDSer.UpdateTransitInfoDSer;
import edu.nju.umr.dataService.stockDSer.StockCheckDSer;
import edu.nju.umr.dataService.stockDSer.StockCheckNowDSer;
import edu.nju.umr.dataService.stockDSer.StockCheckWarnDSer;
import edu.nju.umr.dataService.stockDSer.StockDivideDSer;
import edu.nju.umr.dataService.stockDSer.StockWarningDSer;
import edu.nju.umr.dataService.transitInfoDSer.CourierDSer;
import edu.nju.umr.dataService.transitInfoDSer.CustomerDSer;
import edu.nju.umr.dataService.userDSer.LoginDSer;
import edu.nju.umr.dataService.userDSer.UserManDSer;
import edu.nju.umr.dataService.utilityDSer.DiaryUpdateDSer;
import edu.nju.umr.dataService.utilityDSer.UtilityDSer;
import edu.nju.umr.dataService.workOrgManDSer.DriverManDSer;
import edu.nju.umr.dataService.workOrgManDSer.OrgManDSer;
import edu.nju.umr.dataService.workOrgManDSer.VanManDSer;
import edu.nju.umr.dataService.workOrgManDSer.WageManDSer;
import edu.nju.umr.dataService.workOrgManDSer.WorkManDSer;

public class DataFactory extends UnicastRemoteObject implements AccountDFacSer,ArriveOrderDFacSer,CenterLoadingOrderDFacSer,CityDFacSer,StatementSheetDFacSer,CountDFacSer,CourierDFacSer,CustomerDFacSer,
DiaryDFacSer,DriverManDFacSer,ExpressOrderDFacSer,HallLoadingOrderDFacSer,IncomeOrderDFacSer,LoginDFacSer,OrderApproveDFacSer,OrderResubmitDFacSer,OrgManDFacSer,PaymentOrderDFacSer,
RecipientOrderDFacSer,SendOrderDFacSer,CollectFormDFacSer,StockCheckDFacSer,StockCheckNowDFacSer,StockCheckWarnDFacSer,StockDivideDFacSer,StockInOrderDFacSer,StockOutOrderDFacSer,
StockWarningDFacSer,TransitOrderDFacSer,UserManDFacSer,VanManDFacSer,WorkManDFacSer,UtilityDFacSer,CostBeneDFacSer,ConstantDFacSer,UpdateTransitInfoDFacSer,WageManDFacSer,
DiaryUpdateDFacSer,ReceiveOrderDFacSer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4770248218670922288L;

	public DataFactory() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public WorkManDSer getWorkMan() throws RemoteException {
		// TODO 自动生成的方法存根
		return new WorkManData();
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
		return new StockWarningData();
	}

	public StockOutOrderDSer getStockOutOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return new StockOutOrderData();
	}

	public StockInOrderDSer getStockInOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return new StockInOrderData();
	}

	public StockDivideDSer getStockDivide() throws RemoteException {
		// TODO 自动生成的方法存根
		return new StockDivideData();
	}

	public StockCheckWarnDSer getStockCheckWarn() throws RemoteException {
		// TODO 自动生成的方法存根
		return new StockCheckWarnData();
	}

	public StockCheckNowDSer getStockCheckNow() throws RemoteException {
		// TODO 自动生成的方法存根
		return new StockCheckNowData();
	}

	public StockCheckDSer getStockCheck() throws RemoteException {
		// TODO 自动生成的方法存根
		return new StockCheckData();
	}

	public CollectRecordDSer getCollectForm() throws RemoteException {
		// TODO 自动生成的方法存根
		return CollectRecordData.getCollectRecord();
	}

	public SendOrderDSer getSendOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return new SendOrderData();
	}

	public RecipientOrderDSer getRecipientOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return new RecipientOrderData();
	}

	public PaymentOrderDSer getPaymentOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return new PaymentOrderData();
	}

	public OrgManDSer getOrgMan() throws RemoteException {
		// TODO 自动生成的方法存根
		return new OrgManData();
	}

	public OrderApproveDSer getOrderApprove() throws RemoteException {
		// TODO 自动生成的方法存根
		return new OrderApproveData();
	}

	public LoginDSer getLogin() throws RemoteException {
		// TODO 自动生成的方法存根
		return new LoginData();
	}

	public IncomeOrderDSer getIncomeOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return new IncomeOrderData();
	}

	public HallLoadingOrderDSer getHallLoadingOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return new HallLoadingOrderData();
	}

	public DiaryDSer getDiary() throws RemoteException {
		// TODO 自动生成的方法存根
		return DiaryData.getDiary();
	}

	public CustomerDSer getCustomer() throws RemoteException {
		// TODO 自动生成的方法存根
		return new CustomerData();
	}

	public CourierDSer getCourier() throws RemoteException {
		// TODO 自动生成的方法存根
		return new CourierData();
	}

	public CountDSer getCountData() throws RemoteException {
		// TODO 自动生成的方法存根
		return CountData.getCountData();
	}

	public BusiCircumDSer getStatement() throws RemoteException {
		// TODO 自动生成的方法存根
		return BusiCircumData.getBusiCircumData();
	}

	public CityDSer getCity() throws RemoteException {
		// TODO 自动生成的方法存根
		return new CityData();
	}

	public CenterLoadingOrderDSer getCenterLoadingOrder()
			throws RemoteException {
		// TODO 自动生成的方法存根
		return new CenterLoadingOrderData();
	}

	public ArriveOrderDSer getArriveOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return new ArriveOrderData();
	}

	public AccountDSer getAccountData() throws RemoteException {
		// TODO 自动生成的方法存根
		return AccountData.getAccountData();
	}

	public OrderResubmitDSer getOrderResubmit() throws RemoteException {
		// TODO 自动生成的方法存根
		return new OrderResubmitData();
	}

	public ExpressOrderDSer getExpressOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return new ExpressOrderData();
	}

	public DriverManDSer getDriverMan() throws RemoteException {
		// TODO 自动生成的方法存根
		return new DriverManData();
	}

	public UtilityDSer getUtility() throws RemoteException {
		// TODO 自动生成的方法存根
		return new UtilityData();
	}

	public CostBeneDSer getCostBene() throws RemoteException {
		// TODO 自动生成的方法存根
		return CostBeneData.getCostBene();
	}
	
	public ConstantDSer getConstant() throws RemoteException {
		return new ConstantData();
	}
	
	public UpdateTransitInfoDSer getUpdateTransitInfoDSer() throws RemoteException{
		return new UpdateTransitInfoData();
	}

	@Override
	public WageManDSer getWageMan() throws RemoteException {
		// TODO 自动生成的方法存根
		return new WageManData();
	}

	@Override
	public DiaryUpdateDSer getDiaryUpdate() throws RemoteException {
		// TODO 自动生成的方法存根
		return new DiaryUpdateData();
	}

	@Override
	public ReceiveOrderDSer getReceiveOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return new ReceiveOrderData();
	}

}
