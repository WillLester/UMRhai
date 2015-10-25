package edu.nju.umr.logic.orderNewLogic;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.logicService.orderNewLogic.SendOrderLSer;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.SendVO;
import edu.nju.umr.po.order.SendPO;
import edu.nju.umr.dataService.dataFactory.SendOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.SendOrderDSer;

public class SendOrderLogic implements SendOrderLSer{
	SendOrderDFacSer dataFac;
	SendOrderDSer sendData;
	public SendOrderLogic(){
		try{
			dataFac=(SendOrderDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
			sendData=dataFac.getSendOrder();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public boolean create(SendVO order) {
		// TODO 自动生成的方法存根
		boolean isSuccessful=false;
		try{
			SendPO orderPO=new SendPO(order.getDate(),order.getExpressId(),order.getId(),order.getCourier());
			sendData.create(orderPO);
			isSuccessful=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public ResultMessage getCouriers(String id) {
		// TODO 自动生成的方法存根
		ArrayList<String> ar= null;
		boolean isSuccessful=false;
		try{
			ar=sendData.getCouriers();
			isSuccessful=true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		ResultMessage message = new ResultMessage(isSuccessful, ar);
		return message;
	}

}
