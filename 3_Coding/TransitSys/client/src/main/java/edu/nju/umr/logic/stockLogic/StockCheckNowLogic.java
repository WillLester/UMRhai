package edu.nju.umr.logic.stockLogic;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.dataService.dataFactory.StockCheckNowDFacSer;
import edu.nju.umr.dataService.stockDSer.StockCheckNowDSer;
import edu.nju.umr.logicService.stockLogicSer.StockCheckNowLSer;
import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.StockPO;
import edu.nju.umr.vo.GoodVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.StockVO;

public class StockCheckNowLogic implements StockCheckNowLSer{
	StockCheckNowDFacSer dataFac;
	StockCheckNowDSer checkData;
	
	public StockCheckNowLogic(){
		try
		{
			dataFac=(StockCheckNowDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
			checkData=dataFac.getStockCheckNow();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public ResultMessage checkNow(String id) {
		// TODO 自动生成的方法存根
		boolean isSuccessful=false;
		StockPO stock=null;
		try{
			stock=checkData.getStock(id);
			isSuccessful=true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		ArrayList<GoodPO> ar=stock.getGoods();
		ArrayList<GoodVO> arVO=new ArrayList<GoodVO>();
		for(int i=0;i<ar.size();i++)
		{
			GoodPO good=ar.get(i);
			arVO.add(new GoodVO(good.getId(),good.getDate(),good.getCity(),good.getPart(),good.getShelf(),good.getRow(),good.getPlace()));
		}
		ResultMessage message=new ResultMessage(isSuccessful,new StockVO(arVO));
		return message;
	}

	public boolean setPoint(String id, Date date) {
		// TODO 自动生成的方法存根
		boolean isSuccessful=false;
		try
		{
			isSuccessful=checkData.setPoint(id, date);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public boolean outputExcel(String location, StockVO stock) {
		// TODO 自动生成的方法存根
		boolean isSuccessful=false;
		ArrayList<GoodVO> arVO=stock.getGoods();
		ArrayList<GoodPO> ar=new ArrayList<GoodPO>();
		for(int i=0;i<arVO.size();i++)
		{
			GoodVO good=arVO.get(i);
			ar.add(new GoodPO(good.getId(),good.getDate(),good.getCity(),good.getPart(),good.getShelf(),good.getRow(),good.getPlace()));
		}
//		StockPO stockPO=new StockPO(ar);
//		try{
//			isSuccessful=checkData.outputExcel(location, stockPO);
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
		return isSuccessful;
	}

}
