package edu.nju.umr.data.dataFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.nju.umr.data.accountData.AccountData;
import edu.nju.umr.data.accountData.CountData;
import edu.nju.umr.data.checkData.BusiCircumData;
import edu.nju.umr.data.checkData.CostBeneData;
import edu.nju.umr.data.checkData.DiaryData;
import edu.nju.umr.data.checkData.IncomeListData;
import edu.nju.umr.data.cityData.CityData;
import edu.nju.umr.data.cityData.ConstantData;
import edu.nju.umr.data.orderApproveData.AccountUpdateData;
import edu.nju.umr.data.orderApproveData.GoodUpdateData;
import edu.nju.umr.data.orderApproveData.OrderApproveData;
import edu.nju.umr.data.orderApproveData.OrderResubmitData;
import edu.nju.umr.data.orderApproveData.UpdateTranStateData;
import edu.nju.umr.data.orderApproveData.UpdateTransitInfoData;
import edu.nju.umr.data.orderNewData.ArriveOrderData;
import edu.nju.umr.data.orderNewData.CenterLoadingOrderData;
import edu.nju.umr.data.orderNewData.ConstantGetData;
import edu.nju.umr.data.orderNewData.ExpressOrderData;
import edu.nju.umr.data.orderNewData.HallLoadingOrderData;
import edu.nju.umr.data.orderNewData.IncomeOrderData;
import edu.nju.umr.data.orderNewData.OrderCalcuData;
import edu.nju.umr.data.orderNewData.PaymentOrderData;
import edu.nju.umr.data.orderNewData.ReceiveOrderData;
import edu.nju.umr.data.orderNewData.RecipientOrderData;
import edu.nju.umr.data.orderNewData.SendOrderData;
import edu.nju.umr.data.orderNewData.StockInOrderData;
import edu.nju.umr.data.orderNewData.StockOutOrderData;
import edu.nju.umr.data.orderNewData.TransitOrderData;
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
import edu.nju.umr.data.utilityData.OrderInfoData;
import edu.nju.umr.data.utilityData.UtilityData;
import edu.nju.umr.data.workOrgManData.DriverManData;
import edu.nju.umr.data.workOrgManData.OrgManData;
import edu.nju.umr.data.workOrgManData.VanManData;
import edu.nju.umr.data.workOrgManData.WageManData;
import edu.nju.umr.data.workOrgManData.WorkManData;
import edu.nju.umr.dataService.accountDSer.AccountDSer;
import edu.nju.umr.dataService.accountDSer.CountDSer;
import edu.nju.umr.dataService.checkDSer.BusiCircumDSer;
import edu.nju.umr.dataService.checkDSer.CostBeneDSer;
import edu.nju.umr.dataService.checkDSer.DiaryDSer;
import edu.nju.umr.dataService.checkDSer.IncomeListDSer;
import edu.nju.umr.dataService.cityDSer.CityDSer;
import edu.nju.umr.dataService.cityDSer.ConstantDSer;
import edu.nju.umr.dataService.dataFactory.CityDFacSer;
import edu.nju.umr.dataService.dataFactory.ConstantDFacSer;
import edu.nju.umr.dataService.dataFactory.CourierDFacSer;
import edu.nju.umr.dataService.dataFactory.CustomerDFacSer;
import edu.nju.umr.dataService.dataFactory.DriverManDFacSer;
import edu.nju.umr.dataService.dataFactory.LoginDFacSer;
import edu.nju.umr.dataService.dataFactory.OrderApproveDFacSer;
import edu.nju.umr.dataService.dataFactory.OrderResubmitDFacSer;
import edu.nju.umr.dataService.dataFactory.OrgManDFacSer;
import edu.nju.umr.dataService.dataFactory.StockCheckDFacSer;
import edu.nju.umr.dataService.dataFactory.StockCheckNowDFacSer;
import edu.nju.umr.dataService.dataFactory.StockCheckWarnDFacSer;
import edu.nju.umr.dataService.dataFactory.StockDivideDFacSer;
import edu.nju.umr.dataService.dataFactory.StockWarningDFacSer;
import edu.nju.umr.dataService.dataFactory.UserManDFacSer;
import edu.nju.umr.dataService.dataFactory.VanManDFacSer;
import edu.nju.umr.dataService.dataFactory.WageManDFacSer;
import edu.nju.umr.dataService.dataFactory.WorkManDFacSer;
import edu.nju.umr.dataService.dataFactory.account.AccountDFacSer;
import edu.nju.umr.dataService.dataFactory.account.CountDFacSer;
import edu.nju.umr.dataService.dataFactory.check.BusiCircumDFacSer;
import edu.nju.umr.dataService.dataFactory.check.IncomeListDFacSer;
import edu.nju.umr.dataService.dataFactory.check.CostBeneDFacSer;
import edu.nju.umr.dataService.dataFactory.check.DiaryDFacSer;
import edu.nju.umr.dataService.dataFactory.orderNew.ArriveOrderDFacSer;
import edu.nju.umr.dataService.dataFactory.orderNew.CenterLoadingOrderDFacSer;
import edu.nju.umr.dataService.dataFactory.orderNew.ExpressOrderDFacSer;
import edu.nju.umr.dataService.dataFactory.orderNew.HallLoadingOrderDFacSer;
import edu.nju.umr.dataService.dataFactory.orderNew.IncomeOrderDFacSer;
import edu.nju.umr.dataService.dataFactory.orderNew.PaymentOrderDFacSer;
import edu.nju.umr.dataService.dataFactory.orderNew.ReceiveOrderDFacSer;
import edu.nju.umr.dataService.dataFactory.orderNew.RecipientOrderDFacSer;
import edu.nju.umr.dataService.dataFactory.orderNew.SendOrderDFacSer;
import edu.nju.umr.dataService.dataFactory.orderNew.StockInOrderDFacSer;
import edu.nju.umr.dataService.dataFactory.orderNew.StockOutOrderDFacSer;
import edu.nju.umr.dataService.dataFactory.orderNew.TransitOrderDFacSer;
import edu.nju.umr.dataService.dataFactory.orderNew.UpdateTranStateDFacSer;
import edu.nju.umr.dataService.dataFactory.orderNew.UpdateTransitInfoDFacSer;
import edu.nju.umr.dataService.dataFactory.utility.AccountUpdateDFacSer;
import edu.nju.umr.dataService.dataFactory.utility.ConstantGetDFacSer;
import edu.nju.umr.dataService.dataFactory.utility.DiaryUpdateDFacSer;
import edu.nju.umr.dataService.dataFactory.utility.GoodUpdateDFacSer;
import edu.nju.umr.dataService.dataFactory.utility.OrderCalcuDFacSer;
import edu.nju.umr.dataService.dataFactory.utility.OrderInfoDFacSer;
import edu.nju.umr.dataService.dataFactory.utility.UtilityDFacSer;
import edu.nju.umr.dataService.orderApproveDSer.AccountUpdateDSer;
import edu.nju.umr.dataService.orderApproveDSer.ConstantGetDSer;
import edu.nju.umr.dataService.orderApproveDSer.GoodUpdateDSer;
import edu.nju.umr.dataService.orderApproveDSer.OrderApproveDSer;
import edu.nju.umr.dataService.orderApproveDSer.OrderResubmitDSer;
import edu.nju.umr.dataService.orderApproveDSer.UpdateTranStateDSer;
import edu.nju.umr.dataService.orderApproveDSer.UpdateTransitInfoDSer;
import edu.nju.umr.dataService.orderNewDSer.ArriveOrderDSer;
import edu.nju.umr.dataService.orderNewDSer.CenterLoadingOrderDSer;
import edu.nju.umr.dataService.orderNewDSer.ExpressOrderDSer;
import edu.nju.umr.dataService.orderNewDSer.HallLoadingOrderDSer;
import edu.nju.umr.dataService.orderNewDSer.IncomeOrderDSer;
import edu.nju.umr.dataService.orderNewDSer.OrderCalcuDSer;
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
import edu.nju.umr.dataService.utilityDSer.DiaryUpdateDSer;
import edu.nju.umr.dataService.utilityDSer.OrderInfoDSer;
import edu.nju.umr.dataService.utilityDSer.UtilityDSer;
import edu.nju.umr.dataService.workOrgManDSer.DriverManDSer;
import edu.nju.umr.dataService.workOrgManDSer.OrgManDSer;
import edu.nju.umr.dataService.workOrgManDSer.VanManDSer;
import edu.nju.umr.dataService.workOrgManDSer.WageManDSer;
import edu.nju.umr.dataService.workOrgManDSer.WorkManDSer;

