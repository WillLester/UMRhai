package edu.nju.umr.logic.orderNewLogic;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.orderNew.StockOutOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.StockOutOrderDSer;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logic.utilityLogic.OrderInfoLogic;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.orderNewLogic.StockOutOrderLSer;
import edu.nju.umr.logicService.orderNewLogic.UpdateTranStateLSer;
import edu.nju.umr.logicService.utilityLogicSer.DiaryUpdateLSer;
import edu.nju.umr.logicService.utilityLogicSer.OrderInfoLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.ExpressPO;
import edu.nju.umr.po.order.StockOutPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.StockOutVO;

public class StockOutOrderLogic implements StockOutOrderLSer{
	private StockOutOrderDFacSer dataFac;
	private StockOutOrderDSer stockoutData;
	private UtilityLogic uti=new UtilityLogic();
	private OrderInfoLSer orderInfo;
	private DiaryUpdateLSer diarySer;
	private UpdateTranStateLSer orderState;
	public StockOutOrderLogic(){
		try{
			dataFac=(StockOutOrderDFacSer)Naming.lookup(Url.URL);
			stockoutData=dataFac.getStockOutOrder();
		} catch (Exception e){
			e.printStackTrace();
		}
		uti = new UtilityLogic();
		orderInfo = new OrderInfoLogic();
		diarySer = new DiaryUpdateLogic();
		orderState=new UpdateTranStateLogic();
	}
	public Result create(StockOutVO order) {
		Result isSuccessful=Result.DATABASE_ERROR;
		try{
			StockOutPO orderPO = VPFactory.toStockOutPO(order);
			isSuccessful = stockoutData.create(orderPO);
			if(isSuccessful == Result.SUCCESS){
				isSuccessful = stockoutData.removeGood(order.getExpressId());
				if(isSuccessful == Result.SUCCESS){
					isSuccessful = diarySer.addDiary("为货物"+order.getExpressId()+"生成了出库单", order.getOpName());
				}
				if(isSuccessful.equals(Result.SUCCESS)){
					orderState.updateExpressState(order.getExpressId(), order.getStockId()+"*##");
				}
				
			}
		}catch(RemoteException e){
			return Result.NET_INTERRUPT;
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public ResultMessage getOrgs() {
		// TODO 自动生成的方法存根
		return uti.getOrgNames();
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
	public ResultMessage getNextId(String orgId){
		String time=DateFormat.DATESTRING.format(Calendar.getInstance().getTime());
		try{
			int num = stockoutData.getOrderSize(orgId+time);
			if(num==-1)
			{
				return new ResultMessage(Result.DATABASE_ERROR,null);
			}
			return new ResultMessage(Result.SUCCESS,num);
		}catch(RemoteException e)
		{
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage getGoingOrders(String org,String orgId) {
		ArrayList<String> ar = new ArrayList<String>();
		ResultMessage message=orderState.getGoingCenterLoading(org, false);
		Result result=message.getReInfo();
		if(!result.equals(Result.SUCCESS)){
			return new ResultMessage(result,null);
		}
		ArrayList<String> temp=((ArrayList<String>)message.getMessage());
		ArrayList<String> exp=new ArrayList<String>();
		ArrayList<ExpressPO> expPO=new ArrayList<ExpressPO>();
		for(String cl:temp){
			boolean allOut=true;
			exp.clear();
			exp.addAll(orderInfo.getCenterLoadExp(cl));
			expPO.clear();
			expPO.addAll(orderInfo.getExpresses(exp));
			for(ExpressPO p:expPO){
				if(p.getNowOrgId().equals(orgId+"*#")){
					allOut=false;
					break;
				}
			}
			if(!allOut){
				ar.add(cl);
			}
		}
		
		message=orderState.getGoingTransit(org, false);
		result=message.getReInfo();
		if(!result.equals(Result.SUCCESS)){
			return new ResultMessage(result,null);
		}
		temp=((ArrayList<String>)message.getMessage());
		exp=new ArrayList<String>();
		expPO=new ArrayList<ExpressPO>();
		for(String t:temp){
			boolean allOut=true;
			exp.clear();
			exp.addAll(orderInfo.getTransitExp(t));
			expPO.clear();
			expPO.addAll(orderInfo.getExpresses(exp));
			for(ExpressPO p:expPO){
				if(p.getNowOrgId().equals(orgId+"*#")){
					allOut=false;
					break;
				}
			}
			if(!allOut){
				ar.add(t);
			}
		}
		return new ResultMessage(Result.SUCCESS,ar);
	}
	@Override
	public ResultMessage getGoingExpress(String orderId,String orgId) {
		ArrayList<String> ar = new ArrayList<String>();
		ar.addAll(orderInfo.getCenterLoadExp(orderId));
		ar.addAll(orderInfo.getTransitExp(orderId));
		List<ExpressPO> ex=orderInfo.getExpresses(ar);
		ar.clear();
		for(ExpressPO po:ex){
			if(po.getNowOrgId().equals(orgId+"*#")){
				ar.add(po.getId());
			}
		}
		return new ResultMessage(Result.SUCCESS,ar);
	}

}
