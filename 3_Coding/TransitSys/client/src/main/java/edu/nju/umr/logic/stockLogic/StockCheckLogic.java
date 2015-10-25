package edu.nju.umr.logic.stockLogic;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.logicService.stockLogicSer.StockCheckLSer;
import edu.nju.umr.po.order.OrderPO;
import edu.nju.umr.vo.order.OrderVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.dataService.dataFactory.StockCheckDFacSer;
import edu.nju.umr.dataService.stockDSer.StockCheckDSer;

public class StockCheckLogic implements StockCheckLSer{
	StockCheckDFacSer dataFac;
	StockCheckDSer checkData;
	
	public StockCheckLogic(){
		try
		{
			dataFac=(StockCheckDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
			checkData=dataFac.getStockCheck();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public ResultMessage checkStock(Date start, Date end, String id) {
		// TODO 自动生成的方法存根
		//ArrayList<OrderVO> ar=new ArrayList();
		//ar.add(new OrderVO("1",Order.EXPRESS,"sb1",new Date(),false));
		//ar.add(new OrderVO("2",Order.ARRIVE,"sb2",new Date(),true));
		ArrayList<OrderPO> ar=new ArrayList<OrderPO>();
		boolean isSuccessful=false;
		try{
			ar=checkData.getInOut(start, end, id);
			isSuccessful=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		ArrayList<OrderVO> arVO=new ArrayList<OrderVO>();
		for(int i=0;i<ar.size();i++)
		{
			OrderPO order=ar.get(i);
			arVO.add(new OrderVO(order.getId(),order.getKind(),order.getOperator(),order.getTime(),order.isPassed()));
		}
		ResultMessage message = new ResultMessage(isSuccessful, arVO);
		return message;
	}

}
