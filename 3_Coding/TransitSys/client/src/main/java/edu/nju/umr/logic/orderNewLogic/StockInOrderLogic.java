package edu.nju.umr.logic.orderNewLogic;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.StockInOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.StockInOrderDSer;
import edu.nju.umr.logic.stockLogic.StockCheckWarnLogic;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logicService.orderNewLogic.StockInOrderLSer;
import edu.nju.umr.logicService.stockLogicSer.StockCheckWarnLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.StockInPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.StockInVO;

public class StockInOrderLogic implements StockInOrderLSer{
	StockInOrderDFacSer dataFac;
	StockInOrderDSer stockinData;
	UtilityLogic uti;

	public StockInOrderLogic(){
		try{
			dataFac=(StockInOrderDFacSer)Naming.lookup(Url.URL);
			stockinData=dataFac.getStockInOrder();
			uti=new UtilityLogic();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public Result create(StockInVO order) {
		try{
			StockInPO orderPO=new StockInPO(1,order.getExpressId(),order.getDate(),order.getArrivePlace(),order.getPart(),order.getShelfId(),order.getRow(),order.getPlace(),Calendar.getInstance(),order.getOpName(),order.getStockId());
			stockinData.create(orderPO);
		}catch(RemoteException e){
			return Result.NET_INTERRUPT;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return Result.SUCCESS;
	}

	public ResultMessage getCities() {
		// TODO 自动生成的方法存根
//		ArrayList<String> ar= null;
//		boolean isSuccessful=false;
//		try{
//			ar=stockinData.getCities();
//			isSuccessful=true;
//		}
//		catch(RemoteException e){
//			e.printStackTrace();
//		}
//		ArrayList<String> arVO=new ArrayList<String>();
//		for(int i=0;i<ar.size();i++)
//		{
//			arVO.add(ar.get(i));
//		}
//		ResultMessage message = new ResultMessage(Result.SUCCESS, arVO);
//		return message;
		return uti.getCities();
	}
	public Result checkWarning(String id){
		StockCheckWarnLSer checkWarn = new StockCheckWarnLogic();
		return (Result) checkWarn.checkWarning(id).getMessage();
	}
	@Override
	public ResultMessage getShelves(String orgId) {
		// TODO Auto-generated method stub
		return uti.getShelves(orgId);
	}
}
