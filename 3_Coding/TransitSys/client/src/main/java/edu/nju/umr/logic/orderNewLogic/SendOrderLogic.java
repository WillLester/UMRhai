package edu.nju.umr.logic.orderNewLogic;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.SendOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.SendOrderDSer;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.orderNewLogic.SendOrderLSer;
import edu.nju.umr.logicService.utilityLogicSer.DiaryUpdateLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.SendPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.SendVO;

public class SendOrderLogic implements SendOrderLSer{
	private SendOrderDFacSer dataFac;
	private SendOrderDSer sendData;
	private UtilityLogic uti=new UtilityLogic();
	private DiaryUpdateLSer diarySer;
	public SendOrderLogic(){
		try{
			dataFac=(SendOrderDFacSer)Naming.lookup(Url.URL);
			sendData=dataFac.getSendOrder();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		diarySer = new DiaryUpdateLogic();
	}
	public Result create(SendVO order) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.DATABASE_ERROR;
		try{
			SendPO orderPO=VPFactory.toSendPO(order, "");
			isSuccessful=sendData.create(orderPO);
			if(isSuccessful.equals(Result.SUCCESS)){
				isSuccessful = diarySer.addDiary("生成了派件单，派出"+order.getExpressId(), order.getOpName());
			}
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
		List<String> ar= null;
		try{
			ar = uti.getCouriers(id);
			isSuccessful=Result.SUCCESS;
			if(ar.isEmpty()){
				isSuccessful = Result.NET_INTERRUPT;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		ResultMessage message = new ResultMessage(isSuccessful, ar);
		return message;
	}
	@Override
	public ResultMessage getNextId(String orgId) {
		// TODO 自动生成的方法存根
		try{
			String date = DateFormat.DATESTRING.format(Calendar.getInstance().getTime());
			return new ResultMessage(Result.SUCCESS,sendData.getOrderSize(orgId+date));
		}catch(RemoteException e){
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
	}

}
