package edu.nju.umr.logic.orderNewLogic;

import java.rmi.Naming;
import java.rmi.RemoteException;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.StockOutOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.StockOutOrderDSer;
import edu.nju.umr.logic.utilityLogic.OrderInfoLogic;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.orderNewLogic.StockOutOrderLSer;
import edu.nju.umr.logicService.utilityLogicSer.OrderInfoLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.StockOutPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.StockOutVO;

public class StockOutOrderLogic implements StockOutOrderLSer{
	private StockOutOrderDFacSer dataFac;
	private StockOutOrderDSer stockoutData;
	private UtilityLogic uti=new UtilityLogic();
	private OrderInfoLSer orderInfo;
	public StockOutOrderLogic(){
		try{
			dataFac=(StockOutOrderDFacSer)Naming.lookup(Url.URL);
			stockoutData=dataFac.getStockOutOrder();
		} catch (Exception e){
			e.printStackTrace();
		}
		uti = new UtilityLogic();
		orderInfo = new OrderInfoLogic();
	}
	public Result create(StockOutVO order) {
		Result isSuccessful=Result.DATABASE_ERROR;
		try{
			StockOutPO orderPO = VPFactory.toStockOutPO(order, 0);
			isSuccessful = stockoutData.create(orderPO);
			isSuccessful = stockoutData.removeGood(order.getExpressId());
		}catch(RemoteException e){
			return Result.NET_INTERRUPT;
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public ResultMessage getCities() {
		// TODO 自动生成的方法存根
		return uti.getCities();
	}
	@Override
	public boolean isExpressValid(String id) {
		// TODO 自动生成的方法存根
		return orderInfo.isExpressValid(id);
	}
	@Override
	public boolean isTransitValid(String id) {
		// TODO 自动生成的方法存根
		return orderInfo.isTransitValid(id);
	}
	@Override
	public boolean isConveyValid(String id) {
		// TODO 自动生成的方法存根
		return orderInfo.isCenterLoadValid(id);
	}

}