public class DataFactory extends UnicastRemoteObject implements AccountDFacSer,ArriveOrderDFacSer,CenterLoadingOrderDFacSer,CityDFacSer,BusiCircumDFacSer,CountDFacSer,CourierDFacSer,CustomerDFacSer,
DiaryDFacSer,DriverManDFacSer,ExpressOrderDFacSer,HallLoadingOrderDFacSer,IncomeOrderDFacSer,LoginDFacSer,OrderApproveDFacSer,OrderResubmitDFacSer,OrgManDFacSer,PaymentOrderDFacSer,
RecipientOrderDFacSer,SendOrderDFacSer,IncomeListDFacSer,StockCheckDFacSer,StockCheckNowDFacSer,StockCheckWarnDFacSer,StockDivideDFacSer,StockInOrderDFacSer,StockOutOrderDFacSer,
StockWarningDFacSer,TransitOrderDFacSer,UserManDFacSer,VanManDFacSer,WorkManDFacSer,UtilityDFacSer,CostBeneDFacSer,ConstantDFacSer,UpdateTransitInfoDFacSer,WageManDFacSer,
DiaryUpdateDFacSer,ReceiveOrderDFacSer,OrderInfoDFacSer,ConstantGetDFacSer,OrderCalcuDFacSer,AccountUpdateDFacSer,UpdateTranStateDFacSer,GoodUpdateDFacSer {

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
		return WorkManData.getWorkMan();
	}

	public VanManDSer getVanMan() throws RemoteException {
		// TODO 自动生成的方法存根
		return VanManData.getVanMan();
	}

	public UserManDSer getUserMan() throws RemoteException {
		// TODO 自动生成的方法存根
		return UserManData.getUserMan();
	}

	public TransitOrderDSer getTransitOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return TransitOrderData.getTransitOrder();
	}

	public StockWarningDSer getStockWarning() throws RemoteException {
		// TODO 自动生成的方法存根
		return StockWarningData.getStockWarning();
	}

	public StockOutOrderDSer getStockOutOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return StockOutOrderData.getStockOutOrder();
	}

	public StockInOrderDSer getStockInOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return StockInOrderData.getStockInOrder();
	}

	public StockDivideDSer getStockDivide() throws RemoteException {
		// TODO 自动生成的方法存根
		return StockDivideData.getStockDivide();
	}

	public StockCheckWarnDSer getStockCheckWarn() throws RemoteException {
		// TODO 自动生成的方法存根
		return StockCheckWarnData.getStockCheckWarn();
	}

	public StockCheckNowDSer getStockCheckNow() throws RemoteException {
		// TODO 自动生成的方法存根
		return StockCheckNowData.getStockCheckNow();
	}

	public StockCheckDSer getStockCheck() throws RemoteException {
		// TODO 自动生成的方法存根
		return StockCheckData.getStockCheck();
	}

	public IncomeListDSer getIncomeList() throws RemoteException {
		// TODO 自动生成的方法存根
		return IncomeListData.getIncomeList();
	}

	public SendOrderDSer getSendOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return SendOrderData.getSendOrder();
	}

	public RecipientOrderDSer getRecipientOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return RecipientOrderData.getRecipientOrder();
	}

	public PaymentOrderDSer getPaymentOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return PaymentOrderData.getPaymentOrder();
	}

	public OrgManDSer getOrgMan() throws RemoteException {
		// TODO 自动生成的方法存根
		return OrgManData.getOrgMan();
	}

	public OrderApproveDSer getOrderApprove() throws RemoteException {
		// TODO 自动生成的方法存根
		return OrderApproveData.getOrderApprove();
	}

	public LoginDSer getLogin() throws RemoteException {
		// TODO 自动生成的方法存根
		return LoginData.getLogin();
	}

	public IncomeOrderDSer getIncomeOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return IncomeOrderData.getIncomeOrder();
	}

	public HallLoadingOrderDSer getHallLoadingOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return HallLoadingOrderData.getHallLoading();
	}

	public DiaryDSer getDiary() throws RemoteException {
		// TODO 自动生成的方法存根
		return DiaryData.getDiary();
	}

	public CustomerDSer getCustomer() throws RemoteException {
		// TODO 自动生成的方法存根
		return CustomerData.getCustomerData();
	}

	public CourierDSer getCourier() throws RemoteException {
		// TODO 自动生成的方法存根
		return CourierData.getCourierData();
	}

	public CountDSer getCountData() throws RemoteException {
		// TODO 自动生成的方法存根
		return CountData.getCountData();
	}

	public BusiCircumDSer getBusiCircum() throws RemoteException {
		// TODO 自动生成的方法存根
		return BusiCircumData.getBusiCircumData();
	}

	public CityDSer getCity() throws RemoteException {
		// TODO 自动生成的方法存根
		return CityData.getCity();
	}

	public CenterLoadingOrderDSer getCenterLoadingOrder()
			throws RemoteException {
		// TODO 自动生成的方法存根
		return CenterLoadingOrderData.getCenterLoading();
	}

	public ArriveOrderDSer getArriveOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return ArriveOrderData.getArriveOrder();
	}

	public AccountDSer getAccountData() throws RemoteException {
		// TODO 自动生成的方法存根
		return AccountData.getAccountData();
	}

	public OrderResubmitDSer getOrderResubmit() throws RemoteException {
		// TODO 自动生成的方法存根
		return OrderResubmitData.getOrderResubmit();
	}

	public ExpressOrderDSer getExpressOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return ExpressOrderData.getExpressOrder();
	}

	public DriverManDSer getDriverMan() throws RemoteException {
		// TODO 自动生成的方法存根
		return DriverManData.getDriverMan();
	}

	public UtilityDSer getUtility() throws RemoteException {
		// TODO 自动生成的方法存根
		return UtilityData.getUtility();
	}

	public CostBeneDSer getCostBene() throws RemoteException {
		// TODO 自动生成的方法存根
		return CostBeneData.getCostBene();
	}
	
	public ConstantDSer getConstant() throws RemoteException {
		return ConstantData.getConstantData();
	}
	
	public UpdateTransitInfoDSer getUpdateTransitInfoDSer() throws RemoteException{
		return UpdateTransitInfoData.getUpdateTransit();
	}

	@Override
	public WageManDSer getWageMan() throws RemoteException {
		// TODO 自动生成的方法存根
		return WageManData.getWageMan();
	}

	@Override
	public DiaryUpdateDSer getDiaryUpdate() throws RemoteException {
		// TODO 自动生成的方法存根
		return DiaryUpdateData.getDiaryUpdate();
	}

	@Override
	public ReceiveOrderDSer getReceiveOrder() throws RemoteException {
		// TODO 自动生成的方法存根
		return ReceiveOrderData.getReceiveOrder();
	}

	@Override
	public OrderInfoDSer getOrderInfo() throws RemoteException {
		// TODO 自动生成的方法存根
		return OrderInfoData.getOrderInfo();
	}

	@Override
	public ConstantGetDSer getConstantGet() throws RemoteException {
		// TODO 自动生成的方法存根
		return ConstantGetData.getConstantGet();
	}

	@Override
	public OrderCalcuDSer getOrderCalcu() throws RemoteException {
		// TODO 自动生成的方法存根
		return OrderCalcuData.getOrderCalcu();
	}

	@Override
	public AccountUpdateDSer getAccountUp() throws RemoteException {
		// TODO 自动生成的方法存根
		return AccountUpdateData.getAccountUp();
	}

	@Override
	public UpdateTranStateDSer getUpdateTranState() throws RemoteException {
		// TODO 自动生成的方法存根
		return UpdateTranStateData.getUpdateTranState();
	}

	@Override
	public GoodUpdateDSer getGoodUpdate() throws RemoteException {
		// TODO 自动生成的方法存根
		return GoodUpdateData.getGoodUpdate();
	}

}
