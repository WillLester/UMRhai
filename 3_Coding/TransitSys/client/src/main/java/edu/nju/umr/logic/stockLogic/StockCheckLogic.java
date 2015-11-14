package edu.nju.umr.logic.stockLogic;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.dataService.dataFactory.StockCheckDFacSer;
import edu.nju.umr.dataService.stockDSer.StockCheckDSer;
import edu.nju.umr.logicService.stockLogicSer.StockCheckLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.StockInPO;
import edu.nju.umr.po.order.StockOutPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.StockInVO;
import edu.nju.umr.vo.order.StockOutVO;

public class StockCheckLogic implements StockCheckLSer{
	StockCheckDFacSer dataFac;
	StockCheckDSer checkData;
	
	public StockCheckLogic(){
		try {
			dataFac=(StockCheckDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
			checkData=dataFac.getStockCheck();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public ResultMessage checkStockIn(Date start, Date end, String id) {
		// TODO 自动生成的方法存根
		ArrayList<StockInPO> ar=new ArrayList<StockInPO>();
		boolean isSuccessful=false;
		try{
			ar=checkData.getIn(start, end, id);
			isSuccessful=true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		ArrayList<StockInVO> arVO=new ArrayList<StockInVO>();
		for(int i=0;i<ar.size();i++){
			StockInPO order=ar.get(i);
			arVO.add(new StockInVO(order.getId(), order.getExpressId(), order.getDate(), order.getArrivePlace(), order.getPart(), order.getShelfId(), order.getRow(), order.getPlace()));
		}
		ResultMessage message = new ResultMessage(Result.SUCCESS, arVO);
		return message;
	}

	public ResultMessage checkStockOut(Date start, Date end, String id) {
		// TODO 自动生成的方法存根
		ArrayList<StockOutPO> ar=new ArrayList<StockOutPO>();
		boolean isSuccessful=false;
		try{
			ar=checkData.getOut(start, end, id);
			isSuccessful=true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		ArrayList<StockOutVO> arVO=new ArrayList<StockOutVO>();
		for(int i=0;i<ar.size();i++){
			StockOutPO order=ar.get(i);
			arVO.add(new StockOutVO(order.getId(),order.getExpressId(),order.getDate(),order.getKind(),order.getTransitId()));
		}
		ResultMessage message = new ResultMessage(Result.SUCCESS, arVO);
		return message;
	}

}
