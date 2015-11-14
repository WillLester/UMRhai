package edu.nju.umr.logic.orderNewLogic;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.logicService.orderNewLogic.StockInOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.StockInPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.StockInVO;
import edu.nju.umr.dataService.dataFactory.StockInOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.StockInOrderDSer;

public class StockInOrderLogic implements StockInOrderLSer{
	StockInOrderDFacSer dataFac;
	StockInOrderDSer stockinData;

	public StockInOrderLogic(){
		try{
			dataFac=(StockInOrderDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
			stockinData=dataFac.getStockInOrder();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public Result create(StockInVO order) {
		try{
			StockInPO orderPO=new StockInPO(order.getId(),order.getExpressId(),order.getDate(),order.getArrivePlace(),order.getPart(),order.getShelfId(),order.getRow(),order.getPlace(),Calendar.getInstance());
			stockinData.create(orderPO);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Result.SUCCESS;
	}

	public ResultMessage getCities() {
		// TODO 自动生成的方法存根
		ArrayList<String> ar= null;
		boolean isSuccessful=false;
		try{
			ar=stockinData.getCities();
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
		ResultMessage message = new ResultMessage(Result.SUCCESS, arVO);
		return message;
	}

}
