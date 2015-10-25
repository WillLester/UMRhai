package edu.nju.umr.logic.stockLogic;

import java.rmi.Naming;
import java.util.ArrayList;

import edu.nju.umr.logicService.stockLogicSer.StockCheckWarnLSer;
import edu.nju.umr.dataService.dataFactory.StockCheckWarnDFacSer;
import edu.nju.umr.dataService.stockDSer.StockCheckWarnDSer;
import edu.nju.umr.vo.ResultMessage;


public class StockCheckWarnLogic implements StockCheckWarnLSer{
	StockCheckWarnDFacSer dataFac;
	StockCheckWarnDSer checkData;
	
	public StockCheckWarnLogic(){
		try{
		dataFac=(StockCheckWarnDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
		checkData=dataFac.getStockCheckWarn();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public ResultMessage checkWarning(String id) {
		// TODO 自动生成的方法存根
		boolean isSuccessful=false;
		ArrayList<Integer> ar=new ArrayList<Integer>();
		try{
			ar=checkData.getWarning(id);
			isSuccessful=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		ResultMessage message=new ResultMessage(isSuccessful,ar);
		return message;
	}

}
