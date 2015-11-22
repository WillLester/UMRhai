package edu.nju.umr.logic.orderNewLogic;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logicService.orderNewLogic.StockOutOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.StockOutPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.StockOutVO;
import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.StockOutOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.StockOutOrderDSer;

public class StockOutOrderLogic implements StockOutOrderLSer{
	StockOutOrderDFacSer dataFac;
	StockOutOrderDSer stockoutData;
	UtilityLogic uti;

	public StockOutOrderLogic(){
		try{
			dataFac=(StockOutOrderDFacSer)Naming.lookup(Url.URL);
			stockoutData=dataFac.getStockOutOrder();
			uti=new UtilityLogic();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public Result create(StockOutVO order) {
		boolean isSuccessful=false;
		try{
			StockOutPO orderPO=new StockOutPO("",order.getExpressId(),order.getDate(),order.getKind(),order.getTransitId(),Calendar.getInstance(),order.getOpName());
			stockoutData.create(orderPO);
			isSuccessful=true;
		}
		catch(Exception e)
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
//			ar=stockoutData.getCities();
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

}
