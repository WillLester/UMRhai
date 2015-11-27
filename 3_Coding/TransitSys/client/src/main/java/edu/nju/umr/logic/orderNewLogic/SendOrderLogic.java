package edu.nju.umr.logic.orderNewLogic;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.SendOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.SendOrderDSer;
import edu.nju.umr.logicService.orderNewLogic.SendOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.SendPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.SendVO;

public class SendOrderLogic implements SendOrderLSer{
	SendOrderDFacSer dataFac;
	SendOrderDSer sendData;
	public SendOrderLogic(){
		try{
			dataFac=(SendOrderDFacSer)Naming.lookup(Url.URL);
			sendData=dataFac.getSendOrder();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public Result create(SendVO order) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.DATABASE_ERROR;
		try{
			SendPO orderPO=new SendPO(order.getDate(),order.getExpressId(),"",order.getCourier(),Calendar.getInstance(),order.getOpName());
			isSuccessful=sendData.create(orderPO);
		}catch(RemoteException e){
			return Result.NET_INTERRUPT;
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public ResultMessage getCouriers(String id) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.DATABASE_ERROR;
		ArrayList<String> ar= null;
		try{
			ar=sendData.getCouriers();
			isSuccessful=Result.SUCCESS;
		}catch(RemoteException e){
			return new ResultMessage(Result.NET_INTERRUPT, Result.NET_INTERRUPT);
		}catch(Exception e){
			e.printStackTrace();
		}
		ResultMessage message = new ResultMessage(isSuccessful, ar);
		return message;
	}

}
