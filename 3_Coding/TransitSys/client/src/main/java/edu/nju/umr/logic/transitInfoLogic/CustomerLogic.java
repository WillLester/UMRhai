package edu.nju.umr.logic.transitInfoLogic;

import java.rmi.Naming;
import java.util.ArrayList;

import edu.nju.umr.logicService.transitInfoLogicSer.CustomerLogicSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.url.Url;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.dataService.dataFactory.CustomerDFacSer;
import edu.nju.umr.dataService.transitInfoDSer.CustomerDSer;

public class CustomerLogic implements CustomerLogicSer{
	CustomerDFacSer dataFac;
	CustomerDSer transitData;
	
	public CustomerLogic(){
		try{
			dataFac=(CustomerDFacSer)Naming.lookup(Url.URL);
			transitData=dataFac.getCustomer();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public ResultMessage enterBarcodeCustomer(String barcode) {
		// TODO 自动生成的方法存根
		boolean isSuccessful=false;
		ArrayList<String> ar=null;
		try{
			ar=transitData.findTransit(barcode);
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
