package edu.nju.umr.logic.orderNewLogic;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.logicService.orderNewLogic.StockOutOrderLSer;
import edu.nju.umr.po.order.StockOutPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.StockOutVO;
import edu.nju.umr.dataService.dataFactory.StockOutOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.StockOutOrderDSer;

public class StockOutOrderLogic implements StockOutOrderLSer{
	StockOutOrderDFacSer dataFac;
	StockOutOrderDSer stockoutData;

	public StockOutOrderLogic(){
		try{
			dataFac=(StockOutOrderDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
			stockoutData=dataFac.getStockOutOrder();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public boolean create(StockOutVO order) {
		boolean isSuccessful=false;
		try{
			StockOutPO orderPO=new StockOutPO(order.getId(),order.getExpressId(),order.getDate(),order.getKind(),order.getTransitId(),Calendar.getInstance());
			stockoutData.create(orderPO);
			isSuccessful=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public ResultMessage getCities() {
		// TODO 自动生成的方法存根
		ArrayList<String> ar= null;
		boolean isSuccessful=false;
		try{
			ar=stockoutData.getCities();
			isSuccessful=true;
		}
		catch(RemoteException e){
			e.printStackTrace();
		}
		ArrayList<String> arVO=new ArrayList<String>();
		for(int i=0;i<ar.size();i++)
		{
			arVO.add(ar.get(i));
		}
		ResultMessage message = new ResultMessage(isSuccessful, arVO);
		return message;
	}

}
