package edu.nju.umr.logic.orderNewLogic;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.SendOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.SendOrderDSer;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.orderNewLogic.SendOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.SendPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.SendVO;

public class SendOrderLogic implements SendOrderLSer{
	private SendOrderDFacSer dataFac;
	private SendOrderDSer sendData;
	private UtilityLogic uti=new UtilityLogic();
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
			SendPO orderPO=VPFactory.toSendPO(order, "");
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
		Result isSuccessful=Result.DATA_NOT_FOUND;
		ArrayList<String> ar= null;
		try{
			ar=uti.getCouriers(id);
			isSuccessful=Result.SUCCESS;
		}catch(RemoteException e){
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}catch(Exception e){
			e.printStackTrace();
		}
		ResultMessage message = new ResultMessage(isSuccessful, ar);
		return message;
	}

}
