package edu.nju.umr.logic.stockLogic;

import java.rmi.Naming;
import java.util.ArrayList;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.StockWarningDFacSer;
import edu.nju.umr.dataService.stockDSer.StockWarningDSer;
import edu.nju.umr.logicService.stockLogicSer.StockWarningLSer;
import edu.nju.umr.po.enums.Part;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;

public class StockWarningLogic implements StockWarningLSer{
	StockWarningDFacSer dataFac;
	StockWarningDSer checkData;
	public StockWarningLogic(){
		try{
			dataFac=(StockWarningDFacSer)Naming.lookup(Url.URL);
			checkData=dataFac.getStockWarning();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
	}

	public Result setWarning(int w, Part part, String id) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.SUCCESS;
		try{
			isSuccessful=checkData.setWarning(w, part, id);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public ResultMessage getWarning(String id) {
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
		ResultMessage message=new ResultMessage(Result.SUCCESS,ar);
		return message;
	}

}
